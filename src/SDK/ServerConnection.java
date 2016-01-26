package SDK;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by Waseem on 18/01/16.
 */

/**
 * This class creates the connection to the server as well as the attributes that makes the server execute actions.
 */
public class ServerConnection {

    /**
     * Creates constructor.
     */

    public ServerConnection() {

        /**
         * Initialise variables from constructor.
         */

        this.hostAddress = "http://snake-server.herokuapp.com";
        this.port = 80;
    }

    /**
     * Declaration of local variables.
     */

    private String hostAddress;
    private int port;

    /**
     * Setters are created.
     */

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

    /**
     * Method is used to POST to the server.
     * Path is the directory to which we will POST to the server.
     */

    public String post(String json, String path) {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").post(ClientResponse.class, json);

        String output = response.getEntity(String.class);
        System.out.println(output);

        return output;
    }

     /**
     * Method is used to GET from the server.
     * path is the directory from which we want to GET something
     */

    public String get(String path) {

        Client client = Client.create();

        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").get(ClientResponse.class);

        String output = response.getEntity(String.class);
        System.out.println(output);
        return output;

    }

    /**
     * Method is used to DELETE something from the server.
     * path is the directory from which we want to DELETE something
     */

    public String delete( String path) {

        Client client = Client.create();
        System.out.println(getHostAddress() + ":" + getPort() + "/api/" + path);
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").delete(ClientResponse.class);

        return response.getEntity(String.class);
    }

    /**
     * Method is used to PUT / update to the server.
     * path is the directory from which we want to PUT / update something
     */

    public String put(String path, String json) {


        Client client = Client.create();
        System.out.println(getHostAddress() + ":" + getPort() + "/api/" + path);
        WebResource webResource = client.resource(getHostAddress() + ":" + getPort() + "/api/" + path);
        ClientResponse response = webResource.type("application/json").put(ClientResponse.class, json);

        String output = response.getEntity(String.class);

        return output;
    }


}

