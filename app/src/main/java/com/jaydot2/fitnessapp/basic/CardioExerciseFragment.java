package com.jaydot2.fitnessapp.basic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * Created by jamesbray on 6/4/16.
 */
public class CardioExerciseFragment extends Fragment {

    public static final String TAG = "CardioExerciseFragment";

    private Button cardioStartButton;
    private Chronometer cardioChronometer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_cardio, container, false);

        cardioStartButton = (Button)v.findViewById(R.id.startCardioBtn);
        cardioChronometer = (Chronometer)v.findViewById(R.id.cardioChronometer);

        cardioStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cardioStartButton.getText().equals(getResources().getString(R.string.start))) {
                    cardioChronometer.start();
                    cardioStartButton.setText(getResources().getString(R.string.stop));
                } else {
                    cardioChronometer.stop();
                    cardioStartButton.setText(getResources().getString(R.string.start));
                }
            }
        });
        //TODO add logic here

        return v;
    }
}
