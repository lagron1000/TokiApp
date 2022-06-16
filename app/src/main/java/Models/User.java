package Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity
public class User {

    @PrimaryKey@NonNull
    private String id;
    private String name;
    private String password;
    private String server;
    private List<Contact> contactList;

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public User(@NonNull String id, String name, String password, String server, List<Contact> contactList) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.server = server;
        this.contactList = contactList;
    }



}

