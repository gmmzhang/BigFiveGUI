import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    private LoginPage loginPanel; // Declare a variable of JPanel type.
    private WelcomePage welcomePanel;
    private QuestionPanel questionPanel;
    private ReportPanel reportPanel;
    private IDandPasswords idandPasswords;
    private ItemBank bank;
    public int Height;
    public int Width;


    public MainFrame(ItemBank itemBank) { // Constructor
        super("Big Five Personality Assessment"); // Set the frame title
        bank = itemBank;// Contain items
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close the frame when press X
        Height = 500;
        Width = 1000;
        setSize(new Dimension(Width, Height)); // Set the frame size

        loginPanel = new LoginPage(this);  // Initialize JPanel object using the LoginPanel class
        add(loginPanel); // Add Panel Container
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //pack(); // Resize the frame to fit the components.
    }

    public void userLoggedIn(String userID) {
        remove(loginPanel);
        welcomePanel = new WelcomePage(this, userID);
        add(welcomePanel);
        //pack();
    }

    public void userStarted(String userID) {
        remove(welcomePanel);
        questionPanel = new QuestionPanel(this, bank, userID);
        add(questionPanel);
        getContentPane().invalidate();
        getContentPane().validate();
        //pack();
    }

    public void userSubmitted(String userID, int[] questionAnswer) {
        remove(questionPanel);
        reportPanel = new ReportPanel(this, userID, questionAnswer);
        add(reportPanel);
        getContentPane().invalidate();
        getContentPane().validate();
        //pack();
    }

}
