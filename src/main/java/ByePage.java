import javax.swing.*;
import java.awt.*;

public class ByePage extends JPanel {
    private MainFrame frame;
    public ByePage(MainFrame mainFrame, String user){
        MainFrame frame = mainFrame;
        JLabel byeLabel = new JLabel("Goodbye, " + user +"! Have a good one. ");
        byeLabel.setFont(new Font(null,Font.PLAIN,50));
        add(byeLabel);
    }
}
