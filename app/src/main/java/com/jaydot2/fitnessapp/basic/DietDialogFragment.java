package com.jaydot2.fitnessapp.basic;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * <b>Description:</b>
 * <p>
 *     This class is for diet and meal dialogs with detailed information
 * </p>
 * Created by jamesbray on 12/17/16.
 */

public class DietDialogFragment extends DialogFragment {

    private TextView dietTitleText;
    private ImageView dietImage;

    private String mealName;
    private Button detailsMealButton;
    private int imageResource;

    public DietDialogFragment() {
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


        return builder.create();
    }
}
