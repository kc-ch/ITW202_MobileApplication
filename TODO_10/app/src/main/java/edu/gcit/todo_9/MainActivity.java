package edu.gcit.todo_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText text1;
    private EditText text2;
    private TextView res;
    private Calculator mCalculator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1 = findViewById(R.id.editText1);
        text2 = findViewById(R.id.editText2);
        res = findViewById(R.id.textView);
        mCalculator = new Calculator();
    }

    public void add(View view) {
        String value1 = text1.getText().toString();
        String value2 = text2.getText().toString();
        double result = mCalculator.addition(Double.valueOf(value1),Double.valueOf(value2));
        res.setText(String.valueOf(result));
        Log.d("Debug", "Hello Bugs");
    }

    public void sub(View view) {
        String value1 = text1.getText().toString();
        String value2 = text2.getText().toString();
        double result = mCalculator.subtraction(Double.valueOf(value1),Double.valueOf(value2));
        res.setText(String.valueOf(result));
        Log.d("Debug", "Hello Bugs");
    }

    public void div(View view) {
        String value1 = text1.getText().toString();
        String value2 = text2.getText().toString();
        double result = mCalculator.division(Double.valueOf(value1),Double.valueOf(value2));
        res.setText(String.valueOf(result));
        Log.d("Debug", "Hello Bugs");
    }

    public void mul(View view) {
        String value1 = text1.getText().toString();
        String value2 = text2.getText().toString();
        double result = mCalculator.multiplication(Double.valueOf(value1),Double.valueOf(value2));
        res.setText(String.valueOf(result));
        Log.d("Debug", "Hello Bugs");
    }
}