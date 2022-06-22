package com.example.toki.api;

import Models.Invitation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerComAPI {
    Retrofit retrofit;
    WebServiceAPI api;
    String server;

    public ServerComAPI(String _server) {
        server = _server;
        String url = "http://"+ server + "/api/";
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(WebServiceAPI.class);
    }

    public void sendInvite(String fromId, String toId, String fromServer) {
        Invitation inv = new Invitation(fromId, toId, fromServer);
        Call<Void> call = api.sendInvitation(inv);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                System.out.println(response);
            }
            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                System.out.println(t);
            }
        });
    }
}
