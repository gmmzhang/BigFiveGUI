import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class CommentsPanel extends JPanel {
    private JLabel finishLabel;
    private JTextArea emailText;
    private JTextArea commentsText;
    private MainFrame frame;
    private String userID;
    private JButton sendFeedback;
    private PrintStream outPut;

    public CommentsPanel(MainFrame mainframe, String user, Object[][] records) {
        finishLabel = new JLabel("Thanks for your participation! Please leave your email-address in the area below:");
        JLabel commentsLabel = new JLabel("Please leave your comments in the area below:");
        emailText = new JTextArea(1,10);
        commentsText = new JTextArea(5, 10);
        userID = user;
        frame = mainframe;

        JPanel pageLayout = new JPanel();
        pageLayout.setLayout(new GridLayout(4,1));
        add(pageLayout,BorderLayout.NORTH);
        pageLayout.add(finishLabel);
        pageLayout.add(emailText);
        pageLayout.add(commentsLabel);
        pageLayout.add(commentsText);
        ReportPanel.getRecords();

        setVisible(true);

        sendFeedback = new JButton("Submit Feedback");
        //sendFeedback.setBorder(BorderFactory.createEmptyBorder(5,100,5,100));
        add(sendFeedback,BorderLayout.EAST);
        sendFeedback.addActionListener(new sendFeedbackListener());

    }

    private class sendFeedbackListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String emailContent = emailText.getText();
            String commentsContent = commentsText.getText();
            try {
                outPut = new PrintStream(new File(userID+"_out.txt"));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            outPut.println(Arrays.deepToString(ReportPanel.getRecords()));
            outPut.println(emailContent);
            outPut.println(commentsContent);
            frame.sayGoodbye(userID);
        }
    }

}
