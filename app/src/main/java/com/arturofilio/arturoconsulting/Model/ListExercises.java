package com.arturofilio.arturoconsulting.Model;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.arturofilio.arturoconsulting.Adapter.CustomListAdapter;
import com.arturofilio.arturoconsulting.R;
import com.arturofilio.arturoconsulting.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;

/**
 * Created by arturofiliovilla on 5/17/18.
 */

public class ListExercises extends Activity {

    private ListView mListView;

    private static final String TAG = "ListExercises" ;
    private static final int ACTIVITY_NUM = 0;

    private Context mContext = ListExercises.this;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: starting list view");
        setContentView(R.layout.activity_list_exercises);
        mListView = (ListView) findViewById(R.id.listView);

        ArrayList<Exercise> list = new ArrayList<>();
        list.add(new Exercise("@drawable//" + R.drawable.chest_workout, "Chest Workout"));
        list.add(new Exercise("@drawable//" + R.drawable.back_workout, "Chest Workout"));
        list.add(new Exercise("@drawable//" + R.drawable.biceps_workout, "Chest Workout"));
        list.add(new Exercise("@drawable//" + R.drawable.legs_workout, "Chest Workout"));

        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.activity_list_exercises, list);
        mListView.setAdapter(adapter);

        setupBottomNavigationView();
    }

    /**
     * BottomNavigationView setup
     */
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottomNavigationViewBar);
        BottomNavigationViewHelper.envableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }
}
