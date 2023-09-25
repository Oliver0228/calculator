package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void performOperation(View view) {
        EditText num1EditText = findViewById(R.id.num1EditText);
        EditText num2EditText = findViewById(R.id.num2EditText);

        try {
            double num1 = Double.parseDouble(num1EditText.getText().toString());
            double num2 = Double.parseDouble(num2EditText.getText().toString());
            double result = 0.0; // Initialize with 0.0 for safety

            // Determine the operation based on the clicked button's ID
            int viewId = view.getId();
            if (viewId == R.id.addButton) {
                result = num1 + num2;
            } else if (viewId == R.id.subtractButton) {
                result = num1 - num2;
            } else if (viewId == R.id.multiplyButton) {
                result = num1 * num2;
            } else if (viewId == R.id.divideButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    // Handle division by zero error
                    Toast.makeText(this, "Division by zero is not allowed.", Toast.LENGTH_SHORT).show();
                    return;
                }
            }

            // Create an Intent to start ResultActivity
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("result", result);

            // Start ResultActivity
            startActivity(intent);
        } catch (NumberFormatException e) {
            // Handle invalid input
            Toast.makeText(this, "Please enter valid numeric values.", Toast.LENGTH_SHORT).show();
        }
    }
}
