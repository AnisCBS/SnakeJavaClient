package GUI;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;


/**
 * Created by Waseem on 17-01-2016.
 */

/**
 * This is the GUI class for the screen "Login". The class consists of the GUI, getters and actionListeners.
 */

/**
 * Using an "extended" JPanel making it possible for a window to include JComponents.
 */

public class Login extends JPanel {
    private JTextField PlayerID;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JLabel lblPlayerid;
    private JLabel lblPassword;
    private JLabel loginFailure;

    /**
     * Declaration of local variables.
     */

    public Login() {

        /**
         * Creation of the panel "MainMenu" that gets added to the different components.
         */

        setLayout(null);
        setBounds(100, 100, 450, 550);

        /**
         * Adding JTextField.
         */

        PlayerID = new JTextField();
        PlayerID.setBounds(162, 327, 189, 38);
        add(PlayerID);
        PlayerID.setColumns(10);

        /**
         * Adding JPasswordField.
         */

        passwordField = new JPasswordField();
        passwordField.setBounds(162, 376, 189, 38);
        add(passwordField);

        /**
         * Adding JButton.
         */

        btnLogin = new JButton("Login");
        btnLogin.setForeground(new Color(0, 128, 128));
        btnLogin.setFont(new Font("Calibri", Font.BOLD, 22));
        btnLogin.setBounds(98, 425, 253, 44);
        add(btnLogin);

        /**
         * Adding JLabel.
         */

        lblPlayerid = new JLabel("PlayerID:");
        lblPlayerid.setFont(new Font("Calibri", Font.BOLD, 14));
        lblPlayerid.setBounds(93, 334, 59, 20);
        add(lblPlayerid);

        /**
         * Adding JLabel.
         */

        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Calibri", Font.BOLD, 14));
        lblPassword.setBounds(91, 380, 68, 27);
        add(lblPassword);

        /**
         * Adding JLabel.
         */

        loginFailure = new JLabel("");
        loginFailure.setForeground(new Color(204, 0, 0));
        loginFailure.setBounds(112, 354, 272, 44);
        add(loginFailure);

        /**
         * Adds a background image to the panel.
         */

        JLabel cbs = new JLabel(""); Image src = new ImageIcon(this.getClass().getResource("Login.jpg")).getImage();
        cbs.setIcon( new ImageIcon(src));
        cbs.setBounds(0,0,450,550);
        add(cbs);

    }

    /**
     * ActionListeners for the button "Login".
     */
    public void actionPerformedLogin(ActionListener login) {
        btnLogin.addActionListener(login);
    }

    public JTextField getPlayerID() {
        return PlayerID;
    }

    public JTextField getPasswordfield() {
        return passwordField;
    }

    /**
     * Creates a set method for "PlayerID" and "passwordField" that can be used to celar the text.
     */

    public void clearFields() {
        PlayerID.setText("");
        passwordField.setText("");
    }
}