package iticbcn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class XifradorPolialfabetic {
 public static char[] alfabet = "AÀBCÇDEÉÈFGHIÍÏJKLMNÑOÓÒPQRSTUÚÜVWXYZ".toCharArray();
    public static Random random;
    public static String clauSecreta = "clau123"; 
    public static char[] alfabetPermutat;

    // Inicializa el random con la misma semilla para cifrar/descifrar
    public static void initRandom(String clau) {
        long seed = clau.hashCode();
        random = new Random(seed);
    }

    // Genera una permutación del alfabeto y la guarda en la variable global
    public void permutaAlfabet() {
        List<Character> llista = new ArrayList<>();
        for (char c : alfabet) llista.add(c);
        Collections.shuffle(llista, random);

        alfabetPermutat = new char[alfabet.length];
        for (int i = 0; i < alfabet.length; i++) alfabetPermutat[i] = llista.get(i);
    }

    // Cifra una cadena con el cifrado polialfabético
    public String xifraPoliAlfa(String msg) {
        StringBuilder resultat = new StringBuilder();

        for (char c : msg.toCharArray()) {
            boolean minus = Character.isLowerCase(c);
            char maj = Character.toUpperCase(c);

            // genera permutación diferente para cada letra
            permutaAlfabet();

            int idx = indexOf(alfabet, maj);
            if (idx != -1) {
                char xif = alfabetPermutat[idx];
                if (minus) xif = Character.toLowerCase(xif);
                resultat.append(xif);
            } else {
                resultat.append(c);
            }
        }
        return resultat.toString();
    }

    // Descifra una cadena polialfabética
    public String desxifraPoliAlfa(String msgXifrat) {
        StringBuilder resultat = new StringBuilder();

        for (char c : msgXifrat.toCharArray()) {
            boolean minus = Character.isLowerCase(c);
            char maj = Character.toUpperCase(c);

            // se genera la misma permutación gracias a la misma semilla
            permutaAlfabet();

            int idx = indexOf(alfabetPermutat, maj);
            if (idx != -1) {
                char desxif = alfabet[idx];
                if (minus) desxif = Character.toLowerCase(desxif);
                resultat.append(desxif);
            } else {
                resultat.append(c);
            }
        }
        return resultat.toString();
    }

    // Busca la posición de una letra en un array
    private static int indexOf(char[] array, char c) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == c) return i;
        }
        return -1;
    }

  
   
}
