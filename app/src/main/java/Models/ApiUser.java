package Models;

import java.util.List;

public class ApiUser {
    private String id;
    private String name;
    private String password;
    private String server;
    public List<Contact> ContactList;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
        return ContactList;
    }

    public void setContactList(List<Contact> contactList) {
        ContactList = contactList;
    }
}
