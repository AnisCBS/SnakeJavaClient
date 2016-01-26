package SDK;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Waseem on 18/01/16.
 */
public class User {

    /**
     * Declaration of local variables.
     */

    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private java.sql.Date created;
    private String status;
    private String email;
    private int type;

    private static ServerConnection serverConnection;

    /**
     * An ArrayList for all the users in the system.
     */

    public User() {

        serverConnection = new ServerConnection();

    }

    public static ArrayList<User> getUsers() {
        String jsonImport = serverConnection.get("users");
        ArrayList<User> users = new Gson().fromJson(jsonImport, new TypeToken<ArrayList<User>>() {
        }.getType());

        return users;

        /**
         * Getters and setters for all the variables for User.
         */
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public java.sql.Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

