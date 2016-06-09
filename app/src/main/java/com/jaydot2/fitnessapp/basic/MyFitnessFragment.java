package com.jaydot2.fitnessapp.basic;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/**
 * Created by jamesbray on 6/4/16.
 */
public class MyFitnessFragment extends Fragment {

    public static final String TAG = "MyFitnessFragment";


    private Spinner fitnessGoalsSpinner;
    private ArrayAdapter<CharSequence> fitnessGoalsAdapter;

    public MyFitnessFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater,container,savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_myfitness, container, false);

        //TODO add logic here
        fitnessGoalsSpinner = (Spinner) v.findViewById(R.id.fitnessGoalsSpinner);
        fitnessGoalsAdapter = ArrayAdapter.createFromResource(getContext(), R.array.fitness_goals_array, android.R.layout.simple_spinner_item);
        fitnessGoalsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fitnessGoalsSpinner.setAdapter(fitnessGoalsAdapter);

        return v;
    }
}
