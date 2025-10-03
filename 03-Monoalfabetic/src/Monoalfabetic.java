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


public static String [] xifraMonoAlfa(String [] cadena) {
    

    return null;
}





public static char[] desxifraMonoAlfa(char[]cadena){

return null;
}






    public static void main(String[] args) {
        permutaAlfabet(abecedarioMayuscula);
    }
}
