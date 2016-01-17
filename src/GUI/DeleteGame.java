package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Created by Waseem on 17-01-2016.
 */
public class DeleteGame extends JPanel {
    private JTextField textField;
    private JButton btnDeleteGame;
    private JButton btnBack;
    private JLabel lblDeleted;
    private JLabel lblGameDeleted;

    public JTextField getTextField() {
        return textField;
    }

    public DeleteGame() {

        setLayout(null);
        setBounds(100, 100, 450, 550);

        textField = new JTextField();
        textField.setBounds(124, 242, 186, 34);
        add(textField);
        textField.setColumns(10);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setForeground(new Color(0, 128, 128));
        btnDeleteGame.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnDeleteGame.setBounds(86, 301, 277, 34);
        add(btnDeleteGame);

        btnBack = new JButton("Back to main menu");
        btnBack.setForeground(new Color(0, 128, 128));
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
        btnBack.setBounds(86, 448, 277, 41);
        add(btnBack);

        lblDeleted = new JLabel("");
        lblDeleted.setBounds(86, 341, 277, 20);
        add(lblDeleted);

        lblGameDeleted = new JLabel("");
        lblGameDeleted.setBounds(86, 378, 277, 50);
        add(lblGameDeleted);

        JLabel cbs = new JLabel(""); Image src = new ImageIcon(this.getClass().getResource("Deletegame.jpg")).getImage();
        cbs.setIcon( new ImageIcon(src));
        cbs.setBounds(0,0,450,550);
        add(cbs);
    }


}