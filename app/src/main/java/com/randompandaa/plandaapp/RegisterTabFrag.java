package com.randompandaa.plandaapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterTabFrag extends Fragment {

    private FirebaseAuth mAuth;
    private EditText email, password, passCheck;
    private Button btnLogin;
    private TextView textLogin;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup view = (ViewGroup) inflater.inflate(R.layout.register_tab_frag, container, false);


        btnLogin = view.findViewById(R.id.register_btn);
        email = view.findViewById(R.id.register_email_eTxt);
        password = view.findViewById(R.id.register_password_eTxt);
//        passCheck = view.findViewById(R.id.register_passConfirm_eTxt);

        // Firebase Auth
        mAuth = FirebaseAuth.getInstance();

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


