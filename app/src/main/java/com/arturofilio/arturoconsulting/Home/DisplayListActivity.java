package com.arturofilio.arturoconsulting.Home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.arturofilio.arturoconsulting.R;

import java.util.ArrayList;

public class DisplayListActivity extends AppCompatActivity {

    private static final String TAG = "DisplayListActivity";

    //vars
    private ArrayList<String> nNames = new ArrayList<>();
    private ArrayList<String> nImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        Log.d(TAG, "onCreate: startted.");
    }
}
