package com.arturofilio.arturoconsulting.Model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.arturofilio.arturoconsulting.Adapter.RecyclerViewAdapter;
import com.arturofilio.arturoconsulting.Home.HomeActivity;
import com.arturofilio.arturoconsulting.Model.Exercise;
import com.arturofilio.arturoconsulting.R;
import com.arturofilio.arturoconsulting.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arturofiliovilla on 5/17/18.
 */

public class ListExercises extends Activity {

    private static final String TAG = "ListExercises" ;

    List<Exercise> exerciseList = new ArrayList<>();
    RecyclerView.LayoutManager layoutManager;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercises);

        initData();

        recyclerView = (RecyclerView)findViewById(R.id.list_ex);
        adapter = new RecyclerViewAdapter(exerciseList, getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initData() {

        exerciseList.add(new Exercise(R.drawable.chest_workout, "Chest Workout"));
        exerciseList.add(new Exercise(R.drawable.back_workout, "Back Workout"));
        exerciseList.add(new Exercise(R.drawable.biceps_workout, "Biceps Workout"));
        exerciseList.add(new Exercise(R.drawable.legs_workout, "Legs Workout"));
        
        setupBottomNavigationView();

    }

    /**
     * BottomNavigationView setup
     */
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: ");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavigationViewBar);
//        BottomNavigationViewHelper.envableNavigation(, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(0);
        menuItem.setChecked(true);
    }
}
