import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monoalfabetic {
       public static char[] abecedarioMayuscula = "AÀBCÇDEÉÈFGHIÍÏJKLMNÑOÓÒPQRSTUÚÜVWXYZ".toCharArray();       
public static char[] abecedarioPermutado = null;


public static char[] permutaAlfabet(char[] alfabet) {
    List<Character> listaCharacters = new ArrayList<Character>();
    for (char c : alfabet) {
        listaCharacters.add(c);
    }
    // Imprimir abecedario original
    System.out.print("Abecedario original: ");
    for (char c : alfabet) {
        System.out.print(c);
    }
    System.out.println();

    // Imprimir abecedario cambiado
    Collections.shuffle(listaCharacters);
    System.out.print("Abecedario permutado: ");
    for (char c : listaCharacters) {
        System.out.print(c);
    }
    System.out.println();

    char[] permutado = new char[alfabet.length];
    for (int i = 0; i < alfabet.length; i++) {
        permutado[i] = listaCharacters.get(i);
    }

    // Guardar el abecedario permutado en la variable estática
    abecedarioPermutado = permutado;

    return permutado;
}

//obtener el abecedario permutado guardado
public static char[] getAbecedarioPermutado() {
    return abecedarioPermutado;
}

public static String[] xifraMonoAlfa(String[] cadena) {
    if (abecedarioPermutado == null) {
        permutaAlfabet(abecedarioMayuscula);
    }
    String[] resultat = new String[cadena.length];
    for (int i = 0; i < cadena.length; i++) {
        char[] chars = cadena[i].toCharArray();
        for (int k = 0; k < chars.length; k++) {
            int idx = -1;
            for (int j = 0; j < abecedarioMayuscula.length; j++) {
                if (abecedarioMayuscula[j] == chars[k]) {
                    idx = j;
                    break;
                }
            }
            if (idx != -1) {
                chars[k] = abecedarioPermutado[idx];
            }
            // Si no está en el alfabeto, se deja igual
        }
        resultat[i] = new String(chars);
    }
    return resultat;
}





public static String[] desxifraMonoAlfa(String[] cadena) {
    if (abecedarioPermutado == null) {
        permutaAlfabet(abecedarioMayuscula);
    }
    String[] resultat = new String[cadena.length];
    for (int i = 0; i < cadena.length; i++) {
        char[] chars = cadena[i].toCharArray();
        for (int k = 0; k < chars.length; k++) {
            int idx = -1;
            for (int j = 0; j < abecedarioPermutado.length; j++) {
                if (abecedarioPermutado[j] == chars[k]) {
                    idx = j;
                    break;
                }
            }
            if (idx != -1) {
                chars[k] = abecedarioMayuscula[idx];
            }
            // Si no está en el abecedario permutado, se deja igual
        }
        resultat[i] = new String(chars);
    }
    return resultat;
}


public static void main(String[] args) {
    permutaAlfabet(abecedarioMayuscula);

    String[] textos = {"Hola", "Món", "Àlbum", "çÇ"};
    String[] xifrat = xifraMonoAlfa(textos);
    System.out.println("Text xifrat:");
    for (String s : xifrat) {
        System.out.println(s);
    }

    String[] desxifrat = desxifraMonoAlfa(xifrat);
    System.out.println("Text desxifrat:");
    for (String s : desxifrat) {
        System.out.println(s);
    }
}
}
