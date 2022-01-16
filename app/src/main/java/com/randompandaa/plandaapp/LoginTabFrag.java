package com.randompandaa.plandaapp;



import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.concurrent.Executor;

public class LoginTabFrag extends Fragment {

    private FirebaseAuth mAuth;
    private EditText email, password;
    private Button btnLogin;
    private TextView textLogin;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.login_tab_frag, container, false);


        btnLogin = view.findViewById(R.id.login_btn);
        email = view.findViewById(R.id.login_email_eTxt);
        password = view.findViewById(R.id.login_password_eTxt);

        // Firebase Auth
        mAuth = FirebaseAuth.getInstance();





        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sEmail = email.getText().toString();
                String sPassword = password.getText().toString();
                mAuth.signInWithEmailAndPassword(sEmail, sPassword)
                        .addOnCompleteListener((Executor) LoginTabFrag.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    //Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(getActivity(), "Signed In User with Email: " + user.getEmail(), Toast.LENGTH_SHORT).show();
                                    //updateUI(user);
                                } else {
                                    Toast.makeText(getActivity(), "Error with sign-in", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        return view;
    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser == null) {
            Toast.makeText(getActivity(), "Current User is Null", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Current User is " + currentUser.getEmail(), Toast.LENGTH_SHORT).show();
            //updateUI(currentUser);
        }
    }
}
