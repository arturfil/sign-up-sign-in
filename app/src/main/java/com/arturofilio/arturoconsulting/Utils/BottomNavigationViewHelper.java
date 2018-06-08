package com.arturofilio.arturoconsulting.Utils;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.arturofilio.arturoconsulting.Home.DisplayListActivity;
import com.arturofilio.arturoconsulting.Model.ListExercises;
import com.arturofilio.arturoconsulting.Profile.ProfileActivity;
import com.arturofilio.arturoconsulting.R;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class BottomNavigationViewHelper {

    private static final String TAG = "BottomNavigationViewHel";

    public static void setupBottomNavigationView(BottomNavigationViewEx bottomNavigationViewEx) {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        bottomNavigationViewEx.setTextVisibility(false);
    }

    public static void envableNavigation(final Context context, BottomNavigationViewEx view){
        view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.ic_house:
                        Intent intent1 = new Intent(context, ListExercises.class);
                        context.startActivity(intent1);
                        break;

                    case R.id.ic_alert:
                        //create the other intents for the different activities in the bottom menu nav bar
                        //item click listener for the alert's activity
                        Intent intent2 = new Intent(context, DisplayListActivity.class);
                        context.startActivity(intent2);
                        break;

                    case R.id.ic_profile:
                        //item click listener for the profile activity
                        Intent intent3 = new Intent(context, ProfileActivity.class);
                        context.startActivity(intent3);
                        break;

                }

                return false;
            }
        });
    }
}
