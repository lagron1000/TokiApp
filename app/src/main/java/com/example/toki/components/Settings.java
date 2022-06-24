package com.example.toki.components;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.toki.R;
import com.example.toki.dbSingleton;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        EditText serverET = findViewById(R.id.et_change_server);
        serverET.setText(dbSingleton.getServer());

        Button btn = findViewById(R.id.btn_change_server);
        btn.setOnClickListener(view -> {
            dbSingleton.setServer(serverET.getText().toString());
            finish();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

    }
}