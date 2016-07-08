package com.kodekallas.myapplication;

import java.util.HashMap;
import java.util.Map;

import android.os.AsyncTask;
import android.widget.Toast;

import java.io.InputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.commons.io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URLEncoder;
/**
 * Created by sravisankaran on 6/16/16.
 */
public class CallAPI extends AsyncTask<String, String, String> {

    public CallAPI() {
        //set context variables if required
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String  doInBackground(String... params) {

        URL url;

        String response = "";
        try {
            url = new URL(params[0] );
            String postData =  params[1];
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(15000);
            conn.setConnectTimeout(15000);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setRequestMethod("POST");
            conn.setDoInput(true);
            conn.setDoOutput(true);

            HashMap<String, String> postDataParams=new HashMap<String, String>();
            postDataParams.put("card","5196");
            postDataParams.put("name","chadda");
            /*
            JSONObject Json = new JSONObject();

            try {
                Json.put("card", params[2]);
                Json.put("cvv", params[3]);
                Json.put("mmyy", params[4]);
                Json.put("fname", params[5]);
                Json.put("lname", params[6]);
            } catch (JSONException e) {
                e.printStackTrace();
            } */

            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(params[1]);

            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
            else {
                response="";

            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return response;
    }



    @Override
    protected void onPostExecute(String result) {
        //Update the UI
    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException{
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }



}