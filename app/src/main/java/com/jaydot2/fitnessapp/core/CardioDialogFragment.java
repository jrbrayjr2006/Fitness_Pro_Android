package com.jaydot2.fitnessapp.core;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by jamesbray on 2/26/17.
 */

public class CardioDialogFragment extends DialogFragment {

    private static final String TAG = "CardioDialogFragment";

    private BitmapDrawable bitmapExercise;
    private TextView exerciseTitleText;
    private ImageView exerciseImage;

    private String exerciseName;
    private Button startExerciseButton;
    private int imageResource;

    public CardioDialogFragment() {}

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


        // inflate the custome view
        View v = inflater.inflate(R.layout.dialog_fragment_exercise, null);
        exerciseTitleText = (TextView) v.findViewById(R.id.exerciseAnimationTitle);
        exerciseTitleText.setText(exerciseName);
        exerciseImage = (ImageView)v.findViewById(R.id.exerciseImage);
        exerciseImage.setBackgroundResource(imageResource);
        bitmapExercise = (BitmapDrawable)exerciseImage.getBackground();

        builder.setView(v)
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "Dismissing CardioDialogFragment...");
                        dismiss();
                    }
                });

        startExerciseButton = (Button)v.findViewById(R.id.startExercise);
        startExerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Dismissing CardioDialogFragment from START button...");
                //TODO
                CardioDialogFragment.this.getDialog().dismiss();
            }
        });

        return builder.create();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(this != null && this.isVisible()) {
            dismiss();
        }
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //TODO
    }
}
