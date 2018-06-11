package com.arturofilio.arturoconsulting.Home;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.arturofilio.arturoconsulting.Adapter.RecyclerViewAdapter;
import com.arturofilio.arturoconsulting.R;
import com.arturofilio.arturoconsulting.Utils.BottomNavigationViewHelper;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;


public class DisplayListActivity extends AppCompatActivity {

    private static final String TAG = "DisplayListActivity";

    private static final int ACTIVITY_NUM = 0;

    private Context mContext = DisplayListActivity.this;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private RecyclerView mListView;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recycler_view);
        Log.d(TAG, "onCreate: startted.");

        initImagebitmap();
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

    private void initImagebitmap() {
        Log.d(TAG, "initImagebitmap: preparing bitmap");

        mImageUrls.add("https://images.pexels.com/photos/896058/pexels-photo-896058.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        mNames.add("Biceps");

        mImageUrls.add("https://images.pexels.com/photos/497934/pexels-photo-497934.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        mNames.add("Legs");

        mImageUrls.add("https://images.pexels.com/photos/416778/pexels-photo-416778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        mNames.add("Abdominal");

        mImageUrls.add("https://images.pexels.com/photos/812746/pexels-photo-812746.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        mNames.add("Chest");


        mImageUrls.add("https://images.pexels.com/photos/819691/workout-fitness-street-workout-trees-819691.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        mNames.add("Back");

        mImageUrls.add("https://cdn.pixabay.com/photo/2015/02/27/17/44/weights-652488_960_720.jpg");
        mNames.add("Shoulders");


        mImageUrls.add("https://images.pexels.com/photos/1144864/pexels-photo-1144864.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        mNames.add("Triceps");

        mImageUrls.add("https://images.pexels.com/photos/931323/pexels-photo-931323.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        mNames.add("Calisthenics");

        mImageUrls.add("https://images.pexels.com/photos/936094/pexels-photo-936094.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
        mNames.add("Cardio");

        initRecyclerView();
    }

    private void initRecyclerView() {
        Log.d(TAG, "initRecyclerView: init recyclerview");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
