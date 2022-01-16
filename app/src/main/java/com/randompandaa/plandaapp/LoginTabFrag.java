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
    private TextView textLogin, swipe;
    float v=0;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.login_tab_frag, container, false);


<<<<<<< Updated upstream
=======
        btnLogin = view.findViewById(R.id.login_btn);
        email = view.findViewById(R.id.login_email_eTxt);
        password = view.findViewById(R.id.login_password_eTxt);
        swipe = view.findViewById(R.id.swipe_txt);

        // Firebase Auth
>>>>>>> Stashed changes
        mAuth = FirebaseAuth.getInstance();
        email = email.findViewById(R.id.login_email_eTxt);
        password = password.findViewById(R.id.login_password_txt);
        btnLogin = btnLogin.findViewById(R.id.login_btn);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
<<<<<<< Updated upstream
                //login();
            }
        });


        return view;
}

=======
                String sEmail = email.getText().toString();
                String sPassword = password.getText().toString();
                mAuth.signInWithEmailAndPassword(sEmail, sPassword).addOnCompleteListener((Executor) LoginTabFrag.this, new OnCompleteListener<AuthResult>() {
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

        email.setTranslationY(300);
        btnLogin.setTranslationY(300);
        password.setTranslationY(300);
        swipe.setTranslationY(300);

        email.setAlpha(v);
        btnLogin.setAlpha(v);
        password.setAlpha(v);
        swipe.setAlpha(v);

        email.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        btnLogin.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        password.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        swipe.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();


        return view;




    }
>>>>>>> Stashed changes


    }
<<<<<<< Updated upstream
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
=======


}
>>>>>>> Stashed changes
