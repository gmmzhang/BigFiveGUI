import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage extends JPanel {

    private JLabel welcomeLabel;
    private JButton startButton;
    private JLabel instructionLabel1;
    private JLabel instructionLabel2;
    private JLabel instructionLabel3;
    private MainFrame frame;
    private String userID;
    private JPanel centerPanel;
    private JPanel southPanel;
    private JPanel tempPanel1;
    private JPanel tempPanel2;
    private JPanel tempPanel3;
//    private JButton smallButton;
    private JButton largeButton;

    public WelcomePage(MainFrame mainframe, String user){
        frame = mainframe;
        userID = user;

        setLayout(new BorderLayout());

        // NORTH
        welcomeLabel = new JLabel("Welcome to the BIG FIVE Personality Test, " + userID, SwingConstants.CENTER);
        welcomeLabel.setBounds(0,0,400,85);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
        add(welcomeLabel, BorderLayout.NORTH);

        // CENTER
        centerPanel = new JPanel();
        centerPanel.setOpaque(false); //
        centerPanel.setLayout(new GridLayout(3,1));

        tempPanel1 = new JPanel();
        tempPanel2 = new JPanel();
        tempPanel3 = new JPanel();
        instructionLabel1 = new JLabel("INSTRUCTION", SwingConstants.CENTER);
        instructionLabel2 = new JLabel("Please read each question and select: ", SwingConstants.CENTER);
        instructionLabel3 = new JLabel("<html>How much do you agree with each statement about you as you generally are now <br/> (not as you wish to be in the future)? <html/>", SwingConstants.CENTER);
        tempPanel1.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        tempPanel2.setBorder(BorderFactory.createEmptyBorder(80,0,0,0));
        tempPanel3.setBorder(BorderFactory.createEmptyBorder(0,0,300,0));
        tempPanel1.add(instructionLabel1);
        tempPanel2.add(instructionLabel2);
        tempPanel3.add(instructionLabel3);
        centerPanel.add(tempPanel1);
        centerPanel.add(tempPanel2);
        centerPanel.add(tempPanel3);
        add(centerPanel, BorderLayout.CENTER);

        // SOUTH

        southPanel = new JPanel();
        southPanel.setOpaque(false);
        add(southPanel, BorderLayout.SOUTH);

//        smallButton = new JButton("Smaller Font");
//        smallButton.addActionListener(new SmallButtionListener());

        largeButton = new JButton("Larger Font");
        largeButton.addActionListener(new LargeButtionListener());

        startButton = new JButton("START");
        startButton.addActionListener(new StartButtonListener());
        //add(startButton, BorderLayout.SOUTH);

//        southPanel.add(smallButton, BorderLayout.EAST);
        southPanel.add(largeButton, BorderLayout.WEST);
        southPanel.add(startButton,BorderLayout.SOUTH);

        /*
        setSize(420,420);
        setLayout(null);
        setVisible(true);
         */
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            //remove(tempPanel1);
            //remove(tempPanel2);
            //remove(tempPanel3);
            //remove(centerPanel);
            frame.userStarted(userID);
        }
    }

//    private class SmallButtionListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            instructionLabel1.setFont(new Font(null,Font.PLAIN,10));
//            instructionLabel2.setFont(new Font(null,Font.PLAIN,10));
//            instructionLabel3.setFont(new Font(null,Font.PLAIN,10));
//        }
//    }

    private class LargeButtionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            instructionLabel1.setFont(new Font(null,Font.PLAIN,20));
            instructionLabel2.setFont(new Font(null,Font.PLAIN,20));
            instructionLabel3.setFont(new Font(null,Font.PLAIN,20));
        }
    }

}
