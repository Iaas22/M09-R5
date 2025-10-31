package iticbcn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class XifradorMonoalfabetic {
      public static char[] abecedariMayuscula = "AÀBCÇDEÉÈFGHIÍÏJKLMNÑOÓÒPQRSTUÚÜVWXYZ".toCharArray();
    public static char[] abecedariPermutat = null;

    //genera permutación y la devuelve
    public static char[] permutaAlfabet(char[] alfabet) {
        List<Character> llista = new ArrayList<>();
        for (char c : alfabet) {
            llista.add(c);
        }

        System.out.print("Abecedari original: ");
        for (char c : alfabet) System.out.print(c);
        System.out.println();

        Collections.shuffle(llista); 

        System.out.print("Abecedari permutat: ");
        for (char c : llista) System.out.print(c);
        System.out.println();

        char[] permutat = new char[alfabet.length];
        for (int i = 0; i < alfabet.length; i++) {
            permutat[i] = llista.get(i);
        }

        abecedariPermutat = permutat;
        return permutat;
    }

    //cifra 
    public String xifraMonoAlfa(String cadena) {
        if (abecedariPermutat == null) {
            permutaAlfabet(abecedariMayuscula);
        }

        String resultat = "";

        for (char c : cadena.toCharArray()) {
            boolean esMinuscula = Character.isLowerCase(c);
            char lletraMaj = Character.toUpperCase(c);
            int idx = -1;

            //busca la letra en abecedario
            for (int i = 0; i < abecedariMayuscula.length; i++) {
                if (abecedariMayuscula[i] == lletraMaj) {
                    idx = i;
                    break;
                }
            }

            if (idx != -1) {
                char xifrat = abecedariPermutat[idx];
                //mantiene caso original
                if (esMinuscula) {
                    xifrat = Character.toLowerCase(xifrat);
                }
                resultat += xifrat;
            } else {
                //si no está en el abecedario 
                resultat += c;
            }
        }

        return resultat;
    }

    //descifra
    public String desxifraMonoAlfa(String cadena) {
        if (abecedariPermutat == null) {
            permutaAlfabet(abecedariMayuscula);
        }

        String resultat = "";

        for (char c : cadena.toCharArray()) {
            boolean esMinuscula = Character.isLowerCase(c);
            char lletraMaj = Character.toUpperCase(c);
            int index = -1;

            //busca le letra en abecedario permutado
            for (int i = 0; i < abecedariPermutat.length; i++) {
                if (abecedariPermutat[i] == lletraMaj) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                char desxifrat = abecedariMayuscula[index];
                if (esMinuscula) {
                    desxifrat = Character.toLowerCase(desxifrat);
                }
                resultat += desxifrat;
            } else {
                resultat += c;
            }
        }

        return resultat;
    }

   
}
