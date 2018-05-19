package com.arturofilio.arturoconsulting.Home;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;

import com.arturofilio.arturoconsulting.Adapter.RecyclerViewAdapter;
import com.arturofilio.arturoconsulting.Model.Exercise;
import com.arturofilio.arturoconsulting.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arturofiliovilla on 5/17/18.
 */

public class ListExercises extends Activity {

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
        exerciseList.add(new Exercise(R.drawable.chest_workout, "Chest Workout"));
        exerciseList.add(new Exercise(R.drawable.chest_workout, "Chest Workout"));
        exerciseList.add(new Exercise(R.drawable.chest_workout, "Chest Workout"));
        exerciseList.add(new Exercise(R.drawable.chest_workout, "Chest Workout"));
        exerciseList.add(new Exercise(R.drawable.chest_workout, "Chest Workout"));

    }
}
