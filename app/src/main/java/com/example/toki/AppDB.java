package com.example.toki;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import Models.Contact;
import Models.ContactDao;

@Database(entities = {Contact.class}, version = 1)
public abstract class AppDB extends RoomDatabase{
    public abstract ContactDao contactDao();
}
