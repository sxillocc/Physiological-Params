package com.example.physioparams;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

class UserData{
    public String name,mobile,gender,model,mobileOS;
    public int height,weight,age;
    public int HR,DP,SP;
    public int actualHR,actualDP,actualSP;
    UserData(String name,String mobile,int height,int weight,int age,String gender,int HR,
             int DP,int SP,String model,String mobileOS,int actualHR,int actualDP,int actualSP){
         this.name = name;
         this.mobile = mobile;
         this.height = height;
         this.weight = weight;
         this.age = age;
         this.gender = gender;
         this.HR = HR;
         this.DP = DP;
         this.SP = SP;
         this.model = model;
         this.mobileOS = mobileOS;
         this.actualHR = actualHR;
         this.actualDP = actualDP;
         this.actualSP = actualSP;
    }
}

public class ShowResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result);
        Intent intent = getIntent();
        if(intent!=null)
        {
            String name,mobile,gender;
            int height,weight,age,actualHR,actualDP,actualSP;
            int HeartRate = intent.getIntExtra("Heart Rate",0);
            int DP = intent.getIntExtra("DP",0);
            int SP = intent.getIntExtra("SP",0);
            int HR = intent.getIntExtra("HR",0);
            name = intent.getStringExtra("Name");
            mobile = intent.getStringExtra("Mobile");
            age = intent.getIntExtra("Age",0);
            height = intent.getIntExtra("Height",0);
            weight = intent.getIntExtra("Weight",0);
            actualHR = intent.getIntExtra("ActualHR",0);
            actualDP = intent.getIntExtra("ActualDP",0);
            actualSP = intent.getIntExtra("ActualSP",0);

            Log.i("Height ", ""+height);
            if(intent.getIntExtra("Gender",1) == 1){
                gender = "Male";
            }
            else{
                gender = "Female";
            }


            Log.e("Age in Show Result",""+age);


            TextView tv1 = findViewById(R.id.TV1);
            TextView tv2 = findViewById(R.id.TV2);
            TextView tv3 = findViewById(R.id.TV3);

            if(DP == 0)
            {
                tv1.setText("Heart Rate: "+HeartRate);
            }
            else {
                tv1.setText("Heart Rate: " + HR);
                tv2.setText("Diastolic BP: " + DP);
                tv3.setText("Systolic BP: " + SP);
            }
            String model = Build.MANUFACTURER + " " + Build.MODEL;
            String mobileOS = Build.VERSION_CODES.class.getFields()[android.os.Build.VERSION.SDK_INT].getName();

            UserData user = new UserData(name,mobile,height,weight,age,gender,HR,DP,SP,model,mobileOS,actualHR,actualDP,actualSP);

            FirebaseDatabase database = FirebaseDatabase.getInstance("https://physio-params-default-rtdb.firebaseio.com/");
            DatabaseReference dbRef = database.getReference("UserData");
            DatabaseReference userRef = dbRef.push();
            userRef.setValue(user);
        }
    }
}