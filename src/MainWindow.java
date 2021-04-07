import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;

public class MainWindow extends JFrame {

    private itemBank bank;
    private JLabel title;

    public MainWindow(itemBank bank){

        super("mini Big Five personality assessment");
        this.bank = bank;
        setSize(1000,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color backgroundColor = new Color(153,204,255);
        getContentPane().setBackground(backgroundColor);
        getContentPane().setLayout(new BorderLayout());

        title = new JLabel("Question 1. Am the life of the party.", SwingConstants.CENTER);
        title.setFont(new Font("Serif", Font.BOLD, 20));
        //title.setBorder(BorderFactory.createEmptyBorder(100,0,0,0));
        add(title, BorderLayout.NORTH);

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

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        bottomPanel.setOpaque(false);

        JButton nextButton = new JButton("Next question");
        nextButton.setBorder(BorderFactory.createEmptyBorder(0,100,0,100));

        JComboBox questionChooser = new JComboBox();
        for ( int i =0; i<bank.items.size(); i++){
            questionChooser.addItem(bank.items.get(i));
            //System.out.println(bank.items.get(i).getItemNumber());
            //System.out.println(bank.items.get(i).getDescription());
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

    public static void main(String[] args) throws FileNotFoundException {
//        MainWindow window = new MainWindow();
        try {
            itemBank bank = new itemBank("Questions");
            MainWindow window = new MainWindow(bank);

        }catch (FileNotFoundException e){
            JOptionPane optionPane = new JOptionPane("Could not find the file.", JOptionPane.ERROR_MESSAGE);
            JDialog dialog = optionPane.createDialog("Error!!");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
        }
    }

}
