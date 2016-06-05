package com.jaydot2.fitnessapp.basic;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    String[] TITLES = {"My Fitness", "Cardio", "Strength", "Flexibility", "Diet"};
    int[] ICONS = {};

    String NAME = "John Doe";
    String EMAIL = "john.doe@jaydot2.com";

    private Toolbar toolbar;

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout mDrawer;

    ActionBarDrawerToggle mDrawerToggle;

    private FragmentManager fragmentManager;

    private Fragment cardioExerciseFragment;
    private Fragment dietFragment;
    private Fragment flexibilityExerciseFragment;
    private Fragment myFitnessFragment;
    private Fragment strengthExerciseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView)findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new FitnessItemAdapter(TITLES, NAME, EMAIL, this);

        mRecyclerView.setAdapter(mAdapter);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener(){

            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

                return true;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
                //
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

        //mDrawer.setDrawerListener();  // deprecated
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        fragmentManager = getFragmentManager();
        myFitnessFragment = fragmentManager.findFragmentById(R.id.myFitnessFragment);
        if(myFitnessFragment == null) {
            myFitnessFragment = new MyFitnessFragment();
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, myFitnessFragment).commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(fragmentManager == null) {
            fragmentManager = getFragmentManager();
        }
        myFitnessFragment = fragmentManager.findFragmentById(R.id.myFitnessFragment);
        if(myFitnessFragment == null) {
            myFitnessFragment = new MyFitnessFragment();
            fragmentManager.beginTransaction().add(R.id.fragmentContainer, myFitnessFragment).commit();
        }
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     *
     */
    private void onMyFitnessItemClicked() {
        //
    }

    /**
     *
     */
    private void onStrengthExerciseClicked() {
        //
    }
}
