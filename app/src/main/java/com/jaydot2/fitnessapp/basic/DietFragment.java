package com.jaydot2.fitnessapp.basic;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jamesbray on 6/4/16.
 */
public class DietFragment extends Fragment {

    public static final String TAG = "DietFragment";

    private CardView mealCard01;
    private CardView mealCard02;
    private CardView mealCard03;
    private CardView mealCard04;
    private CardView mealCard05;
    private CardView mealCard06;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_diet, container, false);

        mealCard01 = (CardView)v.findViewById(R.id.meal01);
        //TODO add logic here

        return v;
    }
}
