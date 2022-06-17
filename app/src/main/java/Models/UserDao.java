package Models;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface UserDao {
    @Transaction
    @Query("SELECT * FROM user")
    List<UserWithContacts> index();

    @Query("SELECT * FROM user WHERE id = :id")
    UserWithContacts get(String id);

    @Insert
    void insertUser(UserWithContacts... user);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUsers(List<UserWithContacts> users);
}
