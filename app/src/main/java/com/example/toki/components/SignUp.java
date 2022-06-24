package com.example.toki.components;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.toki.AppDB;
import com.example.toki.R;
import com.example.toki.api.UsersAPI;
import com.example.toki.dbSingleton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import Models.User;
import Models.UserDao;

public class SignUp extends AppCompatActivity {

    private AppDB db = dbSingleton.getDb();
    private UserDao userDao = dbSingleton.getUserDao();
    private UsersAPI uApi = dbSingleton.getuApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button btn = findViewById(R.id.sign_up_btn);


        btn.setOnClickListener(view-> {
            EditText etName = findViewById(R.id.sign_up_name);
            EditText etUser = findViewById(R.id.sign_up_user);
            EditText etPass1 = findViewById(R.id.sign_up_pass1);
            EditText etPass2 = findViewById(R.id.sign_up_pass2);

            String name = etName.getText().toString();
            String username = etUser.getText().toString();
            String pass1 = etPass1.getText().toString();
            String pass2 = etPass2.getText().toString();
            dbSingleton.refreshUsers();
            User u = userDao.get(username);
            if (u != null) {
                etUser.setError("Username taken.");
            }
            else if (!pass1.equals(pass2)) {
                etPass2.setError("Passwords don't match");
            }
            else {
                dbSingleton.addUser(new User(username, name, pass1));
                Intent i = new Intent(this, SignIn.class);
                startActivity(i);
                finish();
            }
        });
        FloatingActionButton settings = findViewById(R.id.btn_settings);
        settings.setOnClickListener(view -> {
            Intent i = new Intent(this, Settings.class);
            startActivity(i);
        });

    }

    public void onClick(View view) {
        Intent i = new Intent(this, SignIn.class);
        startActivity(i);
        finish();
    }
}