package com.example.myninjabetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Transaction extends AppCompatActivity {
    ListView listView;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        listView = findViewById(R.id.t_listview);
        button = findViewById(R.id.t_btn);
        String type = "transaction";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this, listView);
        backgroundWorker.execute(type);
    }

    public void NewTrans(View view) {
        startActivity(new Intent(this, NewTransaction.class ) );
    }
}
