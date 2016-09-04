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
public class StrengthExerciseFragment extends Fragment {

    public static final String TAG = "StrengthExerciseFragment";
    public static final String EXERCISE_NAME = "EXERCISE_NAME";
    public static final String IMAGE_RESOURCE = "IMAGE_RESOURCE";

    private CardView cardViewOne;
    private CardView cardViewTwo;
    private CardView cardViewThree;
    private CardView cardViewFour;
    private ExerciseDialogFragment exerciseDialog;
    private ImageButton strengthOneImageButton;
    private ImageButton strengthTwoImageButton;
    private ImageButton strengthThreeImageButton;
    private ImageButton strengthFourImageButton;

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
        cardViewTwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        cardViewThree = (CardView)v.findViewById(R.id.strengthThree);
        cardViewThree.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        cardViewFour = (CardView)v.findViewById(R.id.strengthFour);
        cardViewFour.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        strengthOneImageButton = (ImageButton)v.findViewById(R.id.strengthOneImageButton);
        strengthOneImageButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                openDialog(getString(R.string.pushups), R.drawable.pushup);
                return false;
            }
        });

        strengthTwoImageButton = (ImageButton)v.findViewById(R.id.strengthTwoImageButton);
        strengthTwoImageButton.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                openDialog(getResources().getString(R.string.squats),R.drawable.squat);
                return false;
            }
        });

        strengthThreeImageButton = (ImageButton)v.findViewById(R.id.strengthThreeImageButton);
        strengthThreeImageButton.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                openDialog(getResources().getString(R.string.crunch),R.drawable.crunch);
                return false;
            }
        });

        strengthFourImageButton = (ImageButton)v.findViewById(R.id.strengthFourImageButton);
        strengthFourImageButton.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                openDialog(getResources().getString(R.string.squat_thrust),R.drawable.squat_thrust);
                return false;
            }
        });

        return v;
    }

    private void openDialog(String exerciseName, int resource) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString(EXERCISE_NAME, exerciseName);
        bundle.putInt(IMAGE_RESOURCE, resource);
        exerciseDialog = new ExerciseDialogFragment();
        exerciseDialog.setArguments(bundle);
        exerciseDialog.show(ft, exerciseName);
    }
}
