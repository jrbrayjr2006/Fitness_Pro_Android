package com.jaydot2.fitnessapp.core;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceFragment;

/**
 * Created by jamesbray on 12/3/16.
 */

public class SettingsFragment extends PreferenceFragment {

    EditTextPreference pref_age_editText;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }
}
