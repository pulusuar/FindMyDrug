package com.avinash.findmydrug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by AVINASH on 11-02-2018.
 */

public class ShopLogin extends AppCompatActivity {

    EditText username, password;
    Button storeLogin, newShop, forgot;
    String s1, s2;
    String regId = "";
    BackgroundWorker backgroundWorker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_login);
        username = (EditText) findViewById(R.id.shopname);
        password = (EditText) findViewById(R.id.password);
        storeLogin = (Button) findViewById(R.id.storeLogin);
        newShop = (Button) findViewById(R.id.newShop);
        forgot = (Button) findViewById(R.id.forgot);
        backgroundWorker = new BackgroundWorker(this);

        storeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = username.getText().toString().toLowerCase();
                s2 = password.getText().toString();

                if(s1.equals("") || s2.equals("")){
                    Toast.makeText(ShopLogin.this, "Enter Username and Password!!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                   try {
                        regId =GCMRegistrationIntentService.token;
                    } catch(NullPointerException e){
                        e.printStackTrace();
                    }
                    String type = "shopLogin";
                    if (regId!=null) {
                        backgroundWorker.execute(type, s1, s2, regId);
                    }else
                    {
                        Toast.makeText(ShopLogin.this,"Unable to fectch device ID",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        newShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i;
                i = new Intent(ShopLogin.this, RequestNewShop.class);
                startActivity(i);
            }
        });
        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ShopLogin.this, ForgotShop.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(ShopLogin.this, MainActivity.class));
    }
}
