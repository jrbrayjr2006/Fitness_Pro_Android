package com.jaydot2.fitnessapp.basic;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jamesbray on 6/4/16.
 */
public class StrengthExerciseFragment extends Fragment {

    public static final String TAG = "StrengthExerciseFragment";

    private CardView cardViewOne;
    private CardView cardViewTwo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_strength, container, false);

        //TODO add logic here
        cardViewOne = (CardView)v.findViewById(R.id.strengthOne);
        cardViewOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        cardViewTwo = (CardView)v.findViewById(R.id.strengthTwo);

        return v;
    }
}
