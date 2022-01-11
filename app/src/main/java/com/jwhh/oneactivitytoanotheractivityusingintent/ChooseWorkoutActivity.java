package com.jwhh.oneactivitytoanotheractivityusingintent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class ChooseWorkoutActivity extends AppCompatActivity {

    private Spinner selectWorkoutType;
    private ViewPager slideImages;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sport_type);
        findViews();
        setupListeners();
        setData();
    }

    private void findViews() {
        this.selectWorkoutType = this.findViewById(R.id.select_workout_type);
        this.slideImages = this.findViewById(R.id.scroll_images);
    }

    private void setupListeners() {
        this.selectWorkoutType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedWorkoutType = adapterView.getItemAtPosition(i).toString();


                loadImages(selectedWorkoutType);

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
    }

    private void setData() {
        ArrayAdapter<CharSequence> stringArrayAdapter = ArrayAdapter.createFromResource(this, R.array.workout_types, android.R.layout.simple_spinner_item);
        stringArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.selectWorkoutType.setAdapter(stringArrayAdapter);

    }

    private void loadImages(String workoutType) {
        ArrayList<Integer> imgIdList = new ArrayList<>();
        switch (workoutType) {
            case "Upper Body":
                imgIdList.add(R.drawable.flat_bench_press);
                imgIdList.add(R.drawable.pec_fly);
                imgIdList.add(R.drawable.incline_dumbell_press);
                break;

            case "Lower Body":
                imgIdList.add(R.drawable.barbell_deadlift);
                imgIdList.add(R.drawable.leg_press);
                imgIdList.add(R.drawable.split_squat);
                break;

            case "Core/Abs":
                imgIdList.add(R.drawable.crunches);
                imgIdList.add(R.drawable.barbell_deadlift);
                imgIdList.add(R.drawable.leg_raise);
                break;

            case "None":
                imgIdList.add(R.drawable.rest_day);
                break;
        }
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(imgIdList, this);
        this.slideImages.setAdapter(viewPagerAdapter);
    }
}

