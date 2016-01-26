package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Created by Waseem on 17-01-2016.
 */

/**
 * This is the GUI class for the screen "JoinGame". The class consists of the GUI, getters and actionListeners.
 */

/**
 * Using an "extended" JPanel making it possible for a window to include JComponents.
 */
public class JoinGame extends JPanel {

    /**
     * Declaration of local variables.
     */
    private JTextField textField_gameId;
    private JButton btnStartGame;
    private JButton btnBack;
    private JLabel lblGameControls;
    private JTextField textfield_gameControl;
    private JLabel lblGameId;

    /**
     * Creation of the panel "JoinGame" that gets added to the different components.
     */

   public JoinGame() {

       /**
        * Setting layout to "null" so it get's defined by the size of the JFrame.
        */

        setLayout(null);
        setBounds(100, 100, 450, 550);

       /**
        * Adding JTextField.
        */

        textField_gameId = new JTextField();
        textField_gameId.setBounds(205, 224, 158, 34);
        add(textField_gameId);
        textField_gameId.setColumns(10);

       /**
        * Adding JButton.
        */

        btnStartGame = new JButton("Start Game");
        btnStartGame.setForeground(new Color(0, 128, 128));
        btnStartGame.setFont(new Font("Calibri", Font.BOLD, 22));
        btnStartGame.setBounds(98, 353, 253, 32);
        add(btnStartGame);

       /**
        * Adding JButton.
        */

        btnBack = new JButton("Back to main menu");
        btnBack.setForeground(new Color(0, 128, 128));
        btnBack.setFont(new Font("Calibri", Font.BOLD, 22));
        btnBack.setBounds(86, 448, 277, 41);
        add(btnBack);

       /**
        * Adding JTextField.
        */

        textfield_gameControl = new JTextField();
        textfield_gameControl.setBounds(205, 281, 158, 34);
        add(textfield_gameControl);
        textfield_gameControl.setColumns(10);

       /**
        * Adding JLabel.
        */

        lblGameId = new JLabel("Game ID:");
        lblGameId.setFont(new Font("Calibri", Font.BOLD, 14));
        lblGameId.setBounds(98, 232, 85, 14);
        add(lblGameId);

       /**
        * Adding JLabel.
        */

        lblGameControls = new JLabel("Game Controls:");
        lblGameControls.setFont(new Font("Calibri", Font.BOLD, 14));
        lblGameControls.setBounds(98, 287, 95, 20);
        add(lblGameControls);

       /**
        * Adds a background image to the panel.
        */

        JLabel cbs = new JLabel("");
        cbs.setFont(new Font("Calibri", Font.BOLD, 12));Image src = new ImageIcon(this.getClass().getResource("Startgame.jpg")).getImage();
        cbs.setIcon( new ImageIcon(src));
        cbs.setBounds(0,0,450,550);
        add(cbs);

    }
    
    public void clearFields() {
        textField_gameId.setText("");
        textfield_gameControl.setText("");

    }

    /**
     * Creates actionListeners for all the buttons.
     */

     public void actionPerformedJoinGame(ActionListener joingame) {
          btnStartGame.addActionListener(joingame);

     }

     public void actionPerformedBack(ActionListener back) {
          btnBack.addActionListener(back);
     }

    public JTextField getTextfield_gameControl() {
        return textfield_gameControl;
    }

    public JTextField getTextField_gameId() {
        return textField_gameId;
    }
}

