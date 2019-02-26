package css.cis3334.heartratetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
/**
 * Created by Tom Gibbons in Feb 2017.
 * For the CIS 3334 class at St. Scholastica
 */

public class MainActivity extends AppCompatActivity {

    ListView lvHeartRates;
    TextView tvSelect;
    HeartRateList heartRateList;
    ArrayAdapter<HeartRate> hrAdapter;

    public static final String HEARTRATE_KEY = "HEARTRATE_KEY";
    //ArrayList<HeartRate> basicheartRateList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSelect = (TextView) findViewById(R.id.textView);
        lvHeartRates = (ListView) findViewById(R.id.listViewHeartRates);

        heartRateList = new HeartRateList();
        heartRateList.InitRandomElderly();

        //ArrayAdapter<HeartRate> planetAdapter = new ArrayAdapter<HeartRate>(this, android.R.layout.simple_list_item_1, basicheartRateList);
        hrAdapter = new HeartRateAdapter(this, R.layout.heart_rate_row, R.id.textViewPulse, heartRateList);
        hrAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        lvHeartRates.setAdapter(hrAdapter);
////////////////////////////////////////////////////////
        hrAdapter = new HeartRateAdapter(this, R.layout.heart_rate_row, R.id.textViewRange, heartRateList);
        hrAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        lvHeartRates.setAdapter(hrAdapter);

        hrAdapter = new HeartRateAdapter(this, R.layout.heart_rate_row, R.id.textViewDescription, heartRateList);
        hrAdapter.setDropDownViewResource(R.layout.heart_rate_row);
        lvHeartRates.setAdapter(hrAdapter);
//////////////////////////////////////////////////////////

        lvHeartRates.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                HeartRate hr = (HeartRate) parent.getItemAtPosition(position);
                tvSelect.setText("You selected: " + hr.toString());

                Intent detailActIntent = new Intent(parent.getContext(), HeartDetailActivity.class);
                detailActIntent.putExtra(HEARTRATE_KEY, hr);
                startActivity(detailActIntent);
            }
        });

    }
}