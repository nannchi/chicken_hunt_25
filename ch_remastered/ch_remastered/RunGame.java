package ch_remastered;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class RunGame {

    /*************STATIC VARS**************/
        public static String curSave;





    /*************METHODS**************/

        /**
         * Creates a new save if the save name doesn't exist
         * @param name name of file
         * @throws IOException
         */
        public static String newSave(String name) throws IOException {
            File newSave = new File("ch_remastered/SAVEDATA"+"/"+name+".chickgfs"); //new file objects

            //checks whether a the save exists then creates the save or loads the SAVEDATA
            if (!newSave.exists()) {
                newSave.createNewFile();

                /**DEBUG 
                System.out.println("file: ch_remastered/SAVEDATA"+"/"+name+".chickgfs has been created");
                **/
            } else {
                RunGame.loadSave(curSave);
            }
            RunGame.curSave = "ch_remastered/SAVEDATA"+"/"+name+".chickgfs"; //updates curSave
            return curSave;
        }

        /** NOTE: FIX LATER
         * loads a save file
         * @param name name of file
         * @throws FileNotFoundException 
         */
        public static void loadSave(String name) throws FileNotFoundException {
            //GameData.parseFile(new File(name));
        }

        /**
         * updates savefile
         */
        public static void saveProgress(){
            String saveDetails = GameData.toFile(); //converts the GameData to a string

            FileWriter f; //creates a fileWriter to write the data on the file

            //file writer writes on the file and adds the gamecode
            try {
                f = new FileWriter(new File(curSave)); 
                f.append(saveDetails);

                f.close(); //closes file writer
            } catch (IOException e) {
                System.out.println("Fatal Error: Save did not work");
            }
        }
}
