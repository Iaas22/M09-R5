
public class Rot13 {
    static char abecedario[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    static char abecedarioMayuscula[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    public static void main(String[] args) {
        String frase = "FGH";
        String Ejemplo = dividirFrase(frase,"cifrar");
        System.out.println(Ejemplo);
    }

    public static String dividirFrase(String frase,String modo) {
        String fraseCambiada = "";
        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            if (modo.equals("cifrar")) {
                String cambiado = xifraRot13(caracter, 13);
            fraseCambiada += cambiado;
            }
            else if(modo.equals("descifrar")){
            String cambiado = desxifraRot13(caracter, 13);
            fraseCambiada += cambiado;
            }
        }
        return fraseCambiada;
    }

    public static String xifraRot13(char letra, int desplaçament) {
        char tipoAbecedario[] = abecedario;
        if (Character.isUpperCase(letra)) {
            tipoAbecedario = abecedarioMayuscula;
        }
            for (int i = 0; i < tipoAbecedario.length; i++) {
                if (letra == (tipoAbecedario[i])) {
                    return Character.toString(tipoAbecedario[(i + desplaçament) % tipoAbecedario.length]);
                }
            }
         
        return Character.toString(letra);
    }

    public static String desxifraRot13(char letra, int desplaçament) {
        char tipoAbecedario[] = abecedario;
        if (Character.isUpperCase(letra)){
            tipoAbecedario = abecedarioMayuscula;
        }
            for (int i = 0; i < tipoAbecedario.length; i++) {
                if (letra == (tipoAbecedario[i])) {
                    return Character.toString(tipoAbecedario[(i - desplaçament+tipoAbecedario.length) % tipoAbecedario.length]);
                }
            }
        return Character.toString(letra);
    }
}
