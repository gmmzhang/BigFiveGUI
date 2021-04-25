import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Hashtable;

public class ReportPanel extends JPanel {
    private MainFrame frame;
    private String userID;
    private int[] questionAnswer;


    public ReportPanel(MainFrame mainframe, String user, int[] answer) {
        frame = mainframe;
        userID = user;
        questionAnswer = answer;

        System.out.println(Arrays.toString(questionAnswer));
    }
}