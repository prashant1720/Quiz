package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    CardView cd;
    TextView create;
    Button login;
    EditText email_login, Password_login;
    FirebaseAuth firebaseAuth=FirebaseAuth.getInstance() ;

    private FirebaseAuth.AuthStateListener authStateListener;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create = findViewById(R.id.CreateOne);
        login = findViewById(R.id.login_btn);
        email_login = findViewById(R.id.email_login);
        Password_login = findViewById(R.id.Password_login);
















        authStateListener = new FirebaseAuth.AuthStateListener() {


            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
                if (firebaseUser != null) {


                    Toast.makeText(MainActivity.this, "you are logged in", Toast.LENGTH_LONG);
                    Intent intent = new Intent(MainActivity.this, Quiz.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Please Login", Toast.LENGTH_LONG).show();
                }
            }
        };

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email_login = email_login.getText().toString().trim();
                String Pass_login = Password_login.getText().toString().trim();
                if (Email_login.isEmpty()) {
                    email_login.setError("Please enter email id");
                    email_login.requestFocus();
                } else if (Pass_login.isEmpty()) {
                    Password_login.setError("Please enter your Password");
                    Password_login.requestFocus();
                } else if (!(Email_login.isEmpty() && Pass_login.isEmpty())) {
                    firebaseAuth.signInWithEmailAndPassword(Email_login, Pass_login).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(MainActivity.this, "Login error try again", Toast.LENGTH_LONG).show();
                            } else {
                                Intent intent = new Intent(MainActivity.this, Quiz.class);
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Register.class);
                startActivity(intent);
            }
        });


    }
}
