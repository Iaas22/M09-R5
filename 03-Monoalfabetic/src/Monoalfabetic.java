import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Monoalfabetic {
       public static char[] abecedarioMayuscula = "AÀBCÇDEÉÈFGHIÍÏJKLMNÑOÓÒPQRSTUÚÜVWXYZ".toCharArray();       

public static char[] permutaAlfabet(char[] alfabet) {
        List<Character> listaCharacters = new ArrayList<Character>
        ();
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
        System.out.print("Abecedario cambiado: ");
        for (char c : listaCharacters) {
            System.out.print(c);
        }
        System.out.println();
        Collections.shuffle(listaCharacters);
        char[] permutado = new char[alfabet.length];
        for (int i = 0; i < alfabet.length; i++) {
            permutado[i] = listaCharacters.get(i);
        }
        return permutado;

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
