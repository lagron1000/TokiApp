package com.example.toki;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.toki.api.UsersAPI;

import java.util.List;

import Models.ContactDao;
import Models.User;
import Models.UserDao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AppDB db;
    private ContactDao contactDao;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "TokiDB")
                .allowMainThreadQueries()
                .build();

        contactDao = db.contactDao();
        userDao = db.userDao();

        UsersAPI uApi = new UsersAPI();
        Callback<List<User>> callback = new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                System.out.println(response);
       //         userDao.insertUsers(response.body());
                System.out.println(userDao.index());

            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
            }
        };
        uApi.getUsers(callback);



    }
}