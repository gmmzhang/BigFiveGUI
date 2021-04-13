import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JPanel {

    private JLabel welcomeLabel;
    private JButton startButton;
    private JLabel instructionLabel1;
    private JLabel instructionLabel2;
    private MainWindow frame;
    private String userID;
    private JPanel centerPanel;
    private JPanel tempPanel1;
    private JPanel tempPanel2;

    public WelcomePage(MainWindow mainwindow, String user){
        frame = mainwindow;
        userID = user;

        setLayout(new BorderLayout());

        // NORTH
        welcomeLabel = new JLabel("Welcome to the BIG FIVE Personality Test, " + userID, SwingConstants.CENTER);
        welcomeLabel.setBounds(0,0,400,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
        add(welcomeLabel, BorderLayout.NORTH);

        // CENTER
        centerPanel = new JPanel();
        centerPanel.setOpaque(false); //
        centerPanel.setLayout(new GridLayout(2,1));

        tempPanel1 = new JPanel();
        tempPanel2 = new JPanel();
        instructionLabel1 = new JLabel("Instruction: Please read each question and select: ", SwingConstants.CENTER);
        instructionLabel2 = new JLabel("How much do you agree with each statement about you as you generally are now, not as you wish to be in the future?", SwingConstants.CENTER);
        tempPanel1.setBorder(BorderFactory.createEmptyBorder(150,0,0,0));
        tempPanel2.setBorder(BorderFactory.createEmptyBorder(0,0,150,0));
        tempPanel1.add(instructionLabel1);
        tempPanel2.add(instructionLabel2);
        centerPanel.add(tempPanel1);
        centerPanel.add(tempPanel2);
        add(centerPanel, BorderLayout.CENTER);

        // SOUTH
        startButton = new JButton("START");
        startButton.addActionListener(new StartButtonListener());
        add(startButton, BorderLayout.SOUTH);

        /*
        setSize(420,420);
        setLayout(null);
        setVisible(true);
         */
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            remove(tempPanel1);
            remove(tempPanel2);
            remove(centerPanel);
            frame.userStarted(userID);
        }
    }

}
