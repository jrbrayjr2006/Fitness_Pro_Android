package com.jaydot2.fitnessapp.core;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.AsyncTask;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

//import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * <b>Description:</b>
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
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    public static final String EXERCISE_NAME = "EXERCISE_NAME";
    public static final String IMAGE_RESOURCE = "IMAGE_RESOURCE";

    //String[] TITLES = {"My Fitness", "Cardio", "Strength", "Flexibility", "Diet", "Update Profile Photo"};
    int[] ICONS = {};

    String NAME = "John Doe";
    String EMAIL = "john.doe@jaydot2.com";

    SharedPreferences preferences;

    private Toolbar toolbar;

    private NavigationView navView;

    private CircleImageView circleImageView;

    DrawerLayout mDrawer;

    ActionBarDrawerToggle mDrawerToggle;

    private FragmentManager fragmentManager;

    private Fragment cardioExerciseFragment;
    private Fragment dietFragment;
    private Fragment flexibilityExerciseFragment;
    private Fragment myFitnessFragment;
    private Fragment strengthExerciseFragment;
    private PreferenceFragment settingsFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        navView = findViewById(R.id.navView);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);

                mDrawer.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.menuItemMyFitness:
                        onMyFitnessItemClicked();
                        break;
                    case R.id.menuItemCardio:
                        onCardioExerciseClicked();
                        break;
                    case R.id.menuItemMyStrength:
                        onStrengthExerciseClicked();
                        break;
                    case R.id.menuItemFlexibility:
                        onFlexibilityExerciseClicked();
                        break;
                    case R.id.menuItemDiet:
                        onDietClicked();
                        break;
                    case 6:
                        updateProfileImage();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });


        // get the values from the app preferences
        preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String userFullName = preferences.getString(getString(R.string.PREF_FIT_NAME), NAME);

        final GestureDetector mGestureDetector = new GestureDetector(MainActivity.this, new GestureDetector.SimpleOnGestureListener(){

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });



        mDrawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        fragmentManager = getFragmentManager();
        myFitnessFragment = fragmentManager.findFragmentById(R.id.myFitnessFragment);
        if(myFitnessFragment == null) {
            myFitnessFragment = new MyFitnessFragment();
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, myFitnessFragment).commit();
        }

        TextView textViewNavHeaderUsername = navView.getHeaderView(0).findViewById(R.id.textViewNavHeaderUsername);
        TextView textViewNavHeaderEmail = navView.getHeaderView(0).findViewById(R.id.textViewNavHeaderEmail);
        CircleImageView circleImageViewNavHeaderProfileImage = navView.getHeaderView(0).findViewById(R.id.circleImageViewNavHeaderProfileImage);

        textViewNavHeaderUsername.setText(userFullName);
    }

    private void updateProfileImage() {
        Log.d(TAG, "updateProfileImage: set new profile image...");
        //TODO
    }

    @Override
    protected void onResume() {
        super.onResume();
        onMyFitnessItemClicked();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.action_settings) {
            onSettingsOption();
            return true;
        }
        if(id == R.id.action_quit) {
            quitApp(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     */
    private void onCardioExerciseClicked() {
        Log.d(TAG, "Switchig to cardio fragment...");
        if(fragmentManager == null) {
            fragmentManager = getFragmentManager();
        }
        cardioExerciseFragment = fragmentManager.findFragmentById(R.id.cardioFragment);
        if(cardioExerciseFragment == null) {
            cardioExerciseFragment = new CardioExerciseFragment();
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, cardioExerciseFragment).commit();
        }
    }

    /**
     *
     */
    private void onFlexibilityExerciseClicked() {
        Log.d(TAG, "Switchig to flexibility fragment...");
        if(fragmentManager == null) {
            fragmentManager = getFragmentManager();
        }
        flexibilityExerciseFragment = fragmentManager.findFragmentById(R.id.flexibilityFragment);
        if(flexibilityExerciseFragment == null) {
            flexibilityExerciseFragment = new FlexibilityExerciseFragment();
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, flexibilityExerciseFragment).commit();
        }
    }

    /**
     * Corresponds to 1 (index 0) in the array
     */
    private void onMyFitnessItemClicked() {
        Log.d(TAG, "Switchig to My Fitness fragment...");
        if(fragmentManager == null) {
            fragmentManager = getFragmentManager();
        }
        myFitnessFragment = fragmentManager.findFragmentById(R.id.myFitnessFragment);
        if(myFitnessFragment == null) {
            Bundle bundle = new Bundle();
            myFitnessFragment = new MyFitnessFragment();
            myFitnessFragment.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.fragmentContainer, myFitnessFragment).commit();
        }
    }

    /**
     * Corresponds to 3 (index 2) in the array
     */
    private void onStrengthExerciseClicked() {
        Log.d(TAG, "Switching to strength fragment...");
        if(fragmentManager == null) {
            fragmentManager = getFragmentManager();
        }
        strengthExerciseFragment = fragmentManager.findFragmentById(R.id.strengthFragment);
        if(strengthExerciseFragment == null) {
            strengthExerciseFragment = new StrengthExerciseFragment();
        }
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,strengthExerciseFragment).commit();
    }

    /**
     * Corresponds to 5 (index 4) in the array
     */
    private void onDietClicked() {
        Log.d(TAG, "Switching to diet fragment...");
        if(fragmentManager == null) {
            fragmentManager = getFragmentManager();
        }
        dietFragment = fragmentManager.findFragmentById(R.id.dietFragment);
        if(dietFragment == null) {
            dietFragment = new DietFragment();
        }
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer,dietFragment).commit();
    }

    /**
     * Open the settings
     */
    private void onSettingsOption() {
        Log.d(TAG, "Switching to settings fragement...");
        if(fragmentManager == null) {
            fragmentManager = getFragmentManager();
        }

        settingsFragment = new SettingsFragment();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer, settingsFragment).commit();
    }

    /**
     * <p>
     *     Close the application
     * </p>
     * @param activity
     */
    private void quitApp(Activity activity) {
        activity.finish();
    }


    protected class RestClientTask extends AsyncTask<Void, Void, List<String>> {

        @Override
        protected List<String> doInBackground(Void... params) {

            //RestTemplate restTemplate = new RestTemplate();
            return null;
        }
    }

    private ArrayList<Image> getImages() {
        ArrayList<Image> images = new ArrayList<Image>();

        return images;
    }

}
