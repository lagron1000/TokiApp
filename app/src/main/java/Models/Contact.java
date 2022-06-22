package Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(primaryKeys = {"id","contactHolderId"})
public class Contact {
    @NonNull
    private String id;
    private String name;
    public String server;
    public String last;
    @NonNull
    public String contactHolderId = "";


//    public Date lastdate;

    public Contact(@NonNull String id, String name, String server, @NonNull String contactHolderId) {
        this.id = id;
        this.name = name;
        this.server = server;
        this.contactHolderId = contactHolderId;
    }

//    public Message lastmsg;
//    public String myId;
//    public List<Message> messages;

//    public Contact(@NonNull String id, String name, String server) {
//        this.id = id;
//        this.name = name;
//        this.server = server;
//    }

//    public Contact(@NonNull String id, String name) {
//        this.id = id;
//        this.name = name;
//    }

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

    public @NonNull String getContactHolderId() {
        return contactHolderId;
    }

    public void setContactHolderId(@NonNull String contactHolderId) {
        this.contactHolderId = contactHolderId;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
