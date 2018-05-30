package com.arturofilio.arturoconsulting.Model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.arturofilio.arturoconsulting.Adapter.CustomListAdapter;
import com.arturofilio.arturoconsulting.Login.LoginActivity;
import com.arturofilio.arturoconsulting.R;
import com.arturofilio.arturoconsulting.Utils.BottomNavigationViewHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: starting list view");
        setContentView(R.layout.listview_layout);



        mListView = (ListView) findViewById(R.id.listView);

        ArrayList<Exercise> list = new ArrayList<>();
        list.add(new Exercise("drawable://" + R.drawable.chest_workout, "Chest Workout"));
        list.add(new Exercise("drawable://" + R.drawable.back_workout, "Chest Workout"));
        list.add(new Exercise("drawable://" + R.drawable.biceps_workout, "Chest Workout"));
        list.add(new Exercise("drawable://" + R.drawable.legs_workout, "Chest Workout"));
        list.add(new Exercise("drawable://" + R.drawable.chest_workout, "Chest Workout"));
        list.add(new Exercise("drawable://" + R.drawable.back_workout, "Chest Workout"));
        list.add(new Exercise("drawable://" + R.drawable.biceps_workout, "Chest Workout"));
        list.add(new Exercise("drawable://" + R.drawable.legs_workout, "Chest Workout"));

        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.exercise_card, list);
        mListView.setAdapter(adapter);

        setupBottomNavigationView();
        setupFirebaseAuth();


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

    /*
    ---------------------------------------------Firebase Auth ------------------------------------>
     */

    private void checkCurrentUser(FirebaseUser user) {
        Log.d(TAG, "checkCurrentUser: checking if user is logged in");

        /**
         * check to see if the @param 'user' is logged in.
         */
        if(user == null) {
            Intent intent = new Intent(mContext, LoginActivity.class);
            startActivity(intent);
        }
    }

    /**
     * Setup the firebase auth object
     */
    private void setupFirebaseAuth() {
        Log.d(TAG, "setupFirebaseAuth: setting up firebase Auth");

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                //check if the user is logged in
                checkCurrentUser(user);

                if (user != null) {
                    //User is signed in
                    Log.d(TAG, "onAuthStateChanged: signed_in" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged: signed_out");
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
        checkCurrentUser(mAuth.getCurrentUser());
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.addAuthStateListener(mAuthListener);
        }
    }

}
