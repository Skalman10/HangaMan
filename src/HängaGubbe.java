import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HängaGubbe {
    public static void main(String[] args) {
        Scanner ord = null;
        try {
            ord = new Scanner(new File("src","OrdLista"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        int N = rand.nextInt(5) + 1;
    }
}
