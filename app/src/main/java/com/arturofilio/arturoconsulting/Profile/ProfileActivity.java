package com.arturofilio.arturoconsulting.Profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import com.arturofilio.arturoconsulting.R;

/**
 * Created by arturofiliovilla on 5/17/18.
 */

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = "ProfileActivity";

    //onImageSelectedPhotoMethod --> HERE

    private Context mContext = ProfileActivity.this;

    //Initiate ProfilePhoto
    private ImageView profilePhoto;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_profile);
        Log.d(TAG, "onCreate: started");

        init();
    }

    private void init() {

        //initiate ProfileFragment

    }
}
