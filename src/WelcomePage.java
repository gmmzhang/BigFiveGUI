import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JPanel {

    private JLabel welcomeLabel;
    private JButton startButton;

    public WelcomePage(String userID){
        welcomeLabel = new JLabel("Welcome to the BIG FIVE Personality Test, " + userID);
        startButton = new JButton("START");

        welcomeLabel.setBounds(0,0,400,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
        //welcomeLabel.setText("Please Start BIGFIVE Test " + userID);

        add(welcomeLabel);
        add(startButton);

        /*
        setSize(420,420);
        setLayout(null);
        setVisible(true);

         */
    }
}
