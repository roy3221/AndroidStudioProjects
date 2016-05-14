package com.example.churong1.trailproject.APIs;

import android.util.Log;

import com.example.churong1.trailproject.model.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by churong1 on 5/3/16.
 */
public class API extends Thread {
    private String jsonResponse;
    public void run() {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("https://test.flaunt.peekabuy.com/api/look/create_looks_from_closet_with_anchors/");
        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
            nameValuePairs.add(new BasicNameValuePair("username",
                    "xi-liu1"));
            post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

            HttpResponse response = client.execute(post);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            jsonResponse = rd.readLine();
            if (jsonResponse != null) {
                Log.i("test",jsonResponse);
            }

//            JsonToObjects JsonToObjects = new JsonToObjects();
//            JsonToObjects.transfer(jsonResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getJsonResponse() {
        return this.jsonResponse;
    }

}
