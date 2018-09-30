package com.jaydot2.fitnessapp.core;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * <b>Description:</b>
 * <p>
 *     This class is for diet and meal dialogs with detailed information
 * </p>
 * Created by jamesbray on 12/17/16.
 */

public class DietDialogFragment extends DialogFragment {

    private TextView dietTitleText;
    private ImageView dietImage;

    private String mealName;
    private Button detailsMealButton;
    private int imageResource;
    private TimePicker mealTimePicker;

    public DietDialogFragment() {
        super();
    }


    /**
     * <p>
     *     Custom dialog with a custom UI
     * </p>
     * @param savedInstanceState
     * @return
     */
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        Bundle extras = getArguments();

        mealName = extras.getString(DietFragment.MEAL_NAME);
        imageResource = extras.getInt(DietFragment.IMAGE_RESOURCE);


        // inflate custom view
        View v = inflater.inflate(R.layout.dialog_fragment_diet, null);

        dietTitleText = (TextView) v.findViewById(R.id.dietTitle);
        dietImage = (ImageView) v.findViewById(R.id.dietImage);
        mealTimePicker = (TimePicker) v.findViewById(R.id.mealTimePicker);

                builder.setView(v)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int hour = mealTimePicker.getHour();
                        int minute = mealTimePicker.getMinute();
                        Log.d("Time of meal", hour + ":" + minute);
                        //TODO log meal to internal storage
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DietDialogFragment.this.getDialog().cancel();
                    }
                });

        detailsMealButton = (Button)v.findViewById(R.id.dietLogMealBtn);
        detailsMealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO add implementation logic here
            }
        });


        return builder.create();
    }
}
