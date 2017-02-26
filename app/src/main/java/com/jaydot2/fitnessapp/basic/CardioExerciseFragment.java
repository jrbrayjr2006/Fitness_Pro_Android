package com.jaydot2.fitnessapp.basic;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
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
 *
 * Created by jamesbray on 6/4/16.
 */
public class CardioExerciseFragment extends Fragment {

    public static final String TAG = "CardioExerciseFragment";
    public static final String EXERCISE_NAME = "EXERCISE_NAME";
    public static final String IMAGE_RESOURCE = "IMAGE_RESOURCE";

    private Button cardioStartButton;
    private Chronometer cardioChronometer;

    private CardView cardViewOne;
    private CardView cardViewTwo;
    private CardView cardViewThree;
    private CardView cardViewFour;
    private CardioDialogFragment cardioDialog;
    private ImageButton cardioOneImageButton;
    private ImageButton cardioTwoImageButton;
    private ImageButton cardioThreeImageButton;
    private ImageButton cardioFourImageButton;

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

        cardViewOne = (CardView)v.findViewById(R.id.cardioOne);
        cardViewOne.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        cardViewTwo = (CardView)v.findViewById(R.id.cardioTwo);
        cardViewTwo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        cardViewThree = (CardView)v.findViewById(R.id.cardioThree);
        cardViewThree.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        cardViewFour = (CardView)v.findViewById(R.id.cardioFour);


        cardioOneImageButton = (ImageButton)v.findViewById(R.id.cardioOneImageButton);
        cardioOneImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Opening CardioDialogFragment now 1...");
                openDialog(getResources().getString(R.string.running),R.drawable.running);
            }
        });

        cardioTwoImageButton = (ImageButton)v.findViewById(R.id.cardioTwoImageButton);
        cardioTwoImageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Opening CardioDialogFragment now 2...");
                openDialog(getResources().getString(R.string.biking),R.drawable.biking);
            }
        });

        cardioThreeImageButton = (ImageButton)v.findViewById(R.id.cardioThreeImageButton);
        cardioThreeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Opening CardioDialogFragment now 3...");
                openDialog(getResources().getString(R.string.walking),R.drawable.walking);
            }
        });

        cardioFourImageButton = (ImageButton)v.findViewById(R.id.cardioFourImageButton);
        cardioFourImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Opening CardioDialogFragment now 4...");
                openDialog(getResources().getString(R.string.swimming),R.drawable.swimming);
            }
        });

        return v;
    }


    private void openDialog(String exerciseName, int resource) {
        FragmentTransaction ft = getFragmentManager().beginTransaction().addToBackStack("cardioDialog");
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.EXERCISE_NAME, exerciseName);
        bundle.putInt(MainActivity.IMAGE_RESOURCE, resource);
        cardioDialog = new CardioDialogFragment();
        cardioDialog.setArguments(bundle);
        if(!cardioDialog.isVisible()) {
            cardioDialog.show(ft, exerciseName);
        }
    }
}
