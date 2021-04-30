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

public class QuestionPanel extends JPanel {

    private ItemBank bank;
    private JLabel title;
    private JPanel titlePanel;
    private MainFrame frame;
    private String userID;
    private JSlider optionSlider;
    private JComboBox questionChooser;
    private JPanel bottomPanel;
    private JButton nextButton;
    private JButton submitButton;
    private int currentItemNumber;
    public int[] questionAnswer;
//    private JButton smallButton;
    private JButton largeButton;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;

    public QuestionPanel(MainFrame mainframe, ItemBank itembank, String user) {
        frame = mainframe;
        bank = itembank;
        userID = user;
        currentItemNumber = 1;
        questionAnswer = new int[20];
        for (int i = 0; i < questionAnswer.length; i++) {
            questionAnswer[i] = 3;
        }
        //System.out.println(Arrays.toString(questionAnswer));

        // Panel
        setLayout(new BorderLayout());

        // NORTH
        titlePanel = new JPanel();
        //titlePanel.setOpaque(false);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));

        title = new JLabel("Question 1. In general, I am the life of the party.", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 20));

//        smallButton = new JButton("Smaller Font");
//        smallButton.addActionListener(new QuestionPanel.SmallButtionListener());

        largeButton = new JButton("Larger Font");
        largeButton.addActionListener(new LargeButtionListener());

//        titlePanel.add(smallButton, BorderLayout.EAST);
        titlePanel.add(largeButton, BorderLayout.WEST);
        titlePanel.add(title, BorderLayout.CENTER);

        add(titlePanel, BorderLayout.NORTH);

        // CENTER
        optionSlider = new JSlider(1, 5, 3);
        optionSlider.setMajorTickSpacing(1);
        optionSlider.setMinorTickSpacing(1);
        optionSlider.setPaintLabels(true);
        Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
        label1 = new JLabel("<html>Strongly<br/>Disagree<html/>");
        table.put (1, label1);
        label2 = new JLabel("<html>Somewhat<br/>Disagree<html>");
        table.put (2, label2);
        label3 = new JLabel("<html>Neither Agree<br/>nor Disagree<html>");
        table.put (3, label3);
        label4 = new JLabel("<html>Somewhat<br/>Agree<html>");
        table.put (4, label4);
        label5 = new JLabel("<html>Strongly<br/>Agree<html>");
        table.put (5, label5);

        optionSlider.setLabelTable (table);
        optionSlider.addChangeListener(new OptionSliderListener());
        add(optionSlider, BorderLayout.CENTER);


        // South
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,3));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        bottomPanel.setOpaque(false);

        nextButton = new JButton("Next question");
        nextButton.addActionListener(new NextButtonListener());
        //nextButton.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));

        questionChooser = new JComboBox();
        for ( int i =0; i<bank.items.size(); i++){
            questionChooser.addItem(bank.items.get(i));
            //System.out.println(bank.items.get(i).getItemNumber());
            //System.out.println(bank.items.get(i).getDescription());
        }
        questionChooser.addItemListener(new QuestionChooserListener());

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitButtonListener());

        bottomPanel.add(nextButton);
        bottomPanel.add(questionChooser);
        bottomPanel.add(submitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        setVisible(true);

    }

    private class QuestionChooserListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            JComboBox selector = (JComboBox) e.getSource();
            Item selectedItem = (Item) selector.getSelectedItem();
            title.setText(selectedItem.getDescription());
            currentItemNumber = Integer.parseInt(selectedItem.getItemNumber());
            optionSlider.setValue(3);
        }
    }

    private class NextButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt)  {
            //System.out.println(questionChooser.getSelectedItem());
            if (currentItemNumber < 20) {
                title.setText(bank.items.get(currentItemNumber).getDescription());
                currentItemNumber += 1;
                optionSlider.setValue(3);
            }
        }
    }

    private class OptionSliderListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                questionAnswer[currentItemNumber-1] = (int) source.getValue();
            }
            //System.out.println(Arrays.toString(questionAnswer));
        }
    }

    private class SubmitButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt)  {
            //remove(tempPanel1);
            //remove(tempPanel2);
            //remove(centerPanel);
            frame.userSubmitted(userID, questionAnswer);
        }
    }

    private class LargeButtionListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            title.setFont(new Font("Serif", Font.BOLD, 25));
            label1.setFont(new Font(null,Font.PLAIN,15));
            label2.setFont(new Font(null,Font.PLAIN,15));
            label3.setFont(new Font(null,Font.PLAIN,15));
            label4.setFont(new Font(null,Font.PLAIN,15));
            label5.setFont(new Font(null,Font.PLAIN,15));
        }
    }

//    private class SmallButtionListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//            title.setFont(new Font("Serif", Font.BOLD, 15));
//            label1.setFont(new Font(null,Font.PLAIN,15));
//            label2.setFont(new Font(null,Font.PLAIN,15));
//            label3.setFont(new Font(null,Font.PLAIN,15));
//            label4.setFont(new Font(null,Font.PLAIN,15));
//            label5.setFont(new Font(null,Font.PLAIN,15));
//        }
//    }

}
