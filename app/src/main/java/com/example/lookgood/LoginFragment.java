package com.example.lookgood;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginFragment extends Fragment {

    EditText email,password;
    FirebaseAuth fAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login,container,false);
        Button register = view.findViewById(R.id.register);
        Button login = view.findViewById(R.id.loginBtn);

        email = view.findViewById(R.id.log_email);
        password = view.findViewById(R.id.log_password);

        fAuth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RegisterFragment registerFragment = new RegisterFragment();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.container_fragment, registerFragment);
                fragmentTransaction.commit();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String emailText = email.getText().toString();
                final String passwordText = password.getText().toString();

                if(TextUtils.isEmpty(emailText)) {
                    email.setError("Email is Required");
                    return;
                }

                if(TextUtils.isEmpty(passwordText)){
                    password.setError("Password is Required");
                    return;
                }

                fAuth.signInWithEmailAndPassword(emailText,passwordText).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            //  Toast.makeText(getActivity(), "User created", Toast.LENGTH_SHORT).show();
                            HomeFragment homeFragment = new HomeFragment();
                            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.container_fragment,homeFragment);
                            fragmentTransaction.commit();

                        }else {
                            Toast.makeText(getActivity().getBaseContext(), "Enter something !", Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
        });

        return view;
    }


}
