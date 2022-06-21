package Models;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactDao {

    @Query("SELECT * FROM contact WHERE savedMe = :savedMe")
    List<Contact> index(String savedMe);

    @Query("SELECT * FROM contact WHERE id = :id AND savedMe = :savedMe")
    Contact get(String id, String savedMe);

    @Insert
    void insert(Contact... contacts);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertContacts(List<Contact> contacts);

    @Update
    void update(Contact... contacts);

    @Delete
    void delete(Contact... contacts);
}
