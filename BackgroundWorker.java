package com.avinash.findmydrug;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by AVINASH on 02-03-2018.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    Context context;
    AlertDialog alertDialog;
    String s1;

    BackgroundWorker(Context ctx){
        context = ctx;
    }

    @Override
    protected String doInBackground(String... strings) {
        String type = strings[0];
        String register_url = "http://192.168.225.145/register.php";
        String login_url = "http://192.168.225.145/user_login.php";
        String shop_login_url = "http://192.168.225.145/store_login.php";
        String add_medicine_url = "http://192.168.225.145/add_medicine.php";
        String remove_medicine_url = "http://192.168.225.145/remove_medicine.php";
        String forgot_password_url = "http://192.168.225.145/forgot.php";
        String change_password_url = "http://192.168.225.145/change_password.php";
        String forgot_shop_url = "http://192.168.225.145/forgot_shop.php";
        String change_shop_url = "http://192.168.225.145/change_shop.php";
        String request_shop_url = "http://192.168.225.145/request_shop.php";
        if(type.equals("register")){
            try {
                String name = strings[1];
                String username = strings[2];
                String password = strings[3];
                String phone = strings[4];
                String birthPlace = strings[5];
                String favDish = strings[6];
                URL url = new URL(register_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8")+"&"
                + URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                + URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                + URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"
                + URLEncoder.encode("birthPlace","UTF-8")+"="+URLEncoder.encode(birthPlace,"UTF-8")+"&"
                + URLEncoder.encode("favDish","UTF-8")+"="+URLEncoder.encode(favDish,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("request")){
            try {
                String shopname = strings[1];
                String address = strings[2];
                String city = strings[3];
                String username = strings[4];
                String phone = strings[5];
                String birthPlace = strings[6];
                String favDish = strings[7];
                String homeDelivery = strings[8];
                URL url = new URL(request_shop_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("shopname","UTF-8")+"="+URLEncoder.encode(shopname,"UTF-8")+"&"
                        + URLEncoder.encode("address","UTF-8")+"="+URLEncoder.encode(address,"UTF-8")+"&"
                        + URLEncoder.encode("city","UTF-8")+"="+URLEncoder.encode(city,"UTF-8")+"&"
                        + URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        + URLEncoder.encode("phone","UTF-8")+"="+URLEncoder.encode(phone,"UTF-8")+"&"
                        + URLEncoder.encode("birthPlace","UTF-8")+"="+URLEncoder.encode(birthPlace,"UTF-8")+"&"
                        + URLEncoder.encode("favDish","UTF-8")+"="+URLEncoder.encode(favDish,"UTF-8")+"&"
                        + URLEncoder.encode("homeDelivery","UTF-8")+"="+URLEncoder.encode(homeDelivery,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("userLogin")){
            try {
                String username = strings[1];
                String password = strings[2];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        + URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("forgot")){
            try {
                String birthPlace = strings[1];
                String favDish = strings[2];
                String username = strings[3];
                s1 = username;
                URL url = new URL(forgot_password_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data =URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        + URLEncoder.encode("birthPlace","UTF-8")+"="+URLEncoder.encode(birthPlace,"UTF-8")+"&"
                        + URLEncoder.encode("favDish","UTF-8")+"="+URLEncoder.encode(favDish,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("forgot_shop")){
            try {
                String username = strings[1];
                String birthPlace = strings[2];
                String favDish = strings[3];
                s1 = username;
                URL url = new URL(forgot_shop_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data =URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        + URLEncoder.encode("birthPlace","UTF-8")+"="+URLEncoder.encode(birthPlace,"UTF-8")+"&"
                        + URLEncoder.encode("favDish","UTF-8")+"="+URLEncoder.encode(favDish,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("shopLogin")){
            try {
                String username = strings[1];
                String password = strings[2];
                String regId = strings[3];
                URL url = new URL(shop_login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8")+"&"
                        + URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                        + URLEncoder.encode("regId","UTF-8")+"="+URLEncoder.encode(regId,"UTF-8");
                s1 = username;
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("add_medicine")){
            try {
                String medicine_name = strings[1];
                String shop_username = strings[2];
                s1 = shop_username;
                URL url = new URL(add_medicine_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("medicineName","UTF-8")+"="+URLEncoder.encode(medicine_name,"UTF-8")+"&"
                        + URLEncoder.encode("shopUsername","UTF-8")+"="+URLEncoder.encode(shop_username,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("change")){
            try {
                String password = strings[1];
                String username = strings[2];
                s1 = username;
                URL url = new URL(change_password_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                        + URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("change_shop")){
            try {
                String password = strings[1];
                String username = strings[2];
                s1 = username;
                URL url = new URL(change_shop_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("password","UTF-8")+"="+URLEncoder.encode(password,"UTF-8")+"&"
                        + URLEncoder.encode("username","UTF-8")+"="+URLEncoder.encode(username,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("remove_medicine")){
            try {
                String medicine_name = strings[1];
                String shop_username = strings[2];
                s1 = shop_username;
                URL url = new URL(remove_medicine_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("medicine_name","UTF-8")+"="+URLEncoder.encode(medicine_name,"UTF-8")+"&"
                        + URLEncoder.encode("shop_username","UTF-8")+"="+URLEncoder.encode(shop_username,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }

    @Override
    protected void onPostExecute(String s) {
        alertDialog.setMessage(s);
        alertDialog.show();
        if(s.equals("Login success!!")) {
            context.startActivity(new Intent(context, SearchDrug.class));
        }
        else if(s.equals("Login failure!! Try again :)")){
            context.startActivity(new Intent(context, UserLogin.class));
        }
        else if(s.equals("Registration Success!!")){
            context.startActivity(new Intent(context, UserLogin.class));
        }
        else if(s.equals("Username already exists!!") || s.equals("Failed to register")){
            context.startActivity(new Intent(context, UserRegistration.class));
        }
        else if(s.equals("Store Logged in!!")){
            context.startActivity(new Intent(context, UpdateStore.class).putExtra("username", s1));
        }
        else if(s.equals("Store Login failure!! Try again :)")){
            context.startActivity(new Intent(context, ShopLogin.class));
        }
        else if(s.equals("Medicine Data Updated!!") || s.equals("New medicine added") || s.equals("Failed to add medicine!!")) {
            context.startActivity(new Intent(context, UpdateStore.class).putExtra("username", s1));
        }
        else if(s.equals("Medicine Data Updated!!") || s.equals("Failed to remove medicine!!") || s.equals("medicine unavailable!!")) {
            context.startActivity(new Intent(context, UpdateStore.class).putExtra("username", s1));
        }
        else if(s.equals("Success")){
            context.startActivity(new Intent(context, ChangePassword.class).putExtra("username", s1));
        }
        else if(s.equals("Failed")){
            context.startActivity(new Intent(context, ForgotPassword.class));
        }
        else if(s.equals("Changed Successfully!")){
            context.startActivity(new Intent(context, UserLogin.class));
        }
        else if (s.equals("Failure")){
            context.startActivity(new Intent(context, ChangePassword.class).putExtra("username", s1));
        }
        else if(s.equals("Successful")){
            context.startActivity(new Intent(context, ChangeShop.class).putExtra("username", s1));
        }
        else if(s.equals("Failed to change")){
            context.startActivity(new Intent(context, ForgotShop.class));
        }
        else if(s.equals("Password Changed Successfully!")){
            context.startActivity(new Intent(context, ShopLogin.class));
        }
        else if(s.equals("Password Failure")){
            context.startActivity(new Intent(context, ChangeShop.class).putExtra("username", s1));
        }
        else if(s.equals("Requested Successfully!!")){
            context.startActivity(new Intent(context, ShopLogin.class));
        }
        else if (s.equals("Username already exists!!!") || s.equals("Failed to request!")){
            context.startActivity(new Intent(context, RequestNewShop.class));
        }
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
