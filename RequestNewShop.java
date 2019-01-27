package com.avinash.findmydrug;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by AVINASH on 13-02-2018.
 */

public class RequestNewShop extends AppCompatActivity {

    Spinner home_delivery;
    EditText shopName, address, city, username, phone, birth_place, fav_dish;
    Button sendRequest;
    String s1, s2, s3, s4, s5, s6, s7, s8;
    BackgroundWorker backgroundWorker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.request_new_shop);

        shopName = (EditText) findViewById(R.id.shopName);
        address = (EditText) findViewById(R.id.address);
        city = (EditText) findViewById(R.id.city);
        username = (EditText) findViewById(R.id.username);
        phone = (EditText) findViewById(R.id.phone);
        birth_place = (EditText) findViewById(R.id.birthPlace);
        fav_dish = (EditText) findViewById(R.id.favouriteDish);
        home_delivery = (Spinner) findViewById(R.id.homeDelivery);
        sendRequest = (Button) findViewById(R.id.sendRequest);
        backgroundWorker = new BackgroundWorker(this);

        sendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = shopName.getText().toString();
                s2 = address.getText().toString();
                s3 = city.getText().toString();
                s4 = username.getText().toString().toLowerCase();
                s5 = phone.getText().toString();
                s6 = birth_place.getText().toString().toLowerCase();
                s7 = fav_dish.getText().toString().toLowerCase();
                s8 = home_delivery.getSelectedItem().toString();

                if(s1.equals("") || s2.equals("") || s3.equals("") || s4.equals("") || s5.equals("") || s6.equals("")){
                    Toast.makeText(RequestNewShop.this, "Fill all Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    String type = "request";
                    backgroundWorker.execute(type, s1, s2, s3, s4, s5, s6, s7, s8);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RequestNewShop.this, ShopLogin.class));
    }
}
