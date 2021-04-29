import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class LoginPage extends JPanel {

    //JFrame frame = new JFrame();
    private JButton loginButton;
    private JButton resetButton;
    private JTextField userIDField;
    private JPasswordField userPasswordField;
    private JLabel userIDLabel;
    private JLabel userPasswordLabel;
    private JLabel messageLabel;
    private MainFrame frame;
    private IDandPasswords idandPasswords;
    private HashMap<String,String> logininfo;


    public LoginPage(MainFrame mainframe){
        frame = mainframe; // Contain the MainWindow JFrame
        //logininfo = loginInfoOriginal;
        idandPasswords= new IDandPasswords();
        logininfo = idandPasswords.getLoginInfo();

        loginButton = new JButton("Login");
        resetButton = new JButton("Reset");
        userIDField = new JTextField();
        userPasswordField = new JPasswordField();
        userIDLabel = new JLabel("User ID: ");
        userPasswordLabel = new JLabel("Password: ");
        messageLabel = new JLabel();

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);
        userIDField.setColumns(10); // set width
        userPasswordField.setColumns(10);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new LoginButtonListener());

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(new ResetButtonListener());

        add(messageLabel);
        add(userIDLabel);
        add(userIDField);
        add(userPasswordLabel);
        add(userPasswordField);
        add(loginButton);
        add(resetButton);

        //setSize(420,420);
        //setLayout(null);
        //setVisible(true);
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userID)){
                if(logininfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    //WelcomePage welcomePage = new WelcomePage(userID);
                    frame.userLoggedIn(userID);
                }
                else{
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password");
                }
            }
            else{
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username Not Found");
            }
        }
    }

    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
    }


}
