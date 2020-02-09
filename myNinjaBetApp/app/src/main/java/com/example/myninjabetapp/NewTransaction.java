package com.example.myninjabetapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class NewTransaction extends AppCompatActivity {
    ListView listView;
    Integer user1, user2, cash = 0;
    String str_user1, str_user2;
    Integer count_insertion = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_transaction);
        listView = findViewById(R.id.nt_listview);
        String type = "view";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this, listView);
        backgroundWorker.execute(type);
        // ListView on item selected listener.
        user1 = 1;
        user2 = 2;

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // String str = (String) parent.getItemAtPosition(position);
                if (count_insertion == 0) {
                    str_user1 = (String) parent.getItemAtPosition(position);
                    count_insertion++;
                } else {
                    str_user2 = (String) parent.getItemAtPosition(position);
                    count_insertion++;
                }
                // Toast.makeText(NewTransaction.this, count_insertion.toString(), Toast.LENGTH_SHORT).show();
                if (count_insertion == 2) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(NewTransaction.this);
                    alert.setTitle("CASH VALUE");
                    final EditText input = new EditText(NewTransaction.this);
                    input.setInputType(InputType.TYPE_CLASS_NUMBER);
                    input.setRawInputType(Configuration.KEYBOARD_12KEY);
                    alert.setView(input);
                    alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            cash = Integer.valueOf(input.getText().toString());
                            String typet = "new_tr";
                            BackgroundWorker backgroundWorker = new BackgroundWorker(NewTransaction.this);
                            backgroundWorker.execute(typet, user1.toString(), user2.toString(), cash.toString());
                        }
                    });
                    alert.show();

                    //
                    // Toast.makeText(NewTransaction.this, str_user1 + ' ' + str_user2 + ' ' + cash.toString(), Toast.LENGTH_LONG).show();
                }
                Toast.makeText(NewTransaction.this, str_user1 + ' ' + str_user2 + ' ' + cash.toString(), Toast.LENGTH_LONG).show();
            }

        });
        Toast.makeText(NewTransaction.this, str_user1 + ' ' + str_user2 + ' ' + cash.toString(), Toast.LENGTH_LONG).show();
    }

}
