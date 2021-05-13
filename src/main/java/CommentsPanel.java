import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentsPanel extends JPanel {
    private JLabel finishLabel;
    private JTextArea emailText;
    private JTextArea commentsText;
    private MainFrame frame;
    private String userID;
    private JButton sendFeedback;

    public CommentsPanel(MainFrame mainframe, String user) {
        finishLabel = new JLabel("Thanks for your participation! Please leave your email-address in the area below:");
        JLabel commentsLable = new JLabel("Please leave your comments in the area below:");
        emailText = new JTextArea(1,10);
        commentsText = new JTextArea(5, 10);
        userID = user;
        frame = mainframe;

        JPanel pageLayout = new JPanel();
        pageLayout.setLayout(new GridLayout(4,1));
        add(pageLayout,BorderLayout.NORTH);
        pageLayout.add(finishLabel);
        pageLayout.add(emailText);
        pageLayout.add(commentsLable);
        pageLayout.add(commentsText);

        setVisible(true);

        sendFeedback = new JButton("Submit FeedBack");
        //sendFeedback.setBorder(BorderFactory.createEmptyBorder(5,100,5,100));
        add(sendFeedback,BorderLayout.EAST);
        sendFeedback.addActionListener(new sendFeedbackListener());

    }

    private class sendFeedbackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String emailContent = emailText.getText();
            String commentsContent = commentsText.getText();
            System.out.println(emailContent);
            System.out.println(commentsContent);
            frame.sayGoodbye(userID);
        }
    }

}
