package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get the result from the intent as a double
        double result = getIntent().getDoubleExtra("result", 0.0);

        // Display the result in a TextView
        TextView resultTextView = findViewById(R.id.resultTextView);
        resultTextView.setText("" + result);
    }
}

