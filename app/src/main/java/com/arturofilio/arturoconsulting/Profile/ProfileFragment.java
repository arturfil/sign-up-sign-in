package com.arturofilio.arturoconsulting.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.arturofilio.arturoconsulting.Model.User;
import com.arturofilio.arturoconsulting.Model.UserAccountSettings;
import com.arturofilio.arturoconsulting.Model.UserSettings;
import com.arturofilio.arturoconsulting.R;
import com.arturofilio.arturoconsulting.Utils.BottomNavigationViewHelper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFragment extends Fragment {

    private static final int ACTIVITY_NUM = 2;

    private static final String TAG = "ProfileFragment";

    //firebase
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference myRef;

    private TextView mUsername, mWebsite, mFat, mMuscleMass, mBMI, mDailyAct, mHeight, mWeight;
    private ProgressBar mProgressBar;
    private CircleImageView mProfileImage;
    private GridView gridView;
    private Toolbar toolbar;
    private ImageView profileMenu;
    private BottomNavigationViewEx bottomNavigationViewEx;
    private Context mContext;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        mUsername = (TextView) view.findViewById(R.id.user_name);
        mFat = (TextView) view.findViewById(R.id.desc_fat);
        mMuscleMass = (TextView) view.findViewById(R.id.desc_muscle);
        mBMI = (TextView) view.findViewById(R.id.desc_bmi);
        mDailyAct = (TextView) view.findViewById(R.id.desc_activity);
        mHeight = (TextView) view.findViewById(R.id.desc_height);
        mWeight = (TextView) view.findViewById(R.id.desc_weight);
        mWebsite = (TextView) view.findViewById(R.id.website);
        mProfileImage = (CircleImageView) view.findViewById(R.id.profile_image);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        gridView = (GridView) view.findViewById(R.id.gridView);
        bottomNavigationViewEx = (BottomNavigationViewEx) view.findViewById(R.id.bottomNavigationViewBar);
        mContext = getActivity();

        Log.d(TAG, "onCreateView: started");

        setupBottomNavigationView();
        return view;
    }

    private void setProfileWidgets(UserSettings userSettings) {
        Log.d(TAG, "setProfileWidgets: setting widgets with data retrieveing form firebase database");

        User user = userSettings.getUser();
        UserAccountSettings settings = userSettings.getSetting();

//        Univ.setImage(settings.getProfile_photo(), mProfileImage, null);   <===== STILL NEED TO CHANGE THIS!
    }

    /**
     ** BottomNavigationView setup
     */
    private void setupBottomNavigationView() {
        Log.d(TAG, "setupBottomNavigationView: setting up BottomNavigationView");
        BottomNavigationViewHelper.envableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NUM);
        menuItem.setChecked(true);
    }

     /*
    ---------------------------------------------Firebase Auth ------------------------------------>
     */


    /**
     * Setup the firebase auth object
     */
    private void setupFirebaseAuth() {
        Log.d(TAG, "setupFirebaseAuth: setting up firebase Auth");

        mAuth = FirebaseAuth.getInstance();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        myRef = mFirebaseDatabase.getReference();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();

                //check if the user is logged in

                if (user != null) {
                    //User is signed in
                    Log.d(TAG, "onAuthStateChanged: signed_in" + user.getUid());

                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged: signed_out");
                }
            }
        };

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //retrieve user information from the database

                //retrieve images for the user in question

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.addAuthStateListener(mAuthListener);
        }
    }

}
