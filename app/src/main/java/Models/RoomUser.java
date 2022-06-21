package Models;

public class RoomUser {
    private String id;
    private String name;
    private String password;
    private String server;

    public RoomUser(String id, String name, String password, String server) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.server = server;
    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

}
