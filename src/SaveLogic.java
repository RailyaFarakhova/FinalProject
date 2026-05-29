import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class SaveLogic {
    File file = new File("save.tsv");
    BookLogic catalog = new BookLogic();

    public boolean isSaved(){
        if(file.exists()){
            return true;
        } else {
            return false;
        }
    }

    public void load(){
        if(isSaved()){
            catalog.importBooksTSV("save.tsv");
        }
    }

    public void save(){
        try {
            FileWriter writer = new FileWriter("save.tsv");
            writer.write(catalog.getCollection().toString());
            writer.close();
        } catch (Exception e){
            System.out.println("Error saving file.");
        }
    }
}
