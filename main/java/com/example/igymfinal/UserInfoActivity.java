package com.example.igymfinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {

    private EditText editTextName, editTextAge, editTextHeight, editTextWeight;
    private RadioGroup radioGroupGender, radioGroupBodyType;
    private RadioButton radioButtonSelectedGender, radioButtonSelectedBodyType;
    private Button buttonCalculateBMI;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioGroupBodyType = findViewById(R.id.radioGroupBodyType); // Initialize body type RadioGroup
        buttonCalculateBMI = findViewById(R.id.buttonCalculateBMI);
        databaseHelper = new DatabaseHelper(this);

        // Retrieve username and password from the Intent
        String username = getIntent().getStringExtra("username");
        String password = getIntent().getStringExtra("password");

        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String ageStr = editTextAge.getText().toString();
                String heightStr = editTextHeight.getText().toString();
                String weightStr = editTextWeight.getText().toString();

                int selectedGenderId = radioGroupGender.getCheckedRadioButtonId();
                radioButtonSelectedGender = findViewById(selectedGenderId);
                String gender = radioButtonSelectedGender.getText().toString();

                int selectedBodyTypeId = radioGroupBodyType.getCheckedRadioButtonId(); // Get selected body type
                radioButtonSelectedBodyType = findViewById(selectedBodyTypeId);
                String bodyType = radioButtonSelectedBodyType.getText().toString(); // Get body type text

                if (name.isEmpty() || ageStr.isEmpty() || heightStr.isEmpty() || weightStr.isEmpty()) {
                    Toast.makeText(UserInfoActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    int age = Integer.parseInt(ageStr);
                    float height = Float.parseFloat(heightStr) / 100; // Convert height to meters
                    float weight = Float.parseFloat(weightStr);
                    float bmi = weight / (height * height);

                    // Insert the user into the database
                    boolean isInserted = databaseHelper.addUser(username, password, name, age, gender, bodyType, height, weight, bmi);
                    if (isInserted) {
                        // Start BMIResultActivity with the results
                        Intent intent = new Intent(UserInfoActivity.this, BMIResultActivity.class);
                        intent.putExtra("name", name);
                        intent.putExtra("age", age);
                        intent.putExtra("gender", gender);
                        intent.putExtra("bodytype",bodyType);
                        intent.putExtra("height", heightStr);  // Pass as String to avoid type mismatch
                        intent.putExtra("weight", weightStr);  // Pass as String to avoid type mismatch
                        intent.putExtra("bmi", bmi);
                        startActivity(intent);
                    } else {
                        Toast.makeText(UserInfoActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}


