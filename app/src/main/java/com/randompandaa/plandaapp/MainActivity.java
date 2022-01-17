package com.randompandaa.plandaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button btnLogout;

    private Button camera;
    private Button sensor;
    private Button DB;



    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        btnLogout = findViewById(R.id.logout_btn);
        camera = findViewById(R.id.cameraBtn);
        sensor = findViewById(R.id.sensorBtn);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                Toast.makeText(MainActivity.this, "User Logged Out Successfully", Toast.LENGTH_SHORT).show();

            }
        });

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Camera.class));
                Toast.makeText(MainActivity.this, "Camera started", Toast.LENGTH_SHORT).show();
            }
        });

        sensor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LightSensor.class));
                Toast.makeText(MainActivity.this, "Light Sensor Initiated", Toast.LENGTH_SHORT).show();
            }
        });



    }

    public void onStart(){
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null) {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        else{
//            startActivity(new Intent(MainActivity.this, MainActivity.class)); //This line to be changed to new activity.
        }
        }

    public void logout(View view) {
        mAuth.signOut();
    }


}


