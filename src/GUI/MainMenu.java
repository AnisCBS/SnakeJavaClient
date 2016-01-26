package GUI;

import SDK.User;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * Created by Waseem on 17-01-2016.
 */

/**
 * This is the GUI class for the screen "MainMenu". The class consists of the GUI, getters and actionListeners.
 */

/**
 * Using an "extended" JPanel making it possible for a window to include JComponents.
 */

public class MainMenu extends JPanel {

    /**
     * Declaration of local variables.
     */

    private JButton btnStartNewGame;
    private JButton btnCreateGame;
    private JButton btnDeleteGame;
    private JButton btnLoadHighscores;
    private JButton btnLogOut;

    /**
     * Creation of the panel "MainMenu" that gets added to the different components.
     */

    public MainMenu() {

        /**
         * Setting layout to "null" so it get's defined by the size of the JFrame.
         */

        setBounds(100, 100, 450, 550);
        setLayout(null);

        /**
         * Adding JButton.
         */

        btnStartNewGame = new JButton("Join Game");
        btnStartNewGame.setForeground(new Color(0, 128, 128));
        btnStartNewGame.setFont(new Font("Calibri", Font.BOLD, 18));
        btnStartNewGame.setBounds(72, 179, 306, 50);
        this.add(btnStartNewGame);

        /**
         * Adding JButton.
         */

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setForeground(new Color(0, 128, 128));
        btnCreateGame.setFont(new Font("Calibri", Font.BOLD, 18));
        btnCreateGame.setBounds(72, 240, 306, 50);
        this.add(btnCreateGame);

        /**
         * Adding JButton.
         */

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setForeground(new Color(0, 128, 128));
        btnDeleteGame.setFont(new Font("Calibri", Font.BOLD, 18));
        btnDeleteGame.setBounds(72, 301, 306, 50);
        this.add(btnDeleteGame);

        /**
         * Adding JButton.
         */

        btnLoadHighscores = new JButton("Highscores");
        btnLoadHighscores.setForeground(new Color(0, 128, 128));
        btnLoadHighscores.setFont(new Font("Calibri", Font.BOLD, 18));
        btnLoadHighscores.setBounds(72, 362, 306, 50);
        this.add(btnLoadHighscores);

        /**
         * Adding JButton.
         */

        btnLogOut = new JButton("Log Out");
        btnLogOut.setForeground(new Color(0, 128, 128));
        btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnLogOut.setBounds(86, 448, 277, 41);
        this.add(btnLogOut);

        /**
         * Adds a background image to the panel.
         */

        JLabel cbs = new JLabel(""); Image src = new ImageIcon(this.getClass().getResource("Mainmenu.jpg")).getImage();
        cbs.setIcon( new ImageIcon(src));
        cbs.setBounds(0,0,450,550);
        this.add(cbs);
    }

    /**
     * Creates actionListeners for all the buttons, as well as an action command list.
     */

    public void setUsers(ArrayList<User> users){

    }
    public void addACList(ActionListener ac){
        btnStartNewGame.addActionListener(ac);
        btnCreateGame.addActionListener(ac);
        btnDeleteGame.addActionListener(ac);
        btnLoadHighscores.addActionListener(ac);
        btnLogOut.addActionListener(ac);
    }


}