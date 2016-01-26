package LOGIC;


import GUI.*;
import SDK.*;
import com.google.gson.Gson;

import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Type;
import java.util.ArrayList;


/**
 * Created by Waseem on 19/01/16.
 */

/**
 * This class consists of all the logic. It controls GUI and the actions that are taken in the game.
 * This class includes actionListeners for every panel as well as their functionality.
 * It connects the GUI and SDK.
 */

public class Controller {

    /**
     * Declaration of local variables.
     */

    private Screen screen;
    private User currentUser;
    private ServerConnection serverConnection;

    /**
     * Creates a constructor.
     */

    public Controller() {
        screen = new Screen();
        screen.setVisible(true);
        currentUser = new User();
        serverConnection = new ServerConnection();

        /**
         * The method "public void run" is used to start the application from the Main.java class.
         */

    }
    public void run() {

        /**
         * Adds list of actionListeners from JPanels.
         */

        screen.getLogin().actionPerformedLogin(new LoginActionListener());
        screen.getMainmenu().addACList(new MainMenuActionListener());
        screen.getJoingame().actionPerformedJoinGame(new JoinGameActionListener());
        screen.getCreategame().actionPerformedCreateGame(new CreateGameActionListener());
        screen.getDeletegame().actionPerformedDeleteGame(new DeleteGameActionListener());

        /**
         * "Back" actionListeners.
         */

        screen.getJoingame().actionPerformedBack(new JoinGameActionListenerBack());
        screen.getCreategame().actionPerformedBack(new CreateGameActionListenerBack());
        screen.getDeletegame().actionPerformedBack(new DeleteGameActionListenerBack());

    }

    /**
     * Inner class "LoginActionListener" is used for the method Login.
     */

    private class LoginActionListener implements ActionListener {

        /**
         * The method verifies the user, when they click login.
         */

        public void actionPerformed(ActionEvent a) {

            /**
             * actCom checks whether or not the button "Login" was clicked..
             */

            String actCom = a.getActionCommand();
            if (actCom.equals("Login")) {

                /**
                 * Sets currentUsers username and password, as well as getting input from the fields "PlayerID" and "PasswordField".
                 */

                currentUser.setUsername(screen.getLogin().getPlayerID().getText());
                currentUser.setPassword(screen.getLogin().getPasswordfield().getText());

                /**
                 * Sends POST request to the servers API.
                 */

                String jsondata = serverConnection.post(new Gson().toJson(currentUser), "login");

                String message = parseMessage(jsondata);

                /**
                 * If player gets verified then he will continue to the "MAINMENU".
                 */

                if (message.equals("Login successful")) {
                    screen.getMainmenu().setUsers(User.getUsers());
                    screen.show(Screen.MAINMENU);
                    screen.getLogin().clearFields();

                    /**
                     * Prints respons from server.
                     */

                    screen.addStatusWindowMessage(message);

                }
                else {
                    screen.addStatusWindowMessage(message);
                }
            }
        }
    }

    /**
     * Inner class "MainMenuActionListener" is used for the method that shows the Mainmenu.
     */

    private class MainMenuActionListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            /**
             * The class makes sure that the user gets forwarded to the correct panel, when
             * a button is clicked.
             */

            String actCom = a.getActionCommand();

            if (actCom.equals("Join Game")) {
                screen.show(screen.JOINGAME);
            }

            else if (actCom.equals("Create Game")){
                screen.show(screen.CREATEGAME);
            }

            else if (actCom.equals("Delete Game")){
                screen.show(screen.DELETEGAME);
            }

            else if (actCom.equals("Highscores")){
                LoadHighScores();
            }

