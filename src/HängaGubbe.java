import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HängaGubbe {
    public static void main(String[] args) {
        String ord = slumpaOrd();
        //Ett ord har nu blivit slumpat

        Scanner in = new Scanner(System.in);
        char[] out = new char[ord.length()];
        for (int i = 0; i < ord.length(); i++) {
            out[i] = '_';
        }
        // En char array som kommer vara output bestående av _

        int fel = 0;
        String guess = "";
        String felOut = "";
        boolean förlora = true;
        // Lite variabel deklarationer

        while (fel < 10) {
            // Nu börjar själva spelet i programmet
            System.out.println(Arrays.toString(out));
            guess = in.next();
            guess = guess.toLowerCase();
            // Läser in gissningen
            if (!ord.contains(guess)) {
                fel++;
                felOut += guess + " ";
            }
            // Om ordet inte innehåller gissningen så får man +1 fel och gissningen sparas
            else {
                if (guess.length() == 1) {
                    rättGissning(out,ord,guess);
                }
                // Om ordet innehåller gissningen och består av 1 character
                // så kommer den att byta ut alla _ med gissningen

                if (guess.equals(ord) || !Arrays.toString(out).contains("_")) {
                    System.out.println("ordet var "+ord);
                    System.out.println("Du vann och hade så här många fel " + fel);
                    förlora = false;
                    break;
                }
                // Om gissningen är samma som ordet så har du vunnit

            }
            System.out.println(felOut);
        }
        if (förlora) {
            System.out.println("Du förlorade :) och ordet var "+ord);
        }
        // Om du inte lyckats gissa rätt på 10 försök så har du förlorat

    }

    private static void rättGissning(char[] out, String ord, String guess) {
        for (int i = 0; i < ord.length(); i++) {
            if (guess.equals(ord.charAt(i) + "")) {
                out[i] = ord.charAt(i);
            }
        }
        return;
    }

    private static String slumpaOrd() {
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
            assert lista != null;
            ord = lista.next();
        }
        return ord;
    }
}
