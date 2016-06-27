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
 * Created by jamesbray on 6/4/16.
 */
public class StrengthExerciseFragment extends Fragment {

    public static final String TAG = "StrengthExerciseFragment";
    public static final String EXERCISE_NAME = "EXERCISE_NAME";
    public static final String IMAGE_RESOURCE = "IMAGE_RESOURCE";

    private CardView cardViewOne;
    private CardView cardViewTwo;
    private ExerciseDialogFragment exerciseDialog;
    private ImageButton strengthOneImageButton;
    private ImageButton strengthTwoImageButton;

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
