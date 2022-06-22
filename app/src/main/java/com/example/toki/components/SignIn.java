package com.example.toki.components;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.toki.AppDB;
import com.example.toki.R;
import com.example.toki.dbSingleton;

import java.util.List;

import Models.User;
import Models.UserDao;

public class SignIn extends AppCompatActivity {

    private AppDB db;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        db = dbSingleton.getDb();
        userDao = dbSingleton.getUserDao();

        Button btn = findViewById(R.id.sign_in);
        btn.setOnClickListener(view -> {
            EditText etUsr = findViewById(R.id.sign_in_usr);
            EditText etPass= findViewById(R.id.sign_in_pass);

            String username = etUsr.getText().toString();
            String password = etPass.getText().toString();
            List<User> test = userDao.index();
            User u = userDao.get(username);
            if (u == null) btn.setError("Try again");
            else if (!u.getPassword().equals(password)) btn.setError("Try again");
            else {
                dbSingleton.setSignedIn(u);
                dbSingleton.updateContactList();
                Intent i = new Intent(this, Contacts.class);
                startActivity(i);
                finish();
            }
        });
    }


    public void onClick(View view) {
        Intent i = new Intent(this, SignUp.class);
        startActivity(i);
        finish();
    }

}