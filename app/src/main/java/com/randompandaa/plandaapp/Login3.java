package com.randompandaa.plandaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.content.Intent;
import android.os.Bundle;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login3 extends AppCompatActivity {


    private FirebaseAuth mAuth;
    private EditText email, password;
    private Button btnLogin;
    private TextView textRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login3);
        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.login_email_eTxt);
        password = findViewById(R.id.login_password_eTxt);
        btnLogin  = findViewById(R.id.login_btn);
        textRegister = findViewById(R.id.register_btn);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });


        textRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login3.this, RegisterActivity.class));
            }
        });
    }


    private void login()
    {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        if(user.isEmpty())
        {            email.setError("Email can not be empty");        }
        if(pass.isEmpty())
        {            password.setError("Password can not be empty");        }
        else
        {
            mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(Login3.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Login3.this , MainActivity.class));
                    }
                    else
                    {
                        Toast.makeText(Login3.this, "Login Failed"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}


//    private FirebaseAuth mAuth;
//        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_main);
////        Button bCreate = findViewById(R.id.button);
////        Button bSignIn = findViewById(R.id.login_btn);
////        Button bInfo = findViewById(R.id.notUsedBtn);
////        EditText etEmail = findViewById(R.id.login_email_eText);
////        EditText etPassword = findViewById(R.id.login_password_eText);
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {

//
//        // Firebase Auth
//        mAuth = FirebaseAuth.getInstance();
//
//        //Register code
////        bCreate.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String sEmail = etEmail.getText().toString();
////                String sPassword = etPassword.getText().toString();
////                mAuth.createUserWithEmailAndPassword(sEmail, sPassword)
////                        .addOnCompleteListener(Login3.this, new OnCompleteListener<AuthResult>() {
////                            @Override
////                            public void onComplete(@NonNull Task<AuthResult> task) {
////                                if (task.isSuccessful()) {
////                                    // Sign in success, update UI with the signed-in user's information
////                                    //Log.d(TAG, "createUserWithEmail:success");
////                                    FirebaseUser user = mAuth.getCurrentUser();
////                                    Toast.makeText(getApplicationContext(), "Created User with Email: " + user.getEmail(), Toast.LENGTH_SHORT).show();
////                                    //updateUI(user);
////                                } else {
////                                    // If sign in fails, display a message to the user.
////                                    //Log.w(TAG, "createUserWithEmail:failure", task.getException());
////                                    Toast.makeText(Login3.this, "Authentication failed.",
////                                            Toast.LENGTH_SHORT).show();
////                                    //updateUI(null);
////                                }
////                            }
////                        });
////            }
////        });
//        bSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String sEmail = etEmail.getText().toString();
//                String sPassword = etPassword.getText().toString();
//                mAuth.signInWithEmailAndPassword(sEmail, sPassword)
//                        .addOnCompleteListener(Login3.this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    // Sign in success, update UI with the signed-in user's information
//                                    //Log.d(TAG, "signInWithEmail:success");
//                                    FirebaseUser user = mAuth.getCurrentUser();
//                                    Toast.makeText(getApplicationContext(), "Signed In User with Email: " + user.getEmail(), Toast.LENGTH_SHORT).show();
//                                    //updateUI(user);
//                                } else {
//                                    // If sign in fails, display a message to the user.
//                                    //Log.w(TAG, "signInWithEmail:failure", task.getException());
//                                    Toast.makeText(Login3.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                                    //updateUI(null);
//                                }
//
//                                // ...
//                            }
//                        });
//            }
//        });
//
//        //Info code:
////        bInfo.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
////                if (user != null) {
////                    // Name, email address, and profile photo Url
////                    String name = user.getDisplayName();
////                    String email = user.getEmail();
////                    Uri photoUrl = user.getPhotoUrl();
////
////                    // Check if user's email is verified
////                    boolean emailVerified = user.isEmailVerified();
////
////                    // The user's ID, unique to the Firebase project. Do NOT use this value to
////                    // authenticate with your backend server, if you have one. Use
////                    // FirebaseUser.getIdToken() instead.
////                    String uid = user.getUid();
////                    Toast.makeText(getApplicationContext(), "User Details: " + user.toString(), Toast.LENGTH_SHORT).show();
////                }
////            }
////        });
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if (currentUser == null) {
//            Toast.makeText(getApplicationContext(), "Current User is Null", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(getApplicationContext(), "Current User is " + currentUser.getEmail(), Toast.LENGTH_SHORT).show();
//            //updateUI(currentUser);
//        }
//    }
//}
