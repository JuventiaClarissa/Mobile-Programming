package com.example.fooddelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

public class MainActivity extends AppCompatActivity {

    EditText emailField;
    EditText passField;
    Button loginBtn;

    TextView err;
    TextView SignUpText,SignInText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        SignInText = findViewById(R.id.SignInText);
        SignUpText = findViewById(R.id.SignUpText);
        emailField = findViewById(R.id.emailField);
        passField = findViewById(R.id.passField);
        loginBtn = findViewById(R.id.loginBtn);

        err = findViewById(R.id.errMessage);





        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (emailField.getText().toString().equals("")){
                    err.setText("Email must be filled!");
                }else if (passField.getText().toString().equals("")){
                    err.setText("Password must be filles");
                } else{
                    Intent intent = new Intent(MainActivity.this, Home.class);

                    startActivity(intent);
                }

            }
        });



        SignUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });

        SignInText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignIn.class));
            }
        });

    }

}