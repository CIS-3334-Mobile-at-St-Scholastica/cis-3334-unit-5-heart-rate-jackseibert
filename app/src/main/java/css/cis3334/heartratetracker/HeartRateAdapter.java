package css.cis3334.heartratetracker;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import css.cis3334.heartratetracker.HeartRate;
import css.cis3334.heartratetracker.HeartRateList;
import css.cis3334.heartratetracker.R;

/**
 * Created by Tom Gibbons in Feb 2017.
 * For the CIS 3334 class at St. Scholastica
 */

public class HeartRateAdapter  extends ArrayAdapter<HeartRate> {

    private final Context context;      // The activity calling this adapter
    private HeartRateList hrList;       // The object holding the arraylist of hear rates

    /**
     *
     * @param context The activity calling this adapter
     * @param rowLayout The xml file defining the layout for one item or row in the list
     * @param dummyTV the ID for a TextView in the row layout. Not used, but needed by the parent object
     * @param hrList The object holding the arraylist of hear rates
     */
    public HeartRateAdapter(Context context, int rowLayout, int dummyTV, HeartRateList hrList) {
        super(context, rowLayout, dummyTV, hrList.getList());
        this.context = context;
        this.hrList = hrList;
    }

    /**
     * This is called automatically to display each item in the list.
     *    Here you must fill the layout for one row or item in the list
     *
     * @param position index in the list that is being selected
     * @param convertView
     * @param parent The parent layout this list is in
     * @return
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.heart_rate_row, null);
        //get the heart rate we are displaying
        HeartRate hr = hrList.getHeartRate(position);

        TextView tvPulse=(TextView)view.findViewById(R.id.textViewPulse);
        tvPulse.setText(hr.getPulse().toString());
        TextView tvRange=(TextView)view.findViewById(R.id.textViewRange);
        tvRange.setText(hr.getRangeName());
        TextView tvDescription=(TextView)view.findViewById(R.id.textViewDescription);
        tvDescription.setText(hr.getRangeDescrtiption());

        if(hr.getRangeName() == "Resting"){
            tvRange.setTextColor(ContextCompat.getColor(context, R.color.colorResting));
        }
        else if(hr.getRangeName() == "Moderate"){
            tvRange.setTextColor(ContextCompat.getColor(context, R.color.colorModerate));
        }
        else if(hr.getRangeName() == "Endurance"){
            tvRange.setTextColor(ContextCompat.getColor(context, R.color.colorEndurance));
        }
        else if(hr.getRangeName() == "Aerobic"){
            tvRange.setTextColor(ContextCompat.getColor(context, R.color.colorAerobic));
        }
        else if(hr.getRangeName() == "Anaerobic"){
            tvRange.setTextColor(ContextCompat.getColor(context, R.color.colorAnaerobic));
        }
        else {
            tvRange.setTextColor(ContextCompat.getColor(context, R.color.colorRedzone));
        }

        return(view);
    }


}