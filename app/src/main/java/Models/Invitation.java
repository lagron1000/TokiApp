package Models;

public class Invitation {
    public String from;
    public String to;
    public String server;

    public Invitation(String from, String to, String server) {
        this.from = from;
        this.to = to;
        this.server = server;
    }
}
