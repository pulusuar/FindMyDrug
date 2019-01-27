package com.avinash.findmydrug;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by AVINASH on 22-03-2018.
 */

public class ForgotPassword extends AppCompatActivity {

    EditText birthPlace, favDish, username;
    Button submit;
    String s1, s2, s3;
    BackgroundWorker backgroundWorker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        birthPlace = (EditText) findViewById(R.id.birthPlace);
        favDish = (EditText) findViewById(R.id.favouriteDish);
        username = (EditText) findViewById(R.id.username);
        submit = (Button) findViewById(R.id.submit);

        backgroundWorker = new BackgroundWorker(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = birthPlace.getText().toString().toLowerCase();
                s2 = favDish.getText().toString().toLowerCase();
                s3 = username.getText().toString().toLowerCase();

                String type = "forgot";
                backgroundWorker.execute(type, s1, s2, s3);
            }
        });
    }
}
