package Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {
    @PrimaryKey@NonNull
    private String id;
    private String name;
    private String password;
    private String server;

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

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
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

//    public String getServer() {
//        return server;
//    }

//    public void setServer(String server) {
//        this.server = server;
//    }

//    @Ignore
////    public User(@NonNull String id, String name, String password, String server) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
////        this.server = server;
//    }

    public User(@NonNull String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}

