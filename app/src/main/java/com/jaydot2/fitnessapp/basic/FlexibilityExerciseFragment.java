package com.jaydot2.fitnessapp.basic;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.util.Log;

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
 * Created by jamesbray on 6/4/16.
 */
public class FlexibilityExerciseFragment extends Fragment {

    public static final String TAG = "FlexExerciseFragment";

    private CardView cardViewOne;
    private CardView cardViewTwo;
    private CardView cardViewThree;
    private CardView cardViewFour;
    private ExerciseDialogFragment exerciseDialog;
    private ImageButton flexOneImageButton;
    private ImageButton flexTwoImageButton;
    private ImageButton flexThreeImageButton;
    private ImageButton flexFourImageButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragement_flexibility, container, false);

        cardViewOne = (CardView)v.findViewById(R.id.flexOne);

        flexOneImageButton = (ImageButton) v.findViewById(R.id.flexOneImageButton);
        flexOneImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Open exercise dialog for triagle pose...");
                openDialog(getString(R.string.triangle), R.drawable.triangle);
            }
        });

        cardViewTwo = (CardView)v.findViewById(R.id.flexTwo);

        flexTwoImageButton = (ImageButton) v.findViewById(R.id.flexTwoImageButton);
        flexTwoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Open exercise dialog on hamstring stretch...");
                openDialog(getString(R.string.camel_pose), R.drawable.hamstring_stretch);
            }
        });

        cardViewThree = (CardView)v.findViewById(R.id.flexThree);
        cardViewThree.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        flexThreeImageButton = (ImageButton) v.findViewById(R.id.flexThreeImageButton);
        flexThreeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Open exercise dialog on flex");
                openDialog(getString(R.string.hamstring_stretch), R.drawable.hamstring_stretch);
            }
        });

        cardViewFour = (CardView)v.findViewById(R.id.flexFour);
        cardViewFour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        flexFourImageButton = (ImageButton) v.findViewById(R.id.flexFourImageButton);
        flexFourImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Open exercise on dialog flex");
                openDialog(getString(R.string.cobra_pose), R.drawable.hamstring_stretch);
            }
        });

        return v;
    }

    private void openDialog(String exerciseName, int resource) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.EXERCISE_NAME, exerciseName);
        bundle.putInt(MainActivity.IMAGE_RESOURCE, resource);
        exerciseDialog = new ExerciseDialogFragment();
        exerciseDialog.setArguments(bundle);
        exerciseDialog.show(ft, exerciseName);
    }
}
