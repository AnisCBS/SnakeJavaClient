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
public class Login extends JPanel {
    private JTextField PlayerID;
    private JPasswordField passwordField;
    private JButton btnLogin;
    private JLabel lblPlayerid;
    private JLabel lblPassword;
    private JLabel loginFailure;

    public Login() {
        setLayout(null);
        setBounds(100, 100, 450, 550);

        PlayerID = new JTextField();
        PlayerID.setBounds(162, 327, 189, 38);
        add(PlayerID);
        PlayerID.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setBounds(162, 376, 189, 38);
        add(passwordField);

        btnLogin = new JButton("Login");

        btnLogin.setForeground(new Color(0, 128, 128));
        btnLogin.setFont(new Font("Calibri", Font.BOLD, 22));
        btnLogin.setBounds(98, 425, 253, 44);
        add(btnLogin);

        lblPlayerid = new JLabel("PlayerID:");
        lblPlayerid.setFont(new Font("Calibri", Font.BOLD, 14));
        lblPlayerid.setBounds(93, 334, 59, 20);
        add(lblPlayerid);

        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Calibri", Font.BOLD, 14));
        lblPassword.setBounds(91, 380, 68, 27);
        add(lblPassword);

        loginFailure = new JLabel("");
        loginFailure.setForeground(new Color(204, 0, 0));
        loginFailure.setBounds(112, 354, 272, 44);
        add(loginFailure);

        JLabel cbs = new JLabel(""); Image src = new ImageIcon(this.getClass().getResource("Login.jpg")).getImage();
        cbs.setIcon( new ImageIcon(src));
        cbs.setBounds(0,0,450,550);
        add(cbs);

    }
    public void actionPerformedLogin(ActionListener login) {
        btnLogin.addActionListener(login);
    }

    public JTextField getPlayerID() {
        return PlayerID;
    }

    public JTextField getPasswordfield() {
        return passwordField;
    }


}