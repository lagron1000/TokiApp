package com.example.toki;

import androidx.room.Room;

import com.example.toki.api.ContactsAPI;
import com.example.toki.api.ServerComAPI;
import com.example.toki.api.UsersAPI;

import java.util.List;

import Models.Contact;
import Models.ContactDao;
import Models.User;
import Models.UserDao;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class dbSingleton {

    private static AppDB db = Room.databaseBuilder(MyApplication.context,
                    AppDB.class, "TokiDB")
            .allowMainThreadQueries()
            .build();
    private static ContactDao contactDao = db.contactDao();
    private static UserDao userDao = db.userDao();
    private static UsersAPI uApi = new UsersAPI();
    private static ContactsAPI cApi = new ContactsAPI();
    private static User signedIn;
    private static String server = "10.0.2.2:5143";

    public static String getServer() {
        return server;
    }

    public static void setServer(String server) {
        dbSingleton.server = server;
    }

    public static UsersAPI getuApi() {
        return uApi;
    }

    public static ContactsAPI getcApi() {
        return cApi;
    }

    public static User getSignedIn() {
        return signedIn;
    }

    public static void setSignedIn(User signedIn) {
        dbSingleton.signedIn = signedIn;
    }

    public static AppDB getDb() {
        return db;
    }

    public static ContactDao getContactDao() {
        return contactDao;
    }

    public static UserDao getUserDao() {
        return userDao;
    }

    public static void refreshUsers() {

        Callback<List<User>> callback = new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                System.out.println(response);
                userDao.insertUsers(response.body());
                System.out.println(userDao.index().toString());

            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
            }
        };

        uApi.getUsers(callback);
    }

    public static void updateContactList(){
        Callback<List<Contact>> callback = new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                List<Contact> cons = response.body();
                contactDao.insertContacts(cons);
                List<Contact> consTest = contactDao.index(dbSingleton.getSignedIn().getId());
            }
            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
            }
        };

        cApi.getContacts(signedIn.getId(), callback);
    }

    public static void addUser(User u) {
        new Thread(() -> {
            userDao.insertUser(u);
        }).start();
        new Thread(() -> {
            uApi.addUser(u);
        }).start();
    }
    private static void sendInvite(String fromId, String toId, String server) {
        ServerComAPI scAPI = new ServerComAPI(server);
        String myServer = MyApplication.context.getString(R.string.my_server);
        scAPI.sendInvite(fromId, toId, myServer);
    }

    public static void addContact(Contact c) {
        new Thread(() -> {
            cApi.addContact(c, signedIn.getId());
            sendInvite(c.getContactHolderId(), c.getId(), c.getServer());
        }).start();
        new Thread(() -> {
            contactDao.insert(c);
            System.out.println(contactDao.index(signedIn.getId()));
        }).start();
    }



}
