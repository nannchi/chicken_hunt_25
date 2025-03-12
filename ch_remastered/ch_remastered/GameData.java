package ch_remastered;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GameData {
    private static String playerName;
    private static int level;
    private static int exp;
    private static int monies;
    private static int chickens;
    private static int pacer;

    public GameData(String pn, int l, int e, int m, int c, int p) {
        playerName = pn;
        level = l;
        exp = e;
        monies = m;
        chickens = c;
        pacer = p;
    }

    public static void parseFile(File x) throws FileNotFoundException {
        Scanner yo = new Scanner(x);
        ArrayList<String> hold = new ArrayList<String>();
        while (yo.hasNextLine()) {
            hold.add(yo.nextLine());
        }
        for (String h : hold) {
            System.out.println(h);
        }
        if (hold.size() < 6) {
            System.out.println("Error: The file format is incorrect or missing data.");
        }


        playerName = hold.get(0).substring(hold.get(0).indexOf(":") + 1);


        level = Integer.parseInt(hold.get(1).substring(hold.get(1).indexOf(":") + 1));

        exp = Integer.parseInt(hold.get(2).substring(hold.get(2).indexOf(":") + 1));

        monies = Integer.parseInt(hold.get(3).substring(hold.get(3).indexOf(":") + 1));

        chickens = Integer.parseInt(hold.get(4).substring(hold.get(4).indexOf(":") + 1));

        pacer = Integer.parseInt(hold.get(5).substring(hold.get(5).indexOf(":") + 1));


        yo.close();
    }

    @Override
    public String toString() {
        String s ="playerName:" + playerName + "\n";
        s +="level:" + level + "\n";
        s +="exp:" + exp + "\n";
        s +="monies:" + monies + "\n";
        s +="chickens:" + chickens + "\n";
        s +="pacer:" + pacer + "\n";
        return s;
    }
}
