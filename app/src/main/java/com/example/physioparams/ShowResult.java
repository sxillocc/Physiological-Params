package com.example.physioparams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        Intent intent = getIntent();
        if(intent!=null)
        {
            int HeartRate = intent.getIntExtra("Heart Rate",0);
            TextView tv1 = findViewById(R.id.TV1);
            tv1.setText("Heart Rate: "+HeartRate);
        }
    }
}