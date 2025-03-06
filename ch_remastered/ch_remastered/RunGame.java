package ch_remastered;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RunGame {
    public static String curSave;
    public static ArrayList<String> saveDetails = new ArrayList<>();



    public static void main(String[] args) throws IOException {
        Scanner userInput = new Scanner(System.in);

        
        //newSave selected:
        //newSave(userInput.nextLine());
        //userInput.close();

        //loadSave selected:
        loadSave(userInput.nextLine());
        userInput.close();

         
    }

    /**
     * Creates a new save if the save name doesn't exist
     * @param name
     * @throws IOException
     */
    public static void newSave(String name) throws IOException {
        File newSave = new File("ch_remastered/SAVEDATA"+"/"+name+".txt");        
        if (!newSave.exists()) {
            newSave.createNewFile();
            System.out.println("file: ch_remastered/SAVEDATA"+"/"+name+".txt has been created");
            curSave = "ch_remastered/SAVEDATA"+"/"+name;
        }
        else {
            System.out.println("ERROR: file: ch_remastered/SAVEDATA"+"/"+name+".txt already exists\nPlease select load save to play this save.");
        }
    }

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
            } catch (FileNotFoundException e) {
                System.out.println("ERROR: file: ch_remastered/SAVEDATA"+"/"+name+".txt doesn't exists\nPlease select new save to play.");
            }
        }
    }
}
