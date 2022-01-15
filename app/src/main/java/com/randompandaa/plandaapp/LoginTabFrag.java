package com.randompandaa.plandaapp;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class LoginTabFrag extends Fragment {

    private FirebaseAuth mAuth;
    private EditText email, password;
    private Button btnLogin;
    private TextView textLogin;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.login_tab_frag, container, false);


        mAuth = FirebaseAuth.getInstance();
        email = email.findViewById(R.id.login_email_eTxt);
        password = password.findViewById(R.id.login_password_txt);
        btnLogin = btnLogin.findViewById(R.id.login_btn);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //login();
            }
        });


        return view;
}



    }
//
//    private void login() {
//        String user = email.getText().toString().trim();
//        String pass = password.getText().toString().trim();
//        if(user.isEmpty()){
//            email.setError("No Email Provided..");
//        }
//        if(pass.isEmpty()){
//            password.setError("No Password Provided..");
//        }
//        else{
//            mAuth.signInWithEmailAndPassword(user,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                @Override
//                public void onComplete(@NonNull Task<AuthResult> task) {
//                    if(task.isSuccessful()){
//                        Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getActivity(), MainActivity.class);
//                        startActivity(intent);
//                    }
//
//
//                }
//            });
//        }
//    }
//
//
//
//    public void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser == null){
//            //startActivity
//        }
//    }
//
//
//
//
//
//}
