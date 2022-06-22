package com.example.toki.api;

import com.example.toki.MyApplication;
import com.example.toki.R;

import java.util.List;

import Models.Contact;
import Models.Message;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactsAPI {
    Retrofit retrofit;
    WebServiceAPI api;

    public ContactsAPI() {
        String url = MyApplication.context.getString(R.string.base_url);
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(WebServiceAPI.class);
    }

    public void getContacts(String signedInId, Callback<List<Contact>> callback){
        Call<List<Contact>> call = api.getContacts(signedInId);
        call.enqueue(callback);
    }

    public void getContact(String id, String signedInId) {
        Call<Contact> call = api.getContact(id, signedInId);
        call.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {

            }
        });
    }

    public void addContact(Contact c, String signedInId) {
        Call<Void> call = api.addContact(c, signedInId);
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

    public void getMessages(String conId, String SignedId) {
        Call<List<Message>> call = api.getMessages(conId, SignedId);
        call.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(Call<List<Message>> call, Response<List<Message>> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<List<Message>> call, Throwable t) {

            }
        });
    }

    public void addMessage(String conId, Message msg, String signedId) {
        Call<Void> call = api.addMessage(conId,msg, signedId);
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

    public void getMessage(String conId, int msgId, String SignedId) {
        Call<Message> call = api.getMessage(conId, msgId, SignedId);
        call.enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<Message> call, Throwable t) {

            }
        });
    }
}
