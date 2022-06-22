package com.example.toki;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import Models.Contact;
import Models.ContactDao;
import Models.Converter;
import Models.Message;
import Models.MessageDao;
import Models.User;
import Models.UserDao;

@Database(entities = {Contact.class, User.class, Message.class}, version = 1)
@TypeConverters({Converter.class})
public abstract class AppDB extends RoomDatabase{
    public abstract ContactDao contactDao();
    public abstract UserDao userDao();
    public abstract MessageDao messageDao();

}
