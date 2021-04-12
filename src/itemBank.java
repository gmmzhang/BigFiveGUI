import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class itemBank {

    ArrayList<Item> items;

    public itemBank(String fileName) throws FileNotFoundException{
        items = new ArrayList<Item>();
        try {
            Scanner input = new Scanner(new File(fileName));
            loadItem(input);
        } catch (FileNotFoundException e) {
            System.err.println("Could not find file: " + fileName);
            throw e;
        }
    }

    private void loadItem(Scanner input) {
        while (input.hasNextLine()){
            String line = input.nextLine();
            Scanner scannerLine = new Scanner(line);
            Item item = new Item(scannerLine);
            items.add(item);
            //System.out.println(item.getDescription());
        }
    }

}
