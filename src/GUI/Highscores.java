package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 * Created by Waseem on 17-01-2016.
 */
public class Highscores extends JPanel {

    /**
     * Declaration of local variables.
     */

    private JTable table;
    private JButton btnBack;

    /**
     * Creation of the panel "HighscoresMenu" that gets added to the different components.
     */

    public Highscores() {
        setLayout(null);
        setBounds(100, 100, 450, 550);

        table = new JTable();
        table.setBounds(84, 207, 319, 221);
        add(table);


        btnBack = new JButton("Back to main menu");
        btnBack.setForeground(new Color(0, 128, 128));
        btnBack.setFont(new Font("Calibri", Font.BOLD, 22));
        btnBack.setBounds(86, 448, 277, 41);
        add(btnBack);

        /**
         * Adds a background image to the panel.
         */

        JLabel cbs = new JLabel(""); Image src = new ImageIcon(this.getClass().getResource("Highscores.jpg")).getImage();
        cbs.setIcon( new ImageIcon(src));
        cbs.setBounds(0,0,450,550);
        add(cbs);

    }

    public void actionPerformedHighScores(ActionListener highscores) {

    }

    public void actionPerformedBack(ActionListener back) {
        btnBack.addActionListener(back);
    }

}