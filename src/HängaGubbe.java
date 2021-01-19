import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class HängaGubbe {
    public static void main(String[] args) {
        Scanner lista = null;
        try {
            lista = new Scanner(new File("src","OrdLista"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Random rand = new Random();
        int N = rand.nextInt(5) + 1;
        String ord ="";
        for (int i =0;i<N;i++) {
            ord = lista.next();
        }
        Scanner in = new Scanner(System.in);
        String guess ="";
        String out = "";
        int fel =0;
        for (int e = 0;e<ord.length();e++) {
            out+="_";
        }
        System.out.println(out);
        while (fel<10) {
            guess=in.next();
            guess = guess.toLowerCase();
            if (guess.equals(ord)) {
                System.out.println(ord);
                System.out.println("Du hade så här många fel "+fel);
                break;
            }
        }
    }
}
