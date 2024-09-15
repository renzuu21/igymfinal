package com.example.igymfinal;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class BMIResultActivity extends AppCompatActivity {

    private TextView textViewDetails;
    private Button buttonBackToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_result);

        textViewDetails = findViewById(R.id.textViewDetails);
        buttonBackToLogin = findViewById(R.id.buttonBackToLogin);

        // Retrieve data from Intent
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age", 0);
        String gender = intent.getStringExtra("gender");
        String bodytype = intent.getStringExtra("bodytype");
        String heightStr = intent.getStringExtra("height"); // Retrieve as String
        String weightStr = intent.getStringExtra("weight"); // Retrieve as String
        float bmi = intent.getFloatExtra("bmi", 0);

        // Convert height and weight to float
        float height = Float.parseFloat(heightStr);
        float weight = Float.parseFloat(weightStr);

        // Get body type classification
        String bodyType = getBodyType(bmi);

        // Display user details and BMI
        String details = String.format("Name: %s\n\nAge: %d\n\nGender: %s\n\nHeight: %.1f cm\n\nWeight: %.1f kg\n\nBMI: %.2f\n\nClassification: %s\n\nBody Type: %s",
                name, age, gender, height, weight, bmi, bodyType, bodytype);
        textViewDetails.setText(details);

        // Set up button to go back to login
        buttonBackToLogin.setOnClickListener(v -> {
            Intent loginIntent = new Intent(BMIResultActivity.this, LoginActivity.class);
            startActivity(loginIntent);
        });
    }

    private String getBodyType(float bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal";
        } else {
            return "Overweight";
        }
    }
}




