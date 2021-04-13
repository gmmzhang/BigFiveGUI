import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Hashtable;

public class QuestionPanel extends JPanel {

    private ItemBank bank;
    private JLabel title;
    private JPanel titlePanel;
    private MainWindow frame;
    private String userID;
    private JSlider optionSlider;
    private JComboBox questionChooser;
    private JPanel bottomPanel;
    private JButton nextButton;;
    private int currentItemNumber;

    public QuestionPanel(MainWindow mainwindow, ItemBank itembank, String user) {
        frame = mainwindow;
        bank = itembank;
        userID = user;
        currentItemNumber = 1;

        setLayout(new BorderLayout());

        // NORTH
        titlePanel = new JPanel();
        //titlePanel.setOpaque(false);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));

        title = new JLabel("Question 1. In general, I am the life of the party.", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        // CENTER
        optionSlider = new JSlider(1, 5, 3);
        optionSlider.setMajorTickSpacing(1);
        optionSlider.setMinorTickSpacing(1);
        optionSlider.setPaintLabels(true);
        Hashtable<Integer, JLabel> table = new Hashtable<Integer, JLabel>();
        //table.put (1, new JLabel(new ImageIcon("yourFile.gif")));
        table.put (1, new JLabel("Strongly \nDisagree"));
        table.put (2, new JLabel("Somewhat \nDisagree"));
        table.put (3, new JLabel("Neither Agree \nnor Disagree"));
        table.put (4, new JLabel("Somewhat \nAgree"));
        table.put (5, new JLabel("Strongly \nAgree"));
        optionSlider.setLabelTable (table);
        add(optionSlider, BorderLayout.CENTER);


        // South
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        bottomPanel.setOpaque(false);

        nextButton = new JButton("Next question");
        nextButton.addActionListener(new nextButtonListener());
        //nextButton.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));

        questionChooser = new JComboBox();
        for ( int i =0; i<bank.items.size(); i++){
            questionChooser.addItem(bank.items.get(i));
            //System.out.println(bank.items.get(i).getItemNumber());
            //System.out.println(bank.items.get(i).getDescription());
        }
        questionChooser.addItemListener(new QuestionChooserListener());

        bottomPanel.add(nextButton);
        bottomPanel.add(questionChooser);
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
        }
    }

    private class nextButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evt)  {
            //System.out.println(questionChooser.getSelectedItem());
            if (currentItemNumber < 20) {
                title.setText(bank.items.get(currentItemNumber).getDescription());
                currentItemNumber += 1;
            }
        }
    }

}
