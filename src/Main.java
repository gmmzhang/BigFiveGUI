import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        itemBank bank = new itemBank("Questions.txt");
        MainWindow window = new MainWindow(bank);
    }
}
