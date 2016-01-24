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

        screen.getLogin().actionPerformedLogin(new LoginActionListener());
        screen.getMainmenu().addACList(new MainMenuActionListener());
        screen.getJoingame().actionPerformedJoinGame(new JoinGameActionListener());
        screen.getCreategame().actionPerformedCreateGame(new CreateGameActionListener());
        screen.getDeletegame().actionPerformedDeleteGame(new DeleteGameActionListener());

        screen.getJoingame().actionPerformedBack(new JoinGameActionListenerBack());
        screen.getCreategame().actionPerformedBack(new CreateGameActionListenerBack());
        screen.getDeletegame().actionPerformedBack(new DeleteGameActionListenerBack());

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

                }
                else {
                    screen.addStatusWindowMessage(message);
                }
            }
        }
    }

    private class MainMenuActionListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {

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

    private class JoinGameActionListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            Game existingGame = new Game();
            Gamer opponent = new Gamer();

            opponent.setId(currentUser.getId());
            opponent.setControls(screen.getJoingame().getTextfield_gameControl().getText().trim());

            existingGame.setGameId(Integer.parseInt(screen.getJoingame().getTextField_gameId().getText().trim()));
            existingGame.setOpponent(opponent);

            String jsonGameData = serverConnection.put("games/join",new Gson().toJson(existingGame));

            System.out.println(parseMessage(jsonGameData));
            screen.addStatusWindowMessage("Msg: " + parseMessage(jsonGameData));

            String jsondata = serverConnection.put("games/start",new Gson().toJson(existingGame));

            System.out.println(jsondata);
            screen.addStatusWindowMessage("Msg: " + jsondata);
            screen.getJoingame().clearFields();
        }
    }
    private class CreateGameActionListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            Game newGame = new Game();
            Gamer host = new Gamer();

            host.setId(currentUser.getId());
            host.setControls(screen.getCreategame().getTextField_gameControl().getText().trim());

            newGame.setMapSize(300);
            newGame.setHost(host);
            newGame.setName(screen.getCreategame().getTextField_gameName().getText().trim());

            String jsonGameData = serverConnection.post(new Gson().toJson(newGame),"games");

            System.out.println(parseMessage(jsonGameData));
            screen.addStatusWindowMessage("Msg: " + parseMessage(jsonGameData));
            screen.getCreategame().clearFields();
        }
    }

    private class DeleteGameActionListener implements ActionListener {

        public void actionPerformed(ActionEvent a) {

            Game gameId = new Game();
            Game deleteGame = new Game();

            deleteGame.getGameId();

            deleteGame.setGameId(Integer.parseInt(screen.getDeletegame().getTextField().getText().trim()));

            String jsonGameData = serverConnection.delete("games/"+gameId);

            screen.addStatusWindowMessage("Spillet er nu slettet: " + parseMessage(jsonGameData));
            screen.getDeletegame().clearFields();
        }
    }

    private void LoadHighScores(){

        String jsondata = serverConnection.get("scores");

        Type listeType = new TypeToken<ArrayList<Score>>(){}.getType();
        ArrayList<Score> highscores = new Gson().fromJson(jsondata, listeType);

        screen.addStatusWindowMessage("\nPlayer Id: \tPlayer name: \tScore: \tGame id:");
        for(int i=0;i<highscores.size();i++){
            Score score = highscores.get(i);
            screen.addStatusWindowMessage(score.getUser().getId() +"\t" + score.getUser().getFirstName() +"\t" + score.getScore()  +"\t" + score.getGame().getGameId());

        }

    }

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