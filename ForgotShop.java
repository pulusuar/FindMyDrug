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

public class ForgotShop extends AppCompatActivity {
    EditText username, birthPlace, favDish;
    String s1, s2, s3;
    Button submit;
    BackgroundWorker backgroundWorker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_shop);

        username = (EditText) findViewById(R.id.username);
        birthPlace = (EditText) findViewById(R.id.birthPlace);
        favDish = (EditText) findViewById(R.id.favouriteDish);

        submit = (Button) findViewById(R.id.submit);
        backgroundWorker = new BackgroundWorker(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = username.getText().toString().toLowerCase();
                s2 = birthPlace.getText().toString().toLowerCase();
                s3 = favDish.getText().toString().toLowerCase();

                if(s1.equals("") || s2.equals("") || s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fill all fields",Toast.LENGTH_LONG).show();
                    return;
                }

                else{
                    String type = "forgot_shop";
                    backgroundWorker.execute(type, s1, s2, s3);
                }
            }
        });
    }
}
