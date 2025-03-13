package ch_remastered;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class GameData {

    /*************STATIC VARS**************/

        private static String playerName;
        private static int level = 1;
        private static int exp = 0;
        private static int monies = 500;
        private static int chickens = 1;
        private static int pacer = 0;





    /*************SAVE/LOAD METHODS**************/

        /**
         * turns a file into code
         * @param x
         * @throws FileNotFoundException
         */
        public static void parseFile(File x) throws FileNotFoundException {
            Scanner yo = new Scanner(x); //Scanner to read file

            ArrayList<String> hold = new ArrayList<String>(); //array that holds each file line as a separate object, making it easier to parse
            while (yo.hasNextLine()) {
                hold.add(yo.nextLine());
            }

            /** DEBUGGING
            for (String h : hold) {
                System.out.println(h);
            }

            if (hold.size() < 6) {
                System.out.println("Error: The file format is incorrect or missing data.");
            }**/

            //parses each individual line
            playerName = hold.get(0).substring(hold.get(0).indexOf(":") + 1);
            level = Integer.parseInt(hold.get(1).substring(hold.get(1).indexOf(":") + 1));
            exp = Integer.parseInt(hold.get(2).substring(hold.get(2).indexOf(":") + 1));
            monies = Integer.parseInt(hold.get(3).substring(hold.get(3).indexOf(":") + 1));
            chickens = Integer.parseInt(hold.get(4).substring(hold.get(4).indexOf(":") + 1));
            pacer = Integer.parseInt(hold.get(5).substring(hold.get(5).indexOf(":") + 1));

            yo.close(); //closes the scanner
        }

        /**
         * turns code into string for a file
         * @return
         */
        public static String toFile() {
            String s = "";//concatenator string

            //turns each class variable into a line in a .chickgfs file
            s += "playerName:" + playerName + "\n";
            s += "level:" + level + "\n";
            s += "exp:" + exp + "\n";
            s += "monies:" + monies + "\n";
            s += "chickens:" + chickens + "\n";
            s += "pacer:" + pacer + "\n";
            
            return s;
        }





    /*************SETTERS, GETTERS, AND MORE**************/

        {/* PLAYER METHODS */}
            /**
             * gets playername
             * @return farmer's name
             */
            public static String getPlayerName() {
                return playerName;
            }

            /**
             * sets playername
             * @param playerName farmer's name
             */
            public static void setPlayerName(String playerName) {
                GameData.playerName = playerName;
            }
        
        {/* LEVEL METHODS */}
            /**
             * gets level
             * @return farm level
             */
            public static int getLevel() {
                return level;
            }

            /**
             * sets level
             * @param level farm level
             */
            public static void setLevel(int level) {
                GameData.level = level;
            }

            /**
             * increases the level by 1
             */
            public static void incLevel() {
                GameData.level++;
            }

        {/* EXP METHODS */}
            /**
             * gets experience
             * @return farmer experience pts
             */
            public static int getExp() {
                return exp;
            }

            /**
             * sets experience
             * @param exp farmer experience pts
             */
            public static void setExp(int exp) {
                GameData.exp = exp;
            }

            /**
             * increases the experience and automatically checks to see whether the level should increase
             * @param incBy integer number to increase the experience by
             */
            public static void incExp(int incBy) {
                GameData.exp += incBy;
                if (GameData.exp >= 100) {
                    GameData.incLevel(); //1 to 2
                }
                if (GameData.exp >= 300) {
                    GameData.incLevel(); //2 to 3
                }
                //only a demo, maybe more levels in the future
            }

        {/* PLAYER METHODS */}
            /**
             * gets monies
             * @return farmer's cash
             */
            public static int getMonies() {
                return monies;
            }

            /**
             * sets monies
             * @param monies farmer's cash
             */
            public static void setMonies(int monies) {
                GameData.monies = monies;
            }

            /**
             * increases the monies
             * @param incBy number to increase the amount of monies by
             */
            public static void incMonies(int incBy) {
                GameData.monies += incBy;
            }

        {/* CHICKEN METHODS */}

            /**
             * gets chickens
             * @return chicken amount
             */
            public static int getChickens() {
                return chickens;
            }

            /**
             * sets chickens
             * @param chickens chicken amount
             */
            public static void setChickens(int chickens) {
                GameData.chickens = chickens;
            }

            /**
             * increases the chickens
             * @param incBy number to increase the amount of chickens by
             */
            public static void incChickens(int incBy) {
                GameData.chickens += incBy;
            }

        {/* PACER METHODS */}

            /**
             * gets pacer for level
             * @return pacer
             */
            public static int getPacer() {
                return pacer;
            }

            /**
             * sets pacer for level
             * @param pacer number referring to what dialoguebox you're at
             */
            public static void setPacer(int pacer) {
                GameData.pacer = pacer;
            }

            /**
             * increases the pacer by 1
             */
            public static void incPacer() {
                GameData.pacer++;
            }
}