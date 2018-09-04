package com.jaydot2.fitnessapp.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

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
 * Created by jamesbray on 6/26/16.
 */
public class ExerciseDialogFragment extends DialogFragment {

    private AnimationDrawable animateExercise;
    private TextView exerciseTitleText;
    private ImageView exerciseImage;

    private String exerciseName;
    private Button startExerciseButton;
    private int imageResource;

    public ExerciseDialogFragment() {
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

        exerciseName = extras.getString(StrengthExerciseFragment.EXERCISE_NAME);
        imageResource = extras.getInt(StrengthExerciseFragment.IMAGE_RESOURCE);


        // inflate the custom view
        View v = inflater.inflate(R.layout.dialog_fragment_exercise, null);
        exerciseTitleText = (TextView) v.findViewById(R.id.exerciseAnimationTitle);
        exerciseTitleText.setText(exerciseName);
        exerciseImage = (ImageView)v.findViewById(R.id.exerciseImage);
        exerciseImage.setBackgroundResource(imageResource);
        animateExercise = (AnimationDrawable)exerciseImage.getBackground();

        builder.setView(v)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //startAnimation();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ExerciseDialogFragment.this.getDialog().cancel();
                    }
                });

        startExerciseButton = (Button)v.findViewById(R.id.startExercise);
        startExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAnimation();
            }
        });

        return builder.create();
    }

    private void startAnimation() {
        if(animateExercise.isRunning()) {
            animateExercise.stop();
            startExerciseButton.setText(getResources().getString(R.string.start));
        } else {
            animateExercise.start();
            startExerciseButton.setText(getResources().getString(R.string.stop));
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //TODO
    }
}
