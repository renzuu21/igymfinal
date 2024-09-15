package com.example.igymfinal;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CaptureActivity extends AppCompatActivity {

    private TextView textViewCapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        textViewCapture = findViewById(R.id.textViewCapture);
        textViewCapture.setText("Capture");
    }
}
