package com.example.toki.api;

import com.example.toki.MyApplication;
import com.example.toki.R;

import java.util.List;

import Models.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsersAPI {
    Retrofit retrofit;
    WebServiceAPI api;

    public UsersAPI() {
        String url = MyApplication.context.getString(R.string.base_url);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(WebServiceAPI.class);
    }
    public UsersAPI(String server) {
        String url = "http://"+ server + "/api/";
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(WebServiceAPI.class);
    }

    public void getUsers(Callback<List<User>> callback){
        Call<List<User>> call = api.getUsers();
        call.enqueue(callback);
    }

    public void addUser(User user) {
        Call<Void> call = api.addUser(user);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

            }
        });
    }

}
