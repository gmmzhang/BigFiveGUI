import javax.swing.*;
import java.io.FileNotFoundException;

public class Main {
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
