import java.util.Scanner;

public class Rot13 { 
    //arrays de abecedario global
    static char abecedario[] = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
            'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
    static char abecedarioMayuscula[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //boolean para controlar la ejecución
        boolean salir = false;
        while (!salir) {
            System.out.print("¿Que vols fer? (xifrar/desxifrar/sortir): ");
            String opcion = scanner.nextLine().trim().toLowerCase();
            if (opcion.equals("sortir")) {
                salir = true;
                System.out.println("Fins aviat!!!!");
            } else if (!opcion.equals("xifrar") && !opcion.equals("desxifrar")) {
                System.out.println("Opció no valida. Intenta de nou.");
                continue;
            } else {
                System.out.print("Introdueix una frase: ");
                String frase = scanner.nextLine();
                String resultado = cambiarFrase(frase, opcion);// llama a la función 
                System.out.println("Resultat: " + resultado);
            }
        }
    }

    public static String cambiarFrase(String frase, String modo) {
        String fraseCambiada = "";
        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            if (modo.equals("xifrar")) {
                String cambiado = xifraRot13(caracter, 13);
                fraseCambiada += cambiado;
            } else if (modo.equals("desxifrar")) {
                String cambiado = desxifraRot13(caracter, 13);
                fraseCambiada += cambiado;
            }
        }
        return fraseCambiada;
    }

    public static String xifraRot13(char letra, int desplaçament) {
        char tipoAbecedario[] = abecedario;
        String resultado = "";
        if (Character.isUpperCase(letra)) {
            tipoAbecedario = abecedarioMayuscula;
        }
        for (int i = 0; i < tipoAbecedario.length; i++) {
            if (letra == (tipoAbecedario[i])) {
                resultado = Character.toString(tipoAbecedario[(i + desplaçament) % tipoAbecedario.length]);
            }
        }
        return resultado;
    }

    public static String desxifraRot13(char letra, int desplaçament) {
        char tipoAbecedario[] = abecedario;
        String resultado = "";
        if (Character.isUpperCase(letra)) {
            tipoAbecedario = abecedarioMayuscula;
        }
        for (int i = 0; i < tipoAbecedario.length; i++) {
            if (letra == (tipoAbecedario[i])) {
                resultado= Character
                        .toString(tipoAbecedario[(i - desplaçament + tipoAbecedario.length) % tipoAbecedario.length]);
            }
        }
        return resultado;
    }
}
