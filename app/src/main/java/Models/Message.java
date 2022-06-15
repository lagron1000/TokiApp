package Models;

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
}
