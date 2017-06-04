package com.jaydot2.fitnessapp.core;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * <p>
 *     This is for the splash screen when the app opens
 * </p>
 * Created by jamesbray on 3/27/17.
 */

public class SplashActivity extends AppCompatActivity {
    public SplashActivity() {
        super();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
