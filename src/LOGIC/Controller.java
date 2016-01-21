package LOGIC;


import GUI.*;
import SDK.ServerConnection;
import SDK.User;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Waseem on 19/01/16.
 */
public class Controller {

    private Screen screen;
    private User currentUser;
    private ServerConnection serverConnection;


    public Controller() {
        screen = new Screen();
        screen.setVisible(true);
        currentUser = new User();
        serverConnection = new ServerConnection();
    }

    public void run() {
        //Adding list of actionListners

        screen.getLogin().actionPerformedLogin(new LoginActionListener());
        screen.getMainmenu().addACList(new MainMenuActionListener());
    }

    private class LoginActionListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            String actCom = a.getActionCommand();
            if (actCom.equals("Login")) {

                currentUser.setUsername(screen.getLogin().getPlayerID().getText());
                currentUser.setPassword(screen.getLogin().getPasswordfield().getText());

                String jsondata = serverConnection.post(new Gson().toJson(currentUser), "login");

                String message = parseMessage(jsondata);

                if (message.equals("Login successful")) {
                    screen.getMainmenu().setUsers(User.getUsers());
                    screen.show(Screen.MAINMENU);
                    screen.getLogin().clearFields();


                    screen.addStatusWindowMessage(message);

                } else {
                    screen.addStatusWindowMessage(message);
                }
            }
        }

        private class MainMenuActionListener implements ActionListener {

            public void actionPerformed(ActionEvent a) {


                String actCom = a.getActionCommand();

                if (actCom.equals("Join Game")) {
                    screen.show(screen.JOINGAME);
                } else if (actCom.equals("Create Game")) {
                    screen.show(screen.CREATEGAME);
                } else if (actCom.equals("Delete Game")) {
                    screen.show(screen.DELETEGAME);
                }

                // else if (actCom.equals("Load Highscores")){
                //   HighScores();
                // }

                else {
                    screen.show(screen.LOGIN);
                    currentUser = new User();
                    screen.clearFields();
                }
            }

            public String parseMessage(String messageToParse) {


                JSONParser parseJsonMessage = new JSONParser();

                try {
                    Object object = parseJsonMessage.parse(messageToParse);
                    JSONObject jsonobject = (JSONObject) object;

                    messageToParse = (String) jsonobject.get("message");

                } catch (ParseException e) {
                    e.printStackTrace();
                }

                return messageToParse;

            }

        }
    }
}

