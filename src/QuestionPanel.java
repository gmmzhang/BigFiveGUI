import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.Hashtable;

public class QuestionPanel extends JFrame {

    private itemBank bank;
    private JLabel title;
    private JPanel titlePanel;

    public QuestionPanel(itemBank bank){

        super("Big Five Personality Assessment");
        this.bank = bank;
        setSize(1000,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color backgroundColor = new Color(153,204,255);
        getContentPane().setBackground(backgroundColor);
        getContentPane().setLayout(new BorderLayout());


        // NORTH
        titlePanel = new JPanel();
        titlePanel.setOpaque(false);
        titlePanel.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        title = new JLabel("Question 1. In general, I am the life of the party.", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        //title.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        //add(title, BorderLayout.NORTH);
        titlePanel.add(title);
        add(titlePanel, BorderLayout.NORTH);

        // CENTER
        /*
        JRadioButton option1Button = new JRadioButton("Yes");
        //option1Button.setMnemonic(KeyEvent.VK_C);
        //option1Button.setActionCommand(catString);

        JRadioButton option2Button = new JRadioButton("No");

        ButtonGroup group = new ButtonGroup();
        group.add(option1Button);
        group.add(option2Button);

        JPanel middlePanel = new JPanel();
        middlePanel.setLayout(new GridLayout(1,0));
        middlePanel.setBorder(BorderFactory.createEmptyBorder(90,100,90,100));
        middlePanel.add(option1Button);
        middlePanel.add(option2Button);
        add(middlePanel, BorderLayout.CENTER);
        middlePanel.setOpaque(false);
         */

        JSlider optionSlider = new JSlider(1, 5, 3);
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
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        bottomPanel.setOpaque(false);

        JButton nextButton = new JButton("Next question");
        nextButton.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));

        JComboBox questionChooser = new JComboBox();
        for ( int i =0; i<bank.items.size(); i++){
            questionChooser.addItem(bank.items.get(i));
            System.out.println(bank.items.get(i).getItemNumber());
            System.out.println(bank.items.get(i).getDescription());
        }
        questionChooser.addItemListener(new questionChooserListener());

        add(nextButton, BorderLayout.EAST);
        add(questionChooser,BorderLayout.WEST);
        bottomPanel.add(nextButton);
        bottomPanel.add(questionChooser);
        add(bottomPanel,BorderLayout.SOUTH);

        setVisible(true);

    }

    private class questionChooserListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent e) {
            JComboBox selector = (JComboBox) e.getSource();
            Item selectedItem = (Item) selector.getSelectedItem();
            title.setText(selectedItem.getDescription());
        }
    }


}
