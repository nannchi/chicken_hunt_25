import java.io.IOException;
import java.util.Scanner;
import ch_remastered.RunGame;

public class RunGameTests{
    
    public static void main(String[] args) throws IOException {
        System.out.println("TESTS newSave(String name)");
        Scanner userInput = new Scanner(System.in);

        //newSave selected:
        RunGame.newSave(userInput.nextLine());
        userInput.close();
    }
}
