package com.example.user.calcapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        double value1 = intent.getDoubleExtra("value1", 0);
        double value2 = intent.getDoubleExtra("value2", 0);
        int flag = intent.getIntExtra("flag", 0);

        double result = 0.0;

        if(flag == 0){
            result = value1 + value2;
        }else if(flag == 1){
            result = value1 - value2;
        }else if(flag == 2){
            result = value1 * value2;
        }else if(flag == 3){
            result = value1 / value2;
        }

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(String.valueOf(result));
    }
}