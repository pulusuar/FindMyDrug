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

public class ChangePassword extends AppCompatActivity {

    EditText newPassword, conPwd, userName;
    String s1, s2, s3;
    String username = "";
    Button change;
    BackgroundWorker backgroundWorker;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_password);

        newPassword = (EditText) findViewById(R.id.password);
        conPwd = (EditText) findViewById(R.id.conpwd);
        userName = (EditText) findViewById(R.id.username);
        change = (Button) findViewById(R.id.changePassword);
        backgroundWorker = new BackgroundWorker(this);
        try {
            username = getIntent().getExtras().getString("username");
        } catch(NullPointerException e){
            e.printStackTrace();
        }
        userName.setText(username);
        userName.setEnabled(false);
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = newPassword.getText().toString();
                s2 = conPwd.getText().toString();
                s3 = userName.getText().toString();
                if(s1.equals("") || s2.equals("") || s3.equals("")){
                    Toast.makeText(ChangePassword.this, "Fill all fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(!(s1.equals(s2))){
                    Toast.makeText(ChangePassword.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (s1.length()<8){
                    Toast.makeText(ChangePassword.this, "Password should be minimum 8 characters", Toast.LENGTH_LONG).show();
                    return;
                }
                else{
                    String type = "change";
                    backgroundWorker.execute(type, s1, s3);
                }
            }
        });
    }
}
