package com.example.igymfinal;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DietActivity extends AppCompatActivity {

    private TextView textViewDiet;
    private DatabaseHelper databaseHelper;
    private String userBodyType;
    private double userBMI;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        textViewDiet = findViewById(R.id.textViewDiet);
        databaseHelper = new DatabaseHelper(this);

        String username = getIntent().getStringExtra("username");

        Cursor cursor = databaseHelper.getUserByUsername(username);
        if (cursor != null && cursor.moveToFirst()) {
            userBodyType = cursor.getString(cursor.getColumnIndex("body_type"));
            userBMI = cursor.getDouble(cursor.getColumnIndex("bmi"));

            String dietPlan = suggestDiet(userBodyType, userBMI);
            textViewDiet.setText(dietPlan);

            cursor.close();
        }

        setupBottomNavigation();
    }

    private String suggestDiet(String bodyType, double bmi) {
        if (bodyType == null || bodyType.isEmpty()) {
            return "No diet plan available.";
        }
        if (bmi < 18.5) {
            return "Underweight Diet:\n\n" +
                    "Day 1 (Total: 2255 cal):\n" +
                    "  Breakfast: 2 Eggs (140 cal), Avocado toast (250 cal), Orange juice (110 cal)\n" +
                    "  Lunch: Grilled chicken (300 cal), Brown rice (215 cal), Spinach salad (80 cal)\n" +
                    "  Dinner: Salmon (400 cal), Sweet potatoes (180 cal), Green beans (60 cal)\n\n" +
                    "Day 2 (Total: 2380 cal):\n" +
                    "  Breakfast: Oats with almonds and honey (350 cal)\n" +
                    "  Lunch: Turkey sandwich with whole wheat bread (400 cal)\n" +
                    "  Dinner: Beef stir-fry with quinoa (450 cal)\n\n" +
                    "Day 3 (Total: 2300 cal):\n" +
                    "  Breakfast: Smoothie with banana, spinach, and protein powder (300 cal)\n" +
                    "  Lunch: Grilled chicken wrap (400 cal)\n" +
                    "  Dinner: Spaghetti with meat sauce (500 cal)\n\n" +
                    "Day 4 (Total: 2420 cal):\n" +
                    "  Breakfast: Pancakes with syrup (400 cal)\n" +
                    "  Lunch: Lentil soup (300 cal), Whole wheat bread (100 cal)\n" +
                    "  Dinner: Baked cod with roasted vegetables (350 cal)\n\n" +
                    "Day 5 (Total: 2290 cal):\n" +
                    "  Breakfast: Greek yogurt with granola (250 cal)\n" +
                    "  Lunch: Tuna sandwich (350 cal), Salad (100 cal)\n" +
                    "  Dinner: Chicken curry with rice (500 cal)\n\n" +
                    "Day 6 (Total: 2400 cal):\n" +
                    "  Breakfast: Smoothie with berries, spinach, and protein powder (300 cal)\n" +
                    "  Lunch: Quinoa salad with avocado and nuts (450 cal)\n" +
                    "  Dinner: Grilled salmon with couscous and vegetables (500 cal)\n\n" +
                    "Day 7 (Total: 2300 cal):\n" +
                    "  Breakfast: Eggs with avocado (250 cal), Whole wheat toast (150 cal)\n" +
                    "  Lunch: Chicken breast with brown rice (350 cal)\n" +
                    "  Dinner: Steak with sweet potato fries (500 cal)\n";
        } else if (bmi >= 18.5 && bmi < 24.9) {
            if (bodyType.equalsIgnoreCase("ectomorph")) {
                return "Ectomorph Diet:\n\n" +
                        "Day 1 (Total: 2565 cal):\n" +
                        "  Breakfast: Greek yogurt with granola (300 cal), Banana (105 cal)\n" +
                        "  Lunch: Grilled chicken wrap (400 cal), Carrot sticks (50 cal)\n" +
                        "  Dinner: Pasta with lean ground turkey (500 cal), Side salad (100 cal)\n" +
                        "  Snacks: Almonds (150 cal), Protein bar (160 cal)\n\n" +
                        "Day 2 (Total: 2700 cal):\n" +
                        "  Breakfast: Scrambled eggs (200 cal), Whole wheat toast (150 cal), Berries (70 cal)\n" +
                        "  Lunch: Tuna salad (350 cal), Apple (95 cal)\n" +
                        "  Dinner: Steak (400 cal), Brown rice (215 cal), Broccoli (50 cal)\n" +
                        "  Snacks: Peanut butter sandwich (300 cal), Protein shake (250 cal)\n\n" +
                        "Day 3 (Total: 2655 cal):\n" +
                        "  Breakfast: Oats with almonds and honey (350 cal)\n" +
                        "  Lunch: Chicken sandwich with avocado (400 cal)\n" +
                        "  Dinner: Beef stir-fry with vegetables (500 cal)\n" +
                        "  Snacks: Smoothie with spinach, banana, and protein powder (300 cal), Mixed nuts (200 cal)\n\n" +
                        "Day 4 (Total: 2600 cal):\n" +
                        "  Breakfast: Pancakes with berries (400 cal)\n" +
                        "  Lunch: Grilled turkey sandwich (450 cal)\n" +
                        "  Dinner: Shrimp stir-fry with brown rice (500 cal)\n" +
                        "  Snacks: Apple with peanut butter (200 cal), Trail mix (200 cal)\n\n" +
                        "Day 5 (Total: 2750 cal):\n" +
                        "  Breakfast: Greek yogurt with granola (300 cal)\n" +
                        "  Lunch: Chicken quinoa salad (450 cal)\n" +
                        "  Dinner: Grilled salmon with couscous (500 cal)\n" +
                        "  Snacks: Protein bar (200 cal), Mixed nuts (150 cal)\n\n" +
                        "Day 6 (Total: 2580 cal):\n" +
                        "  Breakfast: Smoothie with spinach, berries, and protein powder (300 cal)\n" +
                        "  Lunch: Grilled chicken salad (400 cal)\n" +
                        "  Dinner: Turkey meatballs with whole wheat pasta (500 cal)\n" +
                        "  Snacks: Almonds (160 cal), Protein shake (200 cal)\n\n" +
                        "Day 7 (Total: 2705 cal):\n" +
                        "  Breakfast: Eggs with spinach and toast (250 cal)\n" +
                        "  Lunch: Tuna salad (350 cal)\n" +
                        "  Dinner: Chicken curry with brown rice (500 cal)\n" +
                        "  Snacks: Smoothie (300 cal), Mixed nuts (200 cal)\n";
            } else if (bodyType.equalsIgnoreCase("mesomorph")) {
                return "Mesomorph Diet:\n\n" +
                        "Day 1 (Total: 2100 cal):\n" +
                        "  Breakfast: Oatmeal with berries and almonds (350 cal)\n" +
                        "  Lunch: Quinoa salad with chickpeas (450 cal)\n" +
                        "  Dinner: Grilled salmon (400 cal), Roasted vegetables (150 cal)\n" +
                        "  Snacks: Apple (95 cal), Greek yogurt (150 cal)\n\n" +
                        "Day 2 (Total: 2200 cal):\n" +
                        "  Breakfast: Smoothie with spinach, banana, and protein powder (300 cal)\n" +
                        "  Lunch: Chicken breast (200 cal), Sweet potato (180 cal)\n" +
                        "  Dinner: Shrimp stir-fry (400 cal)\n" +
                        "  Snacks: Protein bar (200 cal), Mixed nuts (150 cal)\n\n" +
                        "Day 3 (Total: 2300 cal):\n" +
                        "  Breakfast: Scrambled eggs with avocado (250 cal)\n" +
                        "  Lunch: Tuna salad (350 cal)\n" +
                        "  Dinner: Grilled chicken with brown rice (450 cal)\n" +
                        "  Snacks: Greek yogurt (150 cal), Almonds (160 cal)\n\n" +
                        "Day 4 (Total: 2450 cal):\n" +
                        "  Breakfast: Smoothie with protein powder and banana (300 cal)\n" +
                        "  Lunch: Grilled turkey sandwich (400 cal)\n" +
                        "  Dinner: Grilled shrimp with couscous (500 cal)\n" +
                        "  Snacks: Mixed nuts (150 cal), Protein shake (200 cal)\n\n" +
                        "Day 5 (Total: 2200 cal):\n" +
                        "  Breakfast: Greek yogurt with honey and nuts (300 cal)\n" +
                        "  Lunch: Quinoa salad with grilled chicken (450 cal)\n" +
                        "  Dinner: Baked cod with steamed vegetables (350 cal)\n" +
                        "  Snacks: Apple with peanut butter (200 cal)\n\n" +
                        "Day 6 (Total: 2000 cal):\n" +
                        "  Breakfast: Scrambled eggs with spinach (250 cal)\n" +
                        "  Lunch: Grilled chicken wrap (350 cal)\n" +
                        "  Dinner: Stir-fried tofu with vegetables (400 cal)\n" +
                        "  Snacks: Greek yogurt (150 cal), Mixed nuts (200 cal)\n\n" +
                        "Day 7 (Total: 2100 cal):\n" +
                        "  Breakfast: Smoothie with spinach, protein powder, and berries (300 cal)\n" +
                        "  Lunch: Tuna salad with avocado (350 cal)\n" +
                        "  Dinner: Grilled steak with sweet potato (450 cal)\n" +
                        "  Snacks: Greek yogurt (150 cal), Protein bar (200 cal)\n";
            } else if (bodyType.equalsIgnoreCase("endomorph")) {
                return "Endomorph Diet:\n\n" +
                        "Day 1 (Total: 2100 cal):\n" +
                        "  Breakfast: Oatmeal with berries and almonds (350 cal)\n" +
                        "  Lunch: Quinoa salad with chickpeas (450 cal)\n" +
                        "  Dinner: Grilled salmon (400 cal), Roasted vegetables (150 cal)\n" +
                        "  Snacks: Apple (95 cal), Greek yogurt (150 cal)\n\n" +
                        "Day 2 (Total: 2200 cal):\n" +
                        "  Breakfast: Smoothie with spinach, banana, and protein powder (300 cal)\n" +
                        "  Lunch: Chicken breast (200 cal), Sweet potato (180 cal)\n" +
                        "  Dinner: Shrimp stir-fry (400 cal)\n" +
                        "  Snacks: Protein bar (200 cal), Mixed nuts (150 cal)\n\n" +
                        "Day 3 (Total: 2300 cal):\n" +
                        "  Breakfast: Scrambled eggs with avocado (250 cal)\n" +
                        "  Lunch: Tuna salad (350 cal)\n" +
                        "  Dinner: Grilled chicken with brown rice (450 cal)\n" +
                        "  Snacks: Greek yogurt (150 cal), Almonds (160 cal)\n\n" +
                        "Day 4 (Total: 2450 cal):\n" +
                        "  Breakfast: Smoothie with protein powder and banana (300 cal)\n" +
                        "  Lunch: Grilled turkey sandwich (400 cal)\n" +
                        "  Dinner: Grilled shrimp with couscous (500 cal)\n" +
                        "  Snacks: Mixed nuts (150 cal), Protein shake (200 cal)\n\n" +
                        "Day 5 (Total: 2200 cal):\n" +
                        "  Breakfast: Greek yogurt with honey and nuts (300 cal)\n" +
                        "  Lunch: Quinoa salad with grilled chicken (450 cal)\n" +
                        "  Dinner: Baked cod with steamed vegetables (350 cal)\n" +
                        "  Snacks: Apple with peanut butter (200 cal)\n\n" +
                        "Day 6 (Total: 2000 cal):\n" +
                        "  Breakfast: Scrambled eggs with spinach (250 cal)\n" +
                        "  Lunch: Grilled chicken wrap (350 cal)\n" +
                        "  Dinner: Stir-fried tofu with vegetables (400 cal)\n" +
                        "  Snacks: Greek yogurt (150 cal), Mixed nuts (200 cal)\n\n" +
                        "Day 7 (Total: 2100 cal):\n" +
                        "  Breakfast: Smoothie with spinach, protein powder, and berries (300 cal)\n" +
                        "  Lunch: Tuna salad with avocado (350 cal)\n" +
                        "  Dinner: Grilled steak with sweet potato (450 cal)\n" +
                        "  Snacks: Greek yogurt (150 cal), Protein bar (200 cal)\n";
            }
        } else if (bmi >= 25) {
            return "Overweight Diet:\n\n" +
                    "Day 1 (Total: 1600 cal):\n" +
                    "  Breakfast: Scrambled eggs (200 cal), Avocado (120 cal)\n" +
                    "  Lunch: Grilled chicken salad with olive oil dressing (350 cal)\n" +
                    "  Dinner: Baked salmon (400 cal), Steamed broccoli (50 cal), Quinoa (150 cal)\n" +
                    "  Snacks: Greek yogurt (100 cal), Almonds (80 cal)\n\n" +
                    "Day 2 (Total: 1550 cal):\n" +
                    "  Breakfast: Smoothie with spinach, almond milk, and protein powder (250 cal)\n" +
                    "  Lunch: Turkey lettuce wrap with hummus (300 cal)\n" +
                    "  Dinner: Grilled shrimp with zucchini noodles (400 cal)\n" +
                    "  Snacks: Carrot sticks (50 cal), Protein bar (150 cal)\n\n" +
                    "Day 3 (Total: 1650 cal):\n" +
                    "  Breakfast: Greek yogurt with mixed berries (150 cal)\n" +
                    "  Lunch: Chicken breast with quinoa and veggies (400 cal)\n" +
                    "  Dinner: Stir-fried tofu with vegetables (350 cal)\n" +
                    "  Snacks: Almonds (100 cal), Hard-boiled egg (70 cal)\n\n" +
                    "Day 4 (Total: 1700 cal):\n" +
                    "  Breakfast: Omelette with spinach and mushrooms (200 cal)\n" +
                    "  Lunch: Tuna salad with mixed greens (350 cal)\n" +
                    "  Dinner: Grilled steak (400 cal), Roasted cauliflower (50 cal)\n" +
                    "  Snacks: Mixed nuts (120 cal), Greek yogurt (100 cal)\n\n" +
                    "Day 5 (Total: 1500 cal):\n" +
                    "  Breakfast: Smoothie with avocado, spinach, and protein powder (250 cal)\n" +
                    "  Lunch: Turkey sandwich with lettuce wraps (300 cal)\n" +
                    "  Dinner: Grilled chicken with roasted vegetables (400 cal)\n" +
                    "  Snacks: Celery with peanut butter (80 cal), Boiled egg (70 cal)\n\n" +
                    "Day 6 (Total: 1650 cal):\n" +
                    "  Breakfast: Scrambled eggs with turkey bacon (250 cal)\n" +
                    "  Lunch: Shrimp salad with olive oil and vinegar (350 cal)\n" +
                    "  Dinner: Baked cod with roasted asparagus (350 cal)\n" +
                    "  Snacks: Protein shake (150 cal), Mixed nuts (100 cal)\n\n" +
                    "Day 7 (Total: 1600 cal):\n" +
                    "  Breakfast: Greek yogurt with flaxseeds (150 cal)\n" +
                    "  Lunch: Grilled chicken with avocado (400 cal)\n" +
                    "  Dinner: Turkey meatballs with zucchini noodles (350 cal)\n" +
                    "  Snacks: Cottage cheese (100 cal), Protein bar (150 cal)\n";
        }
        return "No diet plan available.";
    }

    private void setupBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.navigation_profile) {
                startActivity(new Intent(DietActivity.this, ProfileActivity.class));
                return true;
            } else if (item.getItemId() == R.id.navigation_capture) {
                startActivity(new Intent(DietActivity.this, CaptureActivity.class));
                return true;
            } else if (item.getItemId() == R.id.navigation_diet) {
                return true;
            } else if (item.getItemId() == R.id.navigation_exercise) {
                startActivity(new Intent(DietActivity.this, MainActivity.class));
                return true;
            }
            return false;
        });
    }
}
