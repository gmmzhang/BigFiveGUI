import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CommentsPanel extends JPanel {
    private JTextArea text;
    private MainFrame frame;
    private String userID;
    private JButton sendFeedback;

    public CommentsPanel(MainFrame mainframe, String user) {
        frame = mainframe;
        text = new JTextArea(20,50);
        userID = user;

        add(text);
        setVisible(true);

        sendFeedback = new JButton("Send FeedBack");
        add(sendFeedback, BorderLayout.SOUTH);

    }

}
