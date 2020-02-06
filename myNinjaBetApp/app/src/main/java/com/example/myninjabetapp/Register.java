package com.example.myninjabetapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
    EditText name, surname, username, password;
    String str_name, str_surname, str_username, str_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.r_name);
        surname = findViewById(R.id.r_surname);
        username = findViewById(R.id.r_username);
        password = findViewById(R.id.r_password);
    }

    public void OnReg(View view) {
        str_name = name.getText().toString();
        str_surname = surname.getText().toString();
        str_username = username.getText().toString();
        str_password = password.getText().toString();
        String type = "register";
        BackgroundWorker backgroundWorker = new BackgroundWorker(this);
        backgroundWorker.execute(type, str_name, str_surname, str_username, str_password);
    }
}
