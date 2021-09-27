package com.example.physioparams;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class GetUserData extends AppCompatActivity {
    RadioButton r1,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_user_data);
        EditText et1 = (EditText)findViewById(R.id.actualHR);
        EditText et2 = (EditText)findViewById(R.id.actualDP);
        EditText et3 = (EditText)findViewById(R.id.actualSP);
        EditText et4 = (EditText)findViewById(R.id.editheight);
        EditText et5 = (EditText)findViewById(R.id.editweight);

        r1 = (RadioButton)findViewById(R.id.rb1);
        r2 = (RadioButton)findViewById(R.id.rb2);
        Button bt1 = (Button)findViewById(R.id.buttonmeasure);

        String MobilePattern = "[0-9]{10}";

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int age=0,height=0,weight=0,actualHR=0,actualDP=0,actualSP = 0;

                if(et1.getText().toString().trim().length()==0)
                    Toast.makeText(getApplicationContext(), "Enter name", Toast.LENGTH_SHORT).show();

                else if(et2.getText().toString().matches(MobilePattern)==false)
                    Toast.makeText(getApplicationContext(), "Enter valid mobile number (should be 10 characters long)", Toast.LENGTH_SHORT).show();

                else if(et3.getText().toString().trim().length()==0)
                    Toast.makeText(getApplicationContext(), "Enter valid age", Toast.LENGTH_SHORT).show();

                else if(et4.getText().toString().trim().length()==0)
                    Toast.makeText(getApplicationContext(), "Enter valid height", Toast.LENGTH_SHORT).show();

                else if(et5.getText().toString().trim().length()==0)
                    Toast.makeText(getApplicationContext(), "Enter valid weight", Toast.LENGTH_SHORT).show();

//                else if(et6.getText().toString().trim().length()==0)
//                    Toast.makeText(getApplicationContext(), "Enter valid HR", Toast.LENGTH_SHORT).show();
//
//                else if(et7.getText().toString().trim().length()==0)
//                    Toast.makeText(getApplicationContext(), "Enter valid DP", Toast.LENGTH_SHORT).show();
//
//                else if(et8.getText().toString().trim().length()==0)
//                    Toast.makeText(getApplicationContext(), "Enter valid SP", Toast.LENGTH_SHORT).show();


                else {
                    String name = et1.getText().toString();
                    String mobile = et2.getText().toString();
                    age = Integer.parseInt(et3.getText().toString());
                    height = Integer.parseInt(et4.getText().toString());
                    weight = Integer.parseInt(et5.getText().toString());

                    Intent intent = new Intent(GetUserData.this,BloodPressure.class);
                    intent.putExtra("Name",name);
                    intent.putExtra("Mobile",mobile);
                    intent.putExtra("Age",age);
                    intent.putExtra("Height",height);
                    intent.putExtra("Weight",weight);

                    if (r1.isChecked()) {
                        intent.putExtra("Gender", 1);        //1 for male
                        AlertDialog.Builder alertadd = new AlertDialog.Builder(GetUserData.this);
                        LayoutInflater factory = getLayoutInflater();
                        final View view = factory.inflate(R.layout.alertdialog2, null);
                        Button button1 = (Button) view.findViewById(R.id.b1); // etc.. for button2,3,4.
                        alertadd.setView(view);
                        alertadd.setCancelable(false);
                        alertadd.show();


                        button1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(intent);
                                finish();
                            }
                        });
                    } else if (r2.isChecked()) {
                        intent.putExtra("Gender", 2);        //2 for female
                        AlertDialog.Builder alertadd = new AlertDialog.Builder(GetUserData.this);
                        LayoutInflater factory = getLayoutInflater();
                        final View view = factory.inflate(R.layout.alertdialog2, null);
                        Button button1 = (Button) view.findViewById(R.id.b1); // etc.. for button2,3,4.
                        alertadd.setView(view);
                        alertadd.setCancelable(false);
                        alertadd.show();


                        button1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                startActivity(intent);
                                finish();
                            }
                        });
                    } else {
                        Toast t = Toast.makeText(GetUserData.this, "Please select gender", Toast.LENGTH_LONG);
                        t.show();
                    }
                }
            }
        });
    }
}