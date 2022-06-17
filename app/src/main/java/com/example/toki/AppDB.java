package com.example.toki;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import Models.Contact;
import Models.ContactDao;
import Models.User;
import Models.UserDao;

@Database(entities = {Contact.class, User.class}, version = 1)
public abstract class AppDB extends RoomDatabase{
    public abstract ContactDao contactDao();
    public abstract UserDao userDao();

}
