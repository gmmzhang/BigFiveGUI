import javax.swing.*;
import java.awt.*;

public class ByePage extends JPanel {
    private MainFrame frame;
    public ByePage(MainFrame mainFrame, String user){
        MainFrame frame = mainFrame;
        JLabel byeLabel = new JLabel("Goodbye, " + user +"! Have a good one.");
        byeLabel.setFont(new Font(null,Font.PLAIN,50));
        JLabel closeWindow = new JLabel("You may close this window now. ");
        closeWindow.setFont(new Font(null,Font.PLAIN,15));
        closeWindow.setBorder(BorderFactory.createEmptyBorder(30,150,30,10));
        add(byeLabel, BorderLayout.NORTH);
        add(closeWindow, BorderLayout.SOUTH);
    }
}
