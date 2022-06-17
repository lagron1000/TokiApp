package Models;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class UserWithContacts {
    @Embedded private User user;
    @Relation(
            parentColumn = "id",
            entityColumn = "id"
    )
    private List<Contact> contactList;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(List<Contact> contactList) {
        this.contactList = contactList;
    }


}
