package GUI;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

/**
 * Created by Waseem on 17-01-2016.
 */

/**
 * This is the GUI class for the screen "CreateGame". The class consists of the GUI, getters and actionListeners.
 */

/**
 * Using an "extended" JPanel making it possible for a window to include JComponents.
 */

public class CreateGame extends JPanel {

    /**
     * Declaration of local variables.
     */
    private JTextField textField_gameName;
    private JButton btnCreateGame;
    private JButton btnBack;
    private JLabel lblNewGame;

    private JTextField textField_gameControl;
    private JButton btnA;
    private JButton btnS;
    private JButton btnD;
    private JButton btnW;

    public CreateGame() {

        /**
         * Setting layout to "null" so it get's defined by the size of the JFrame.
         */

        setLayout(null);
        setBounds(100, 100, 450, 550);

        /**
         * Adding JTextField.
         */

        textField_gameName = new JTextField();
        textField_gameName.setBounds(238, 203, 166, 34);
        add(textField_gameName);
        textField_gameName.setColumns(10);

        btnCreateGame = new JButton("Create Game");
        btnCreateGame.setForeground(new Color(0, 128, 128));
        btnCreateGame.setFont(new Font("Calibri", Font.BOLD, 22));
        btnCreateGame.setBounds(86, 403, 277, 34);
        add(btnCreateGame);

        btnBack = new JButton("Back to main menu");
        btnBack.setForeground(new Color(0, 128, 128));
        btnBack.setFont(new Font("Calibri", Font.BOLD, 22));
        btnBack.setBounds(86, 448, 277, 41);
        add(btnBack);


        lblNewGame = new JLabel("");
        lblNewGame.setBounds(86, 378, 277, 50);
        add(lblNewGame);

        /**
         * Adding JTextField.
         */

        textField_gameControl = new JTextField();
        textField_gameControl.setBounds(238, 248, 166, 34);
        add(textField_gameControl);
        textField_gameControl.setColumns(10);

        /**
         * Adding JButton.
         */

        btnA = new JButton("A = Left");
        btnA.setForeground(new Color(0, 128, 128));
        btnA.setFont(new Font("Calibri", Font.BOLD, 14));
        btnA.setBounds(86, 341, 79, 23);
        add(btnA);

        /**
         * Adding JButton.
         */

        btnW = new JButton("W = Up");
        btnW.setFont(new Font("Calibri", Font.BOLD, 14));
        btnW.setForeground(new Color(0, 128, 128));
        btnW.setBounds(175, 313, 89, 23);
        add(btnW);

        /**
         * Adding JButton.
         */

        btnS = new JButton("S = Down");
        btnS.setForeground(new Color(0, 128, 128));
        btnS.setFont(new Font("Calibri", Font.BOLD, 14));
        btnS.setBounds(175, 341, 89, 23);
        add(btnS);

        /**
         * Adding JButton.
         */

        btnD = new JButton("D = Right");
        btnD.setForeground(new Color(0, 128, 128));
        btnD.setFont(new Font("Calibri", Font.BOLD, 14));
        btnD.setBounds(274, 341, 89, 23);
        add(btnD);

        /**
         * Adds a background image to the panel.
         */

        JLabel cbs = new JLabel(""); Image src = new ImageIcon(this.getClass().getResource("Creategame.jpg")).getImage();
        cbs.setIcon( new ImageIcon(src));
        cbs.setBounds(0,0,450,550);
        add(cbs);

    }

    /**
     * ActionListeners for "CreateGame" and "Back" buttons.
     */

    public void clearFields(){
        textField_gameName.setText("");
        textField_gameControl.setText("");
        
        
    }
    
    public void actionPerformedCreateGame(ActionListener creategame) {
        btnCreateGame.addActionListener(creategame);
    }

    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }

    public JTextField getTextField_gameControl() {
        return textField_gameControl;
    }

    public JTextField getTextField_gameName() {
        return textField_gameName;
    }
}