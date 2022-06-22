package Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Message {
    @PrimaryKey
    private int Id;
    private String Content;
//    public DateTime Created;
    private Boolean Sent;
    private String SentBy;
    private String CurrentTime;

    public Message(@NonNull String currentTime, String content, Boolean sent, String sentBy) {
        this.CurrentTime = currentTime;
        this.Content = content;
        this.Sent = sent;
        this.SentBy = sentBy;
    }

    public Boolean getSent() {
        return Sent;
    }

    public int getId() {
        return Id;
    }

    public String getContent() {
        return Content;
    }

    public String getCurrentTime() {
        return CurrentTime;
    }

    public String getSentBy() {
        return SentBy;
    }

    public void setContent(String content) {
        Content = content;
    }

    public void setCurrentTime(String currentTime) {
        CurrentTime = currentTime;
    }

    public void setSent(Boolean sent) {
        Sent = sent;
    }

    public void setSentBy(String sentBy) {
        SentBy = sentBy;
    }
}
