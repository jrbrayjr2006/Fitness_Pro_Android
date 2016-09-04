package com.jaydot2.fitnessapp.basic;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;

/**
 * <p>
 *     <b>License Agreeement</b>
 * </p>
 * <p>
 *     The Fitness Pro application is a personal health fitness management application designed to help individuals manage and track an exercise fitness program.
 *     Copyright (C) 2016  Jaydot2, LLC
 * </p>
 * <p>
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 * </p>
 * <p>
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 * </p>
 * <p>
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * </p>
 *
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
