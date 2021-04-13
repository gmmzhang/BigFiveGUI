import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;


public class LoginPage extends JPanel {

    //JFrame frame = new JFrame();
    private JButton loginButton = new JButton("Login");
    private JButton resetButton = new JButton("Reset");
    private JTextField userIDField = new JTextField();
    private JPasswordField userPasswordField = new JPasswordField();
    private JLabel userIDLabel = new JLabel("UserID:");
    private JLabel userPasswordLabel = new JLabel("Password:");
    private JLabel messageLabel = new JLabel();
    private MainWindow frame;
    private IDandPasswords idandPasswords;
    private HashMap<String,String> logininfo;


    public LoginPage(MainWindow mainWindow){
        frame = mainWindow; // Contain the MainWindow JFrame
        //logininfo = loginInfoOriginal;
        idandPasswords= new IDandPasswords();
        logininfo = idandPasswords.getLoginInfo();

        userIDLabel.setBounds(50,100,75,25);
        userPasswordLabel.setBounds(50,150,75,25);
        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        userIDField.setBounds(125,100,200,25);
        userPasswordField.setBounds(125,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(new loginButtonListener());

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(new resetButtonListener());

        add(userIDLabel);
        add(userPasswordLabel);
        add(messageLabel);
        add(userIDField);
        add(userPasswordField);
        add(loginButton);
        add(resetButton);

        //setSize(420,420);
        //setLayout(null);
        //setVisible(true);
    }

    private class loginButtonListener implements ActionListener {
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

    private class resetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            userIDField.setText("");
            userPasswordField.setText("");
        }
    }

    /*
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==resetButton){
            userIDField.setText("");
            userPasswordField.setText("");

        }

        if(e.getSource()==loginButton){
            String userID = userIDField.getText();
            String password = String.valueOf(userPasswordField.getPassword());

            if(logininfo.containsKey(userID)){
                if(logininfo.get(userID).equals(password)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login successful");
                    frame.dispose();
                    WelcomePage welcomePage = new WelcomePage(userID);
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

     */
}
