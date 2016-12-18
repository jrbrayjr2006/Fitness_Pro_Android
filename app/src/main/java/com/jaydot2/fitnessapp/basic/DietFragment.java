package com.jaydot2.fitnessapp.basic;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
public class DietFragment extends Fragment {

    public static final String TAG = "DietFragment";

    private CardView mealCard01;
    private CardView mealCard02;
    private CardView mealCard03;
    private CardView mealCard04;
    private CardView mealCard05;
    private CardView mealCard06;

    private DietDialogFragment dietDialog;

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

    private void openDialog(String mealName, int resource) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.EXERCISE_NAME, mealName);
        bundle.putInt(MainActivity.IMAGE_RESOURCE, resource);
        dietDialog = new DietDialogFragment();
        dietDialog.setArguments(bundle);
        dietDialog.show(ft, mealName);
    }
}
