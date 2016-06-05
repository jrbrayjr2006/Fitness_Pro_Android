package com.jaydot2.fitnessapp.basic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jamesbray on 6/4/16.
 */
public class FlexibilityExerciseFragment extends Fragment {

    public static final String TAG = "FlexibilityExerciseFragment";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragement_flexibility, container, false);

        //TODO add logic here

        return v;
    }
}
