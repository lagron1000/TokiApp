package Models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MessageDao {

    @Query("SELECT * FROM message")
    List<Message> getAllMessagesFromAllChats();

    @Query("SELECT * FROM message WHERE chatId = :chatId")
    List<Message> getMessageFromChat(String chatId);


    @Query("SELECT * FROM message WHERE id = :id")
    Message getMessageById(String id);

    @Insert
    void insert(Message... messages);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMessages(List<Message> messages);

    @Update
    void update(Message... messages);

    @Delete
    void delete(Message... messages);
}
