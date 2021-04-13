import javax.swing.*;
public class MainWindow extends JFrame{
    private LoginPage loginPanel; // Declare a variable of JPanel type.
    private WelcomePage welcomePanel;
    private QuestionPanel questionPanel;
    private IDandPasswords idandPasswords;
    private itemBank bank;


    public MainWindow(itemBank bank) { // Constructor
        this.bank = bank;// Contain items
        loginPanel = new LoginPage(this);  // Initialize JPanel object using the LoginPanel class
        add(loginPanel); // Add Panel Container
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Resize the frame to fit the components.
    }

    public void userLoggedIn(String userID) {
        remove(loginPanel);
        welcomePanel = new WelcomePage(userID);
        add(welcomePanel);
        //pack();
    }

    public void userStarted(String userID) {
        remove(welcomePanel);
        questionPanel = new QuestionPanel(bank);
        add(questionPanel);
        //pack();
    }

}
