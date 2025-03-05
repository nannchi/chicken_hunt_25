import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class RunGame {
    ArrayList<Save> _saves = new ArrayList<Save>();
    static String csvFilePath = "ch_remastered/DATA/SAVEDATA.csv";
    public static void main(String[] args) throws IOException {
        FileWriter writer = new FileWriter(csvFilePath);
        writer.write("yo");
        writer.close();
         
    }

}
