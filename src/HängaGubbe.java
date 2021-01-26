import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
        //Ett ord har nu blivit slumpat
        Scanner in = new Scanner(System.in);
        String guess ="";
        char[] out = new char[ord.length()];
        for (int i = 0;i<ord.length();i++) {
            out[i] = '-';
        }
        int fel =0;
        String felOut = "";
        System.out.println(out);
        while (fel<10) {
            guess=in.next();
            guess = guess.toLowerCase();
            if (guess.equals(ord)) {
                System.out.println(ord);
                System.out.println("Du hade så här många fel "+fel);
                break;
            } else if (!ord.contains(guess)) {
                fel++;
                felOut += guess+" ";
            } else {
                for (int i = 0;i<ord.length();i++) {
                    if (guess.equals(ord.charAt(i)+"")) {
                        out[i]=ord.charAt(i);
                    }
                }
            }
            System.out.printf(Arrays.toString(out));
            System.out.println(felOut);
        }
    }
}
