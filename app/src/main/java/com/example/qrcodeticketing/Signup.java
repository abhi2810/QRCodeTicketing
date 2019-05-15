package com.example.qrcodeticketing;

import android.os.AsyncTask;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

import static com.example.qrcodeticketing.util.HttpGetRequest.CONNECTION_TIMEOUT;
import static com.example.qrcodeticketing.util.HttpGetRequest.READ_TIMEOUT;
import static com.example.qrcodeticketing.util.HttpGetRequest.REQUEST_METHOD;

public class Signup extends AppCompatActivity {

    TextInputEditText ed1,ed2,ed3,ed4;
    String name,email,pass,cnfpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ed1=(TextInputEditText)findViewById(R.id.sname);
        ed2=(TextInputEditText)findViewById(R.id.semail);
        ed3=(TextInputEditText)findViewById(R.id.spassword);
        ed4=(TextInputEditText)findViewById(R.id.scnfpassword);

    }
    public void register(View v) throws ExecutionException, InterruptedException {
        name=ed1.getText().toString();
        email=ed2.getText().toString();
        pass=ed3.getText().toString();
        cnfpass=ed4.getText().toString();
        if(pass.equals(cnfpass)){
            new AsyncTask<Void,Void,Void>(){
                String result="";
                String inputLine;
                @Override
                protected Void doInBackground(Void... voids) {
                    try {
                        URL myUrl = new URL("http://localhost:8080/QRCode?user=1&create=1&name=" + URLEncoder.encode(name) + "&email=" + URLEncoder.encode(email) + "&password=" + URLEncoder.encode(pass));
                        //Create a connection
                        Log.d("url","http://localhost:8080/QRCode?user=1&create=1&name=" + URLEncoder.encode(name) + "&email=" + URLEncoder.encode(email) + "&password=" + URLEncoder.encode(pass));
                        HttpURLConnection connection = (HttpURLConnection)
                                myUrl.openConnection();
                        //Set methods and timeouts
                        connection.setRequestMethod(REQUEST_METHOD);
                        connection.setReadTimeout(READ_TIMEOUT);
                        connection.setConnectTimeout(CONNECTION_TIMEOUT);

                        //Connect to our url
                        connection.connect();
                        //Create a new InputStreamReader
                        InputStreamReader streamReader = new
                                InputStreamReader(connection.getInputStream());
                        //Create a new buffered reader and String Builder
                        BufferedReader reader = new BufferedReader(streamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        //Check if the line we are reading is not null
                        while ((inputLine = reader.readLine()) != null) {
                            stringBuilder.append(inputLine);
                        }
                        //Close our InputStream and Buffered reader
                        reader.close();
                        streamReader.close();
                        //Set our result equal to our stringBuilder
                        result = stringBuilder.toString();

                        Log.d("result",result);
                        Toast.makeText(Signup.this, ""+result, Toast.LENGTH_SHORT).show();
                        finish();
                    } catch (ProtocolException e) {
                        e.printStackTrace();
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
            }.execute();
        }else{
            Toast.makeText(this, "Passwords don't match.", Toast.LENGTH_SHORT).show();
        }
    }
}
