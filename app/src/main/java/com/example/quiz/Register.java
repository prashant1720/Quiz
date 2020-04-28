package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {





    Intent intent;

    EditText email_register, pass_register, register_confirmPass, register_name;
    private FirebaseAuth firebaseAuth;
    Button signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_register);


        email_register = findViewById(R.id.registeremail);
        pass_register = findViewById(R.id.registerpass);
        register_confirmPass = findViewById(R.id.confirmpass);
        register_name = findViewById(R.id.register_name);
        signup = findViewById(R.id.go_to_sigin);
        firebaseAuth = FirebaseAuth.getInstance();






   /*     signup.setOnClickListener(new View.OnClickListener()
        {
            @Override

            public void onClick(View v)
            {
                String namevalue = register_name.getText().toString();

                Intent intent = new Intent(getApplicationContext(), Score.class);
                intent.putExtra("message", namevalue);
                startActivity(intent);


            }

        });
*/






        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = register_name.getText().toString().trim();
                String email = email_register.getText().toString().trim();
                String password = pass_register.getText().toString().trim();
                String confirmPassword = register_confirmPass.getText().toString().trim();


                // checking if all feild are entered
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(Register.this,"Please Enter the Name",Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(Register.this,"Please Enter the Email",Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(Register.this,"Please Enter the Pass",Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextUtils.isEmpty(confirmPassword)){
                    Toast.makeText(Register.this,"Please Enter the text",Toast.LENGTH_LONG).show();
                    return;
                }

                if(password.length()<6){
                    Toast.makeText(Register.this,"Please Enter the text",Toast.LENGTH_LONG).show();

                }
                if(password.equals(confirmPassword)){
                    firebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        /*String namevalue = register_name.getText().toString();
                                       // Intent intent = new Intent(getApplicationContext(), Score.class);
                                        intent.putExtra("message", namevalue);
                                       // startActivity(intent);*/


                                        startActivity(new Intent(getApplicationContext(),Quiz.class));
                                        Toast.makeText(Register.this,"Registration compete",Toast.LENGTH_LONG);
                                    } else {
                                        Toast.makeText(Register.this,"Authentication erroe",Toast.LENGTH_LONG);

                                    }

                                    // ...
                                }
                            });
                }

                // till
            }
        });









    }
}
