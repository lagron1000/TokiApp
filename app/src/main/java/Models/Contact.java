package Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @PrimaryKey @NonNull
    private String id;
    private String name;
    public String Server;
    public String last;
//    public DateTime lastdate;
//    public Message lastmsg;
    public String myId;
    public User SavedMe;
//    public List<Message> Messages


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

    public Contact(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
