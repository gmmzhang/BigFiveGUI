import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ItemBank bank = new ItemBank("Questions.txt");
        MainWindow window = new MainWindow(bank);
    }
}
