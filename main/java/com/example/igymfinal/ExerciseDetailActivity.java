package com.example.igymfinal;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class ExerciseDetailActivity extends AppCompatActivity {

    private TextView textViewExerciseTitle;
    private TextView textViewExerciseDescription;
    private ImageView imageViewExercise;
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);

        textViewExerciseTitle = findViewById(R.id.textViewExerciseTitle);
        textViewExerciseDescription = findViewById(R.id.textViewExerciseDescription);
        imageViewExercise = findViewById(R.id.imageViewExercise);
        btnBack = findViewById(R.id.btnBack);

        String exercise = getIntent().getStringExtra("exercise");
        if (exercise != null) {
            textViewExerciseTitle.setText(exercise);
            textViewExerciseDescription.setText(getExerciseDescription(exercise));
            imageViewExercise.setImageResource(getExerciseImage(exercise));
        }

        // Set up the back button functionality with transition
        btnBack.setOnClickListener(v -> {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    private String getExerciseDescription(String exercise) {
        switch (exercise) {
            case "Pushups":
                return "Pushups are a classic bodyweight exercise that primarily target the chest, shoulders, and triceps.\n\n" +
                        "Start in a plank position with hands slightly wider than shoulder-width apart.\n\nLower your body " +
                        "until your chest nearly touches the floor, then push back up to the starting position.";
            case "Squats":
                return "Squats are a fundamental lower body exercise that target the quadriceps, hamstrings, and glutes.\n\n" +
                        "Stand with feet shoulder-width apart, then lower your body as if sitting back into a chair.\n\n" +
                        "Keep your chest up and knees over (not past) your toes. Push through your heels to return to standing.";
            case "Planks":
                return "Planks are an excellent core-strengthening exercise that also engage the shoulders, arms, and glutes.\n\n" +
                        "Start in a pushup position, but with your forearms on the ground. Keep your body in a straight line\n\n" +
                        "from head to heels, engaging your core muscles. Hold this position for the desired duration.";
            case "Crunches":
                return "Crunches are an abdominal exercise that primarily target the rectus abdominis.\n\nLie on your back with" +
                        "knees bent and feet flat on the floor. \n\nPlace your hands behind your head, then lift your shoulders " +
                        "off the ground while engaging your core.\n\nLower back down with control.";
            default:
                return "No description available for this exercise.";
        }
    }

    private int getExerciseImage(String exercise) {
        switch (exercise) {
            case "Pushups":
                return R.drawable.pushups;
            case "Squats":
                return R.drawable.squats;
            case "Planks":
                return R.drawable.plank;
            case "Crunches":
                return R.drawable.crunches;
            default:
                return R.drawable.gym_background;
        }
    }
}