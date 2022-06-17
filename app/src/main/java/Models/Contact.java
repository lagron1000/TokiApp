package Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @PrimaryKey @NonNull
    private String id;

    public Contact(@NonNull String id, String name, String server) {
        this.id = id;
        this.name = name;
        this.server = server;
    }

//    public Contact(@NonNull String id, String name) {
//        this.id = id;
//        this.name = name;
//    }

    private String name;
    public String server;
    public String last;
//    public Date lastdate;
//    public Message lastmsg;
//    public String myId;
//    public User savedMe;
//    public List<Message> messages;


    public @NonNull String getId() {
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


}
