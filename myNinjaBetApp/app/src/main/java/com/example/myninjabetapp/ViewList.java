package com.example.myninjabetapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ViewList extends AppCompatActivity {
    ListView listView;
    String view_url = "http://10.0.2.2/view.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewlist);
        listView = findViewById(R.id.v_listview);
        String type = "view";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this, listView);
        backgroundWorker.execute(type);

    }


}
