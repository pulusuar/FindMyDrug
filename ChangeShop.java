package com.avinash.findmydrug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by AVINASH on 22-03-2018.
 */

public class ChangeShop extends AppCompatActivity {
    EditText username, password, conpwd;
    Button change;
    String s1, s2, s3;
    String userName = "";
    BackgroundWorker backgroundWorker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_shop);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        conpwd = (EditText) findViewById(R.id.conpwd);
        change = (Button) findViewById(R.id.changePassword);
        backgroundWorker = new BackgroundWorker(this);

        try{
            userName = getIntent().getExtras().getString("username");
        }catch (NullPointerException e){
            e.printStackTrace();
        }
        username.setText(userName);
        username.setEnabled(false);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = password.getText().toString();
                s2 = conpwd.getText().toString();
                s3 = username.getText().toString();
                if(s1.equals("") || s2.equals("") || s3.equals("")){
                    Toast.makeText(ChangeShop.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(!(s1.equals(s2))){
                    Toast.makeText(ChangeShop.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(s1.length()<8){
                    Toast.makeText(ChangeShop.this, "Password length should be minimum 8 characters", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    String type = "change_shop";
                    backgroundWorker.execute(type, s1, s3);
                }
            }
        });
    }
}
