
public class Rot13 {
    static char abecedario[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    static char abecedarioMayuscula[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
    public static void main(String[] args) {
        dividirFrase();
    }

    public static void dividirFrase() {
        String frase = "Me llamo cristo";
        String fraseCifrada ="";
        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            String cambiado = xifraRot13(caracter, 13);
            fraseCifrada+=cambiado;
        }
        System.out.println(fraseCifrada);
    }

    public static String xifraRot13(char letra, int desplaçament) {
        if (Character.isUpperCase(letra)) {
            for (int i = 0; i < abecedarioMayuscula.length; i++) {
            if (letra == (abecedarioMayuscula[i])) {
                return Character.toString(abecedarioMayuscula[(i + desplaçament) % abecedarioMayuscula.length]);
            }
        }
        }
        else if(Character.isLowerCase(letra)){
            for (int i = 0; i < abecedario.length; i++) {
            if (letra == (abecedario[i])) {
                return Character.toString(abecedario[(i + desplaçament) % abecedario.length]);
            }
        }
        }
        return Character.toString(letra);
    }
}
