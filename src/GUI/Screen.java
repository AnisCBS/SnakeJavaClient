package GUI;

import java.awt.*;
import javax.swing.*;

/**
 * Created by Waseem on 17-01-2016.
 */

/**
 * This class includes one JFrame which has every JPanel attached.
 */

/**
 * An extended JFrame which gives us the border around the JPanels.
 */
public class Screen extends JFrame {

    /**
     * An ID for every JPanel.
     */

    public static final String LOGIN = "Login";
    public static final String MAINMENU = "Mainmenu";
    public static final String JOINGAME = "Joingame";
    public static final String CREATEGAME = "Creategame";
    public static final String DELETEGAME = "Deletegame";
    public static final String HIGHSCORES = "Highscores";

    private JPanel contentPane, statusPane;

    /**
     * Declaration of local variables from the different variables.
     */

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

    /**
     * Creation of the frame "Screen" which adds the border for JPanels.
     * */

    public Screen() {
        setTitle("CBS SNAKE GAME");
        setResizable(false);

        /**
         * Sets the size for the JFrame.
         */

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 930, 610);

        /**
         * Adds a container.
         */

        contentPane = new JPanel();
        setContentPane(contentPane);
        getContentPane().setBackground(new Color(153, 153, 153));
        contentPane.setLayout(null);

        /**
         * Adds attributes for the container.
         */

        mainMenu = new JPanel();
        mainMenu.setBounds(10, 10, 450, 550);
        contentPane.add(mainMenu);
        mainMenu.setLayout(new CardLayout());

        /**
         * Adds all panels to the container.
         */

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

        /**
         * Creates a status panel.
         */

        status = new JPanel();
        status.setBounds(485, 10, 415, 550);
        status.setBackground(new Color(169, 169, 169));
        contentPane.add(status);
        status.setLayout(null);

        /**
         * Adds a JLabel.
         */

        lblStatusMessages = new JLabel("Status Messages:");
        lblStatusMessages.setForeground(new Color(0, 128, 128));
        lblStatusMessages.setFont(new Font("Calibri", Font.BOLD, 24));
        lblStatusMessages.setVerticalAlignment(SwingConstants.TOP);
        lblStatusMessages.setBounds(10, 11, 242, 22);
        status.add(lblStatusMessages);

        /**
         * Adds a textArea.
         */

        textArea = new JTextArea();
        textArea.setBounds(10, 44, 395, 495);
        textArea.setLineWrap(true);
        textArea.setText("");
        status.add(textArea);
        textArea.setEditable(false);

    }
    public void clearFields(){
        textArea.setText("");

    }

    /**
     * "Public void show" method makes it possible to send individual panels to the frame.
     */

    public void show(String panel) {

        CardLayout cardLayout = (CardLayout) mainMenu.getLayout();
        cardLayout.show(mainMenu, panel);
    }

    /**
     * Getters for every panel so that they can be retrieved from elsewhere.
     */

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
