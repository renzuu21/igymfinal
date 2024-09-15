package com.example.igymfinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private TextView textViewWorkoutPlan;
    private TextView textViewCurrentDate;
    private TextView textViewCurrentDay;
    private String workoutPlan;
    private String userBodyType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewWorkoutPlan = findViewById(R.id.textViewWorkoutPlan);
        textViewCurrentDate = findViewById(R.id.textViewCurrentDate);
        textViewCurrentDay = findViewById(R.id.textViewCurrentDay);

        databaseHelper = new DatabaseHelper(this);

        // Retrieve username from the Intent
        String username = getIntent().getStringExtra("username");

        // Fetch the user's details from the database
        Cursor cursor = databaseHelper.getUserByUsername(username);
        if (cursor != null && cursor.moveToFirst()) {
            @SuppressLint("Range") String bodyType = cursor.getString(cursor.getColumnIndex("body_type"));
            userBodyType = bodyType;
            workoutPlan = recommendWorkout(bodyType);
            textViewWorkoutPlan.setText(workoutPlan);

            cursor.close();
        }

        // Make textViewWorkoutPlan clickable
        textViewWorkoutPlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WorkoutDetailActivity.class);
                intent.putExtra("bodyType", userBodyType);
                startActivity(intent);
            }
        });

        updateDateDisplay();
        setupWorkoutOptionClicks();
        setupBottomNavigation();
    }

    private void setupWorkoutOptionClicks() {
        CardView cardPushups = findViewById(R.id.card_pushups);
        CardView cardSquats = findViewById(R.id.card_squats);
        CardView cardPlanks = findViewById(R.id.card_planks);
        CardView cardCrunches = findViewById(R.id.card_crunches);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exercise = "";
                if (v.getId() == R.id.card_pushups) {
                    exercise = "Pushups";
                } else if (v.getId() == R.id.card_squats) {
                    exercise = "Squats";
                } else if (v.getId() == R.id.card_planks) {
                    exercise = "Planks";
                } else if (v.getId() == R.id.card_crunches) {
                    exercise = "Crunches";
                }

                Intent intent = new Intent(MainActivity.this, ExerciseDetailActivity.class);
                intent.putExtra("exercise", exercise);
                startActivity(intent);
            }
        };

        cardPushups.setOnClickListener(clickListener);
        cardSquats.setOnClickListener(clickListener);
        cardPlanks.setOnClickListener(clickListener);
        cardCrunches.setOnClickListener(clickListener);
    }

    private void updateDateDisplay() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, yyyy", Locale.getDefault());
        SimpleDateFormat dayFormat = new SimpleDateFormat("d", Locale.getDefault());

        textViewCurrentDate.setText(dateFormat.format(currentDate));
        textViewCurrentDay.setText(dayFormat.format(currentDate));
    }

    private String recommendWorkout(String bodyType) {
        if (bodyType == null || bodyType.isEmpty()) {
            return "No workout plan available.";
        }
        if (bodyType.equalsIgnoreCase("ectomorph")) {
            return "Workout Routine";
        } else if (bodyType.equalsIgnoreCase("mesomorph")) {
            return "Workout Routine";
        } else if (bodyType.equalsIgnoreCase("endomorph")) {
            return "Workout Routine";
        } else {
            return "No workout plan available.";
        }
    }

    private void setupBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_profile) {
                startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                return true;
            } else if (item.getItemId() == R.id.navigation_capture) {
                startActivity(new Intent(MainActivity.this, CaptureActivity.class));
                return true;
            } else if (item.getItemId() == R.id.navigation_diet) {
                Intent intent = new Intent(MainActivity.this, DietActivity.class);
                intent.putExtra("username", getIntent().getStringExtra("username"));
                startActivity(intent);
                return true;
            } else if (item.getItemId() == R.id.navigation_exercise) {
                return true;
            }
            return false;
        });
    }
}