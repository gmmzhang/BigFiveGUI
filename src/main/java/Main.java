import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ItemBank bank = new ItemBank("C:\\Users\\Mingjia\\IdeaProjects\\jchart\\src\\Questions.txt");
        MainFrame window = new MainFrame(bank);
    }
}
