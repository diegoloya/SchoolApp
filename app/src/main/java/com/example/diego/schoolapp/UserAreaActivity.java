package com.example.diego.schoolapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.common.api.ResultCallback;
import com.google.firebase.auth.FirebaseAuth;

public class UserAreaActivity extends AppCompatActivity {
    Button bSignOut;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        mAuth = FirebaseAuth.getInstance();

        bSignOut = (Button) findViewById(R.id.bSignOut);

//        final EditText etUsername = (EditText) findViewById(R.id.etUsername);
//        final EditText etPassword = (EditText) findViewById(R.id.etPassword);
//        final TextView welcomeMessage = (TextView) findViewById(R.id.tvWelcomeMessage);

        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                if(firebaseAuth.getCurrentUser() != null){
                    startActivity(new Intent(UserAreaActivity.this, LoginActivity.class));
                }
            }
        };


        bSignOut.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                signOut();
            }
        });
    }


    private void signOut() {
        // Firebase sign out
        mAuth.signOut();
        startActivity(new Intent(UserAreaActivity.this, LoginActivity.class));
    }

}
