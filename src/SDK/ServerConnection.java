package SDK;

/**
 * Created by Waseem on 18/01/16.
 */
public class ServerConnection {

    public ServerConnection() {


        this.hostAddress = "http://localhost";
        this.port = 9876;
    }

    private String hostAddress;
    private int port;

    public void setHostAddress(String hostAddress) {
        this.hostAddress = hostAddress;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    public int getPort() {
        return port;
    }


    }

