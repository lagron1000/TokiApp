package Models;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import java.util.Date;

@Entity(primaryKeys = {"id","chatId", "created"})
public class Message {
    @NonNull
    private int id;
    @NonNull
    private String chatId;
    private String content;
    @NonNull
    public Date created;
    private Boolean sent;
    private String sentBy;
//    private String CurrentTime;


    public Message(@NonNull String chatId, String content, @NonNull Date created, Boolean sent, String sentBy) {
        this.id = 0;
        this.chatId = chatId;
        this.content = content;
        this.created = created;
        this.sent = sent;
        this.sentBy = sentBy;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean getSent() {
        return sent;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Date getCurrentTime() {
        return created;
    }

    public String getSentBy() {
        return sentBy;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCurrentTime(Date currentTime) {
        created = currentTime;
    }

    public void setSent(Boolean sent) {
        this.sent = sent;
    }

    public void setSentBy(String sentBy) {
        sentBy = sentBy;
    }
}
