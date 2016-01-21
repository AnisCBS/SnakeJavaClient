package GUI;

import java.awt.*;
import javax.swing.*;

/**
 * Created by Waseem on 17-01-2016.
 */
public class Screen extends JFrame {

    public static final String LOGIN = "Login";
    public static final String MAINMENU = "Mainmenu";
    public static final String JOINGAME = "Joingame";
    public static final String CREATEGAME = "Creategame";
    public static final String DELETEGAME = "Deletegame";
    public static final String HIGHSCORES = "Highscores";

    private JPanel contentPane;

    private Login login;
    private MainMenu mainmenu;
    private JoinGame joingame;
    private CreateGame creategame;
    private DeleteGame deletegame;
    private Highscores highscores;

    private JPanel status;
    private JLabel lblStatusMessages;
    private JTextArea textArea;
    private JPanel mainMenu;

    public Screen() {
        setTitle("CBS SNAKE GAME");
        setResizable(false);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 480, 610);

        contentPane = new JPanel();
        setContentPane(contentPane);
        getContentPane().setBackground(new Color(153, 153, 153));
        contentPane.setLayout(null);

        mainMenu = new JPanel();
        mainMenu.setBounds(10, 10, 450, 550);
        contentPane.add(mainMenu); // Tilføj til container
        mainMenu.setLayout(new CardLayout()); // Tilføjer e

        login = new Login();
        mainMenu.add(login, LOGIN);

        mainmenu = new MainMenu();
        mainMenu.add(mainmenu, MAINMENU);

        joingame = new JoinGame();
        mainMenu.add(joingame, JOINGAME);

        creategame = new CreateGame();
        mainMenu.add(creategame, CREATEGAME);

        deletegame = new DeleteGame();
        mainMenu.add(deletegame, DELETEGAME);

        highscores = new Highscores();
        mainMenu.add(highscores, HIGHSCORES);

    }
    public void clearFields(){
        textArea.setText("");

    }

    public void show(String panel) {

        CardLayout cardLayout = (CardLayout) mainMenu.getLayout();
        cardLayout.show(mainMenu, panel);
    }

    public Login getLogin() {
        return login;
    }

    public MainMenu getMainmenu() {
        return mainmenu;
    }

    public JoinGame getStartgame() {
        return joingame;
    }

    public CreateGame getCreategame() {
        return creategame;
    }

    public DeleteGame getDeletegame() {
        return deletegame;
    }

    public Highscores getHighscores() {return highscores;}


    public void run() {
    }
}
