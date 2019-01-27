package com.avinash.findmydrug;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by AVINASH on 09-02-2018.
 */

public class UserRegistration extends AppCompatActivity {

    EditText name, username, password, conpwd, phone, birth_Place, favDish;
    Button register;
    String s1, s2, s3, s4, s5, s6, s7;
    BackgroundWorker backgroundWorker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration);

        name = (EditText) findViewById(R.id.name);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        conpwd = (EditText) findViewById(R.id.conpwd);
        phone = (EditText) findViewById(R.id.phone);
        birth_Place = (EditText) findViewById(R.id.birthPlace);
        favDish = (EditText) findViewById(R.id.favDish);
        register = (Button) findViewById(R.id.register);
        backgroundWorker = new BackgroundWorker(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = name.getText().toString();
                s2 = username.getText().toString().toLowerCase();
                s3 = password.getText().toString();
                s4 = conpwd.getText().toString();
                s5 = phone.getText().toString();
                s6 = birth_Place.getText().toString().toLowerCase();
                s7 = favDish.getText().toString().toLowerCase();

                if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("") || s7.equals("")){
                    Toast.makeText(UserRegistration.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                else if(!s3.equals(s4)){
                    Toast.makeText(UserRegistration.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                    password.setText("");
                    conpwd.setText("");
                    return;
                }
                else if(s3.length()<8){
                    Toast.makeText(getApplicationContext(),"Password is too short", Toast.LENGTH_LONG).show();
                    password.setText("");
                    conpwd.setText("");
                    return;
                }
                else{
                    String type = "register";
                    backgroundWorker.execute(type, s1, s2, s3, s5, s6, s7);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(UserRegistration.this, UserLogin.class));
    }
}
