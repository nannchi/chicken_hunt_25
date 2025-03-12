package ch_remastered;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class RunGame {
    public static String curSave;

    /**
     * Creates a new save if the save name doesn't exist
     * @param name name of file
     * @throws IOException
     */
    public static String newSave(String name) throws IOException {
        File newSave = new File("ch_remastered/SAVEDATA"+"/"+name+".txt");        
        if (!newSave.exists()) {
            newSave.createNewFile();
            System.out.println("file: ch_remastered/SAVEDATA"+"/"+name+".txt has been created");
            curSave = "ch_remastered/SAVEDATA"+"/"+name+".txt";

        }
        else {
            curSave = "ch_remastered/SAVEDATA"+"/"+name+".txt";
            loadSave(curSave);
        }
        return curSave;
    }

    /**
     * loads a save file
     * @param name name of file
     * @throws FileNotFoundException 
     */
    public static void loadSave(String name) throws FileNotFoundException {
        GameData.parseFile(new File(name));
    }

    /**
     * updates savefile
     */
    public static void saveProgress(){
        String saveDetails = GameData.toFile();
        FileWriter f;
        try {
            f = new FileWriter(new File(curSave));
            f.append(saveDetails);
                f.close();
        } catch (IOException e) {
            System.out.println("Fatal Error: Save did not work");
        }
    }
}
