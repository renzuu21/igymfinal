package com.example.igymfinal;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WorkoutDetailActivity extends AppCompatActivity {

    private TextView textViewWorkoutDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_detail);

        textViewWorkoutDetail = findViewById(R.id.textViewWorkoutDetail);

        String bodyType = getIntent().getStringExtra("bodyType");
        String workoutPlan = getDetailedWorkoutPlan(bodyType);
        textViewWorkoutDetail.setText(workoutPlan);
    }

    private String getDetailedWorkoutPlan(String bodyType) {
        if (bodyType == null || bodyType.isEmpty()) {
            return "No workout plan available.";
        }
        if (bodyType.equalsIgnoreCase("ectomorph")) {
            return "Ectomorph 7-Day Home Workout Plan:\n\n" +
                    "Day 1 (Total: 300-350 cal):\n" +
                    "  - Push-ups: 3 sets of 10-15 reps\n" +
                    "  - Squat Jumps: 3 sets of 15 reps\n" +
                    "  - Plank: Hold for 30-60 seconds\n" +
                    "  - Burpees: 3 sets of 10 reps\n" +
                    "  - Resistance Band Rows: 3 sets of 15 reps\n\n" +
                    "Day 2 (Total: 200 cal):\n" +
                    "  - Light Cardio (30 minutes walk or light jog)\n\n" +
                    "Day 3 (Total: 320-370 cal):\n" +
                    "  - Bodyweight Squats: 3 sets of 15-20 reps\n" +
                    "  - Incline Push-ups: 3 sets of 12-15 reps\n" +
                    "  - Side Plank: Hold for 30 seconds each side\n" +
                    "  - Jumping Jacks: 3 sets of 30 seconds\n" +
                    "  - Resistance Band Shoulder Press: 3 sets of 12 reps\n\n" +
                    "Day 4 (Total: 200 cal):\n" +
                    "  - Light Cardio (30 minutes walk or light jog)\n\n" +
                    "Day 5 (Total: 320-370 cal):\n" +
                    "  - Burpees: 3 sets of 10 reps\n" +
                    "  - Bulgarian Split Squats: 3 sets of 12 reps per leg\n" +
                    "  - Russian Twists: 3 sets of 20 reps\n" +
                    "  - Mountain Climbers: 3 sets of 30 seconds\n" +
                    "  - Resistance Band Bicep Curls: 3 sets of 15 reps\n\n" +
                    "Day 6 (Total: 200 cal):\n" +
                    "  - Light Cardio (30 minutes walk or light jog)\n\n" +
                    "Day 7 (Total: 350-400 cal):\n" +
                    "  - Full Body Circuit: 3 rounds of:\n" +
                    "    - Push-ups (10 reps)\n" +
                    "    - Squat Jumps (15 reps)\n" +
                    "    - Plank (30 seconds)\n" +
                    "    - Burpees (10 reps)\n" +
                    "    - Resistance Band Deadlifts (12 reps)\n";
        } else if (bodyType.equalsIgnoreCase("mesomorph")) {
            return "Mesomorph 7-Day Home Workout Plan:\n\n" +
                    "Day 1 (Total: 350-400 cal):\n" +
                    "  - Lunges: 4 sets of 10-12 reps per leg\n" +
                    "  - Push-ups: 4 sets of 12-15 reps\n" +
                    "  - Plank to Push-up: 3 sets of 10 reps\n" +
                    "  - Mountain Climbers: 4 sets of 30 seconds\n" +
                    "  - Resistance Band Rows: 4 sets of 15 reps\n\n" +
                    "Day 2 (Total: 250 cal):\n" +
                    "  - HIIT Cardio: 20 minutes (alternating 1 minute sprint, 1 minute walk)\n\n" +
                    "Day 3 (Total: 370-420 cal):\n" +
                    "  - Bulgarian Split Squats: 4 sets of 10-12 reps per leg\n" +
                    "  - Tricep Dips: 4 sets of 12-15 reps\n" +
                    "  - Side Plank: Hold for 30-45 seconds each side\n" +
                    "  - Jump Rope: 4 sets of 1 minute\n" +
                    "  - Resistance Band Shoulder Press: 4 sets of 12 reps\n\n" +
                    "Day 4 (Total: 200 cal):\n" +
                    "  - Light Cardio (30 minutes walk or light jog)\n\n" +
                    "Day 5 (Total: 250 cal):\n" +
                    "  - HIIT Cardio: 20 minutes (alternating 1 minute sprint, 1 minute walk)\n\n" +
                    "Day 6 (Total: 370-420 cal):\n" +
                    "  - Full Body Strength:\n" +
                    "    - Squats: 4 sets of 12 reps\n" +
                    "    - Push-ups: 4 sets of 12-15 reps\n" +
                    "    - Plank with Shoulder Taps: 3 sets of 20 taps\n" +
                    "    - Burpees: 3 sets of 12 reps (70 cal)\n" +
                    "    - Resistance Band Deadlifts: 4 sets of 15 reps\n\n" +
                    "Day 7 (Total: 150 cal):\n" +
                    "  - Active Recovery (Yoga or Stretching, 30 minutes)\n";
        } else if (bodyType.equalsIgnoreCase("endomorph")) {
            return "Endomorph 7-Day Home Workout Plan:\n\n" +
                    "Day 1 (Total: 400-450 cal):\n" +
                    "  - Squats: 4 sets of 15-20 reps\n" +
                    "  - Push-ups: 4 sets to failure\n" +
                    "  - Glute Bridges: 4 sets of 15 reps\n" +
                    "  - Jumping Jacks: 3 sets of 30 seconds\n" +
                    "  - Resistance Band Rows: 4 sets of 15 reps\n\n" +
                    "Day 2 (Total: 300 cal):\n" +
                    "  - HIIT Cardio: 30 minutes (alternating 1 minute high-intensity, 1 minute low-intensity)\n\n" +
                    "Day 3 (Total: 400-450 cal):\n" +
                    "  - Lunges: 4 sets of 15 reps per leg\n" +
                    "  - Tricep Dips: 4 sets of 15 reps\n" +
                    "  - Side Plank: Hold for 30-60 seconds each side\n" +
                    "  - Burpees: 3 sets of 12 reps\n" +
                    "  - Resistance Band Shoulder Press: 4 sets of 15 reps\n\n" +
                    "Day 4 (Total: 200 cal):\n" +
                    "  - Light Cardio (30 minutes walk or light jog)\n\n" +
                    "Day 5 (Total: 300 cal):\n" +
                    "  - HIIT Cardio: 30 minutes (alternating 1 minute high-intensity, 1 minute low-intensity)\n\n" +
                    "Day 6 (Total: 400-450 cal):\n" +
                    "  - Full Body Workout:\n" +
                    "    - Squats: 4 sets of 20 reps\n" +
                    "    - Push-ups: 4 sets to failure\n" +
                    "    - Glute Bridges: 4 sets of 20 reps\n" +
                    "    - Mountain Climbers: 3 sets of 30 seconds\n" +
                    "    - Resistance Band Deadlifts: 4 sets of 15 reps\n\n" +
                    "Day 7 (Total: 150 cal):\n" +
                    "  - Active Recovery (Yoga or Stretching, 30 minutes)\n";
        } else {
            return "No workout plan available.";
        }
    }
}