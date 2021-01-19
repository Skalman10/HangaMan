import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HängaGubbe {
    public static void main(String[] args) {
        Scanner ord = null;
        try {
            ord = new Scanner(new File("src","OrdLista"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
