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
        contentPane.add(mainMenu);
        mainMenu.setLayout(new CardLayout());

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

        status = new JPanel();
        status.setBounds(485, 10, 415, 550);
        status.setBackground(new Color(169, 169, 169));
        contentPane.add(status);
        status.setLayout(null);

        lblStatusMessages = new JLabel("Status Messages:");
        lblStatusMessages.setForeground(new Color(0, 0, 102));
        lblStatusMessages.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblStatusMessages.setVerticalAlignment(SwingConstants.TOP);
        lblStatusMessages.setBounds(10, 11, 161, 22);
        status.add(lblStatusMessages);

        textArea = new JTextArea();
        textArea.setBounds(10, 44, 395, 495);
        textArea.setLineWrap(true);
        textArea.setText("Extra: ");
        status.add(textArea);
        textArea.setEditable(false);

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

    public JoinGame getJoingame() {
        return joingame;
    }

    public CreateGame getCreategame() {
        return creategame;
    }

    public DeleteGame getDeletegame() {
        return deletegame;
    }

    public Highscores Highscores() {return highscores;}


    public void run() {
    }
    public void addStatusWindowMessage(String msg){
        textArea.setText(textArea.getText() + "\n" + msg);
    }
}
