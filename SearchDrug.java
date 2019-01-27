package com.avinash.findmydrug;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

/**
 * Created by AVINASH on 09-02-2018.
 */

public class SearchDrug extends AppCompatActivity {

    EditText medicineName;
    ListView listView;
    Button search;
    String s1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_drug);

        listView = (ListView) findViewById(R.id.listView);
        medicineName = (EditText) findViewById(R.id.medicineName);
        search = (Button) findViewById(R.id.search);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = medicineName.getText().toString().toLowerCase();
                if(s1.equals("")){
                    Toast.makeText(getApplicationContext(),"Enter medicine name",Toast.LENGTH_LONG).show();
                    return;
                }
                else {
                    String search_medicine_url = "http://192.168.225.145/search_drug.php";
                    getJSON(search_medicine_url,s1);
                }
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.logout_option,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                Toast.makeText(this, ""+item.toString(), Toast.LENGTH_SHORT).show();
                Intent i = new Intent(SearchDrug.this, UserLogin.class);
                startActivity(i);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(SearchDrug.this, UserLogin.class);
        startActivity(i);
    }

    private void getJSON(final String urlWebService, String medicine){
        class GetJSON extends AsyncTask<String,Void,String>{
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(String s) {
                //Toast.makeText(SearchDrug.this, ""+s, Toast.LENGTH_SHORT).show();
                try{
                    loadIntoListView(s);
                } catch(JSONException e){
                    e.printStackTrace();
                }
            }

            @Override
            protected String doInBackground(String... strings) {
                try{
                    String medicine_name = strings[0];
                    URL url = new URL(urlWebService);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                    String post_data = URLEncoder.encode("medicine_name","UTF-8")+"="+URLEncoder.encode(medicine_name,"UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    StringBuilder sb = new StringBuilder();
                    BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                    String json;
                    while ((json = br.readLine())!=null){
                        sb.append(json+"\n");
                    }
                    return sb.toString().trim();
                }catch(Exception e){
                    return null;
                }
            }
        }
        GetJSON getJSON = new GetJSON();
        getJSON.execute(medicine);
    }
    private void loadIntoListView(String json) throws JSONException{
        JSONArray jsonArray = new JSONArray(json);
        final String[] stores = new String[jsonArray.length()];
        String[] address = new String[jsonArray.length()];
        String[] phone = new String[jsonArray.length()];
        final String[] latitude = new String[jsonArray.length()];
        final String[] longitude = new String[jsonArray.length()];
        for(int i=0;i<jsonArray.length();i++){
            JSONObject obj = jsonArray.getJSONObject(i);
            stores[i] = obj.getString("shopname");
            address[i] = obj.getString("address");
            phone[i] = obj.getString("phone");
            latitude[i] = obj.getString("latitude");
            longitude[i] = obj.getString("longitude");
        }
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stores);
        MyListAdapter adapter = new MyListAdapter(this, stores, address, phone);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(SearchDrug.this, "Latitude: "+latitude[i]+"\nLongitude: "+longitude[i], Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SearchDrug.this, MapsActivity.class);
                intent.putExtra("latitude",latitude[i]);
                intent.putExtra("longitude",longitude[i]);
                intent.putExtra("storename",stores[i]);
                startActivity(intent);
            }
        });
    }
}
