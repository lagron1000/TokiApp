package com.example.toki;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        EditText serverET = findViewById(R.id.et_server_search);
        serverET.setText(dbSingleton.getServer());

        Button btn = findViewById(R.id.btn_change_server);
        btn.setOnClickListener(view -> {
            dbSingleton.setServer(serverET.getText().toString());
        });
    }
}