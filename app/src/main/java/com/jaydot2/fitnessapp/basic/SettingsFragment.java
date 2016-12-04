package com.jaydot2.fitnessapp.basic;

import android.os.Bundle;
import android.preference.PreferenceFragment;

/**
 * Created by jamesbray on 12/3/16.
 */

public class SettingsFragment extends PreferenceFragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }
}