            else {
                screen.show(screen.LOGIN);
                currentUser = new User();
                screen.clearFields();
            }
        }
    }

    /**
     * Inner class "JoinGameActionListener" is used to join and start a game.
     */

    private class JoinGameActionListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            /**
             * Creates an existing game as well as opponent.
             */

            Game existingGame = new Game();
            Gamer opponent = new Gamer();

            /**
             * Sets opponent ID as well as controls.
             */

            opponent.setId(currentUser.getId());
            opponent.setControls(screen.getJoingame().getTextfield_gameControl().getText().trim());

            /**
             * Join an existing game and set opponent.
             */

            existingGame.setGameId(Integer.parseInt(screen.getJoingame().getTextField_gameId().getText().trim()));
            existingGame.setOpponent(opponent);

            /**
             * Sends JSON request to join a game.
             */

            String jsonGameData = serverConnection.put("games/join",new Gson().toJson(existingGame));

            /**
             * Prints response from server to status panel.
             */

            System.out.println(parseMessage(jsonGameData));
            screen.addStatusWindowMessage("Msg: " + parseMessage(jsonGameData));

            /**
             * Starts the game.
             */

            String jsondata = serverConnection.put("games/start",new Gson().toJson(existingGame));

            /**
             * Prints response from server to status panel.
             */

            System.out.println(jsondata);
            screen.addStatusWindowMessage("Msg: " + jsondata);
            screen.getJoingame().clearFields();
        }
    }

    /**
     * Inner class "CreateGameActionListener" is used to join and create a game.
     */
    private class CreateGameActionListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            /**
             * Creates a new game as well as host.
             */

            Game newGame = new Game();
            Gamer host = new Gamer();

            /**
             * Sets host players actions.
             */

            host.setId(currentUser.getId());
            host.setControls(screen.getCreategame().getTextField_gameControl().getText().trim());

            /**
             * Sets values for the game.
             */

            newGame.setMapSize(300);
            newGame.setHost(host);
            newGame.setName(screen.getCreategame().getTextField_gameName().getText().trim());

            /**
             * Sends JSON request to create game.
             */

            String jsonGameData = serverConnection.post(new Gson().toJson(newGame),"games");

            /**
             * Prints response from server to status panel.
             */

            System.out.println(parseMessage(jsonGameData));
            screen.addStatusWindowMessage("Msg: " + parseMessage(jsonGameData));
            screen.getCreategame().clearFields();
        }
    }

    /**
     * Inner class "DeleteGameActionListener" is used to delete a game.
     */

    private class DeleteGameActionListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            /**
             * Creates a new game to delete.
             */

            Game gameId = new Game();
            Game deleteGame = new Game();

            /**
             * gets and sets game ID.
             */

            deleteGame.getGameId();

            deleteGame.setGameId(Integer.parseInt(screen.getDeletegame().getTextField().getText().trim()));

            /**
             * Sends JSON request to delete game.
             */

            String jsonGameData = serverConnection.delete("games/"+gameId);

            /**
             * Prints response from server to status panel.
             */

            screen.addStatusWindowMessage("Spillet er nu slettet: " + parseMessage(jsonGameData));
            screen.getDeletegame().clearFields();
        }
    }

    /**
     * Declaration of method.
     */

    private void LoadHighScores(){

        /**
         * Set data to scores, so we can get highscore.
         */

        String jsondata = serverConnection.get("scores");

        /**
         * Using the Typetoken ArrayList af the type "Score" to make sure that the string responds from the server.
         */

        Type listeType = new TypeToken<ArrayList<Score>>(){}.getType();
        ArrayList<Score> highscores = new Gson().fromJson(jsondata, listeType);

        /**
         * Adds header and prints highscores.
         */

        screen.addStatusWindowMessage("\nPlayer Id: \tPlayer name: \tScore: \tGame id:");
        for(int i=0;i<highscores.size();i++){
            Score score = highscores.get(i);
            screen.addStatusWindowMessage(score.getUser().getId() +"\t" + score.getUser().getFirstName() +"\t" + score.getScore()  +"\t" + score.getGame().getGameId());

        }

    }

    /**
     * All back button ActionListeners.
     */

    private class JoinGameActionListenerBack implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            screen.show(Screen.MAINMENU);
        }
    }

    private class CreateGameActionListenerBack implements ActionListener {

        public void actionPerformed(ActionEvent a) {screen.show(Screen.MAINMENU);}
    }

    private class DeleteGameActionListenerBack implements ActionListener {

        public void actionPerformed(ActionEvent a) {
            screen.show(Screen.MAINMENU);
        }
    }

    private class HighscoresActionListenerBack implements ActionListener {

        public void actionPerformed(ActionEvent a) {screen.show(Screen.MAINMENU);
        }
    }

    /**
     * A parse method used to receive messages in JSON from the server.
     */

    public String parseMessage(String messageToParse) {

        /**
         * Creates a new JSONParser method.
         */

        JSONParser parseJsonMessage = new JSONParser();

        /**
         * Creates a try catch method.
         */

        try {
            Object object = parseJsonMessage.parse(messageToParse);
            JSONObject jsonobject = (JSONObject) object;

            messageToParse = (String) jsonobject.get("message");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        /**
         * Returns the message.
         */

        return messageToParse;
    }
}