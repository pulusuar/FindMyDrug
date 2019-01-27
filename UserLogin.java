package com.avinash.findmydrug;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AVINASH on 09-02-2018.
 */

public class UserLogin extends AppCompatActivity {

    EditText username, password;
    Button login, newUser;
    BackgroundWorker backgroundWorker;
    String s1,s2;
    Button forgot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        forgot = (Button) findViewById(R.id.forgot);
        login = (Button) findViewById(R.id.user);
        newUser = (Button) findViewById(R.id.newUser);
        backgroundWorker = new BackgroundWorker(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = username.getText().toString().toLowerCase();
                s2 = password.getText().toString();
                if(s1.equals("") || s2.equals("")){
                    Toast.makeText(UserLogin.this, "Enter username and password!!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    String type = "userLogin";
                    backgroundWorker.execute(type, s1, s2);
                }
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(UserLogin.this, UserRegistration.class);
                startActivity(i);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UserLogin.this, ForgotPassword.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(UserLogin.this, MainActivity.class));
    }
}
