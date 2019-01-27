package com.avinash.findmydrug;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import org.w3c.dom.Text;

/**
 * Created by AVINASH on 11-02-2018.
 */

public class UpdateStore extends AppCompatActivity {

    EditText medicineName, storeUserName;
    Button addMedicine, removeMedicine;
    String s1, s2;
    String username = "";
    BackgroundWorker backgroundWorker;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_store);

        medicineName = (EditText) findViewById(R.id.medicineName);
        storeUserName = (EditText) findViewById(R.id.store_username);
        addMedicine = (Button) findViewById(R.id.addMedicine);
        removeMedicine = (Button) findViewById(R.id.removeMedicine);
        backgroundWorker = new BackgroundWorker(this);

        try {
            username = getIntent().getExtras().getString("username");
        } catch(NullPointerException e){
            e.printStackTrace();
        }
        storeUserName.setText(username);
        storeUserName.setEnabled(false);
        addMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s2 = medicineName.getText().toString().toLowerCase();
                s1 = storeUserName.getText().toString().toLowerCase();
                if(s2.equals("")){
                    Toast.makeText(UpdateStore.this, "Enter medicine name!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    String type = "add_medicine";
                    backgroundWorker.execute(type, s2, s1);
                }
            }
        });

        removeMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s2 = medicineName.getText().toString().toLowerCase();
                s1 = storeUserName.getText().toString().toLowerCase();
                if(s2.equals("")){
                    Toast.makeText(UpdateStore.this, "Enter medicine name!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    String type = "remove_medicine";
                    backgroundWorker.execute(type, s2, s1);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.notifications:
                Toast.makeText(this, ""+item.toString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(UpdateStore.this, Notifications.class);
                startActivity(i);
                break;
            case R.id.logout:
                Toast.makeText(this, ""+item.toString(),Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(UpdateStore.this, ShopLogin.class);
                startActivity(i1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(UpdateStore.this, ShopLogin.class));
    }
}
