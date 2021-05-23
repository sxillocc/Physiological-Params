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
            int DP = intent.getIntExtra("DP",0);
            int SP = intent.getIntExtra("SP",0);
            int HR = intent.getIntExtra("HR",0);

            TextView tv1 = findViewById(R.id.TV1);
            TextView tv2 = findViewById(R.id.TV2);
            TextView tv3 = findViewById(R.id.TV3);

            if(DP == 0)
            {
                tv1.setText("Heart Rate: "+HeartRate);
            }
            else
            {
                tv1.setText("Diastolic BP: "+DP);
                tv2.setText("Systolic BP: "+SP);
                tv3.setText("Heart Rate: "+HR);
            }
        }
    }
}