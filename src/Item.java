import java.util.ArrayList;
import java.util.Scanner;

public class Item {
    private String itemNumber;
    private String description;

    public Item(Scanner line){
        itemNumber=line.next();
        description=line.nextLine();
    }

    public String getItemNumber(){return itemNumber;}

    public String getDescription(){return description;}

    public String toString() {
        return  itemNumber;
    }

    //public String toString() {return description; }
}


