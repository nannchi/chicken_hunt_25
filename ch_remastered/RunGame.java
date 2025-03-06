
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class RunGame {
    public String curSave;
    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);
        System.out.println(newSave(userInput.nextLine()) + " Created");
        userInput.close();
         
    }

    public static String newSave(String name) throws IOException {
        File newSave = new File("ch_remastered/SAVEDATA"+"/"+name+".txt");        
        if (!newSave.exists()) {
            newSave.createNewFile();
            return "ch_remastered/SAVEDATA"+"/"+name+".txt";
        }
        else {
            System.out.println("Save exists");
            return "ch_remastered/SAVEDATA"+"/"+name+".txt";
        }
    }

}
