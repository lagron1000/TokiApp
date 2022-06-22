package Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Message {
    @PrimaryKey
    public int Id;
    public String Content;
//    public DateTime Created;
    public Boolean Sent;
    public String SentBy;
    private String currentTime;

    public Message(@NonNull int id, String content, Boolean sent, String sentBy) {
        this.Id = id;
        this.Content = content;
        this.Sent = sent;
        this.SentBy = sentBy;
    }
}
