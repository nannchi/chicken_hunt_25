package ch_remastered;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RunGame {
    public static String curSave;
    public static ArrayList<String> saveDetails = new ArrayList<>();

    /**
     * Creates a new save if the save name doesn't exist
     * @param name name of file
     * @throws IOException
     */
    public static void newSave(String name) throws IOException {
        File newSave = new File("ch_remastered/SAVEDATA"+"/"+name+".txt");        
        if (!newSave.exists()) {
            newSave.createNewFile();
            System.out.println("file: ch_remastered/SAVEDATA"+"/"+name+".txt has been created");
            curSave = "ch_remastered/SAVEDATA"+"/"+name+".txt";
        }
        else {
            System.out.println("ERROR: file: ch_remastered/SAVEDATA"+"/"+name+".txt already exists\nPlease select load save to play this save.");
        }
    }

    /**
     * loads a save file
     * @param name name of file
     */
    public static void loadSave(String name) {
        File saveFile = new File("ch_remastered/SAVEDATA"+"/"+name+".txt"); 
        if (!saveFile.exists()) {
            Scanner fileReader;
            try {
                fileReader = new Scanner(saveFile);
                while (fileReader.hasNext()) {
                    saveDetails.add(fileReader.next());
                }
                for (String bool : saveDetails) {
                    System.out.println(bool);
                }
                fileReader.close();
                curSave = "ch_remastered/SAVEDATA"+"/"+name+".txt";
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: file: ch_remastered/SAVEDATA"+"/"+name+".txt doesn't exists\nPlease select new save to play.");
            }
        }
    }

    /**
     * updates savefile
     */
    public static void saveProgress(){
        FileWriter f;
        try {
            f = new FileWriter(new File(curSave));
            for (String string : saveDetails) {
                try {
                    f.append(string + " ");
                } catch (IOException e) {
                    System.out.println("FATAL ERROR, not able to save");
                }
                
            }
                f.close();
        } catch (IOException e) {
            System.out.println("Fatal Error: Save did not work");
        }
    }
}
