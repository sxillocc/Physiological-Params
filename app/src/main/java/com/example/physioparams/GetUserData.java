package com.example.physioparams;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetUserData extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user_data);
        EditText et1 = (EditText)findViewById(R.id.ET1);
        EditText et2 = (EditText)findViewById(R.id.ET2);
        EditText et3 = (EditText)findViewById(R.id.ET3);
        Button bt1 = (Button)findViewById(R.id.Continue);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height = Integer.parseInt(et1.getText().toString());
                int weight = Integer.parseInt(et2.getText().toString());
                int age = Integer.parseInt(et3.getText().toString());
                Intent intent = new Intent(GetUserData.this,BloodPressure.class);
                intent.putExtra("Height",height);
                intent.putExtra("Weight",weight);
                intent.putExtra("Age",age);
                startActivity(intent);
            }
        });
    }
}