package com.example.toki.api;

import java.util.List;

import Models.Contact;
import Models.Message;
import Models.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface WebServiceAPI {

    @GET("users")
    Call<List<User>> getUsers();

    @POST("users")
    Call<Void> addUser(@Body User user);

    @GET("users/{id}")
    Call<Void> getUser(@Path("id") String id);

    @GET("contacts")
    Call<List<Contact>> getContacts(@Query("signedId") String signedId);

    @GET("contacts/{id}")
    Call<Contact> getContact(@Path("id") String id, @Query("signedId") String signedId);

    @POST("contacts")
    Call<Void> addContact(@Body Contact contact, @Query("signedId") String signedId);

    @GET("contacts/{id}/messages")
    Call<List<Message>> getMessages(@Path("id") String id, @Query("signedId") String signedId);

    @GET("contacts/{conId}/messages/{msgId}")
    Call<Message> getMessage(@Path("conId") String conId, @Path("msgId") int msgId,
                                   @Query("signedId") String signedId);

    @POST("contacts/{id}/messages")
    Call<Void> addMessage(@Path("id") String id, @Body Message msg,
                                   @Query("signedId") String signedId);

}
