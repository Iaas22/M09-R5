import java.util.Scanner;

public class VersioAlternativa { 
    //arrays de abecedario global
    static char[] abecedario = {
    'a', 'à', 'b', 'c', 'ç', 'd', 'e', 'é', 'è',
    'f', 'g', 'h', 'i', 'í', 'ï', 'j', 'k', 'l', 'm', 'n', 'ñ',
    'o', 'ó', 'ò', 'p', 'q', 'r', 's', 't',
    'u', 'ú', 'ü', 'v', 'w', 'x', 'y', 'z'
};
    static char[] abecedarioMayuscula = {
    'A', 'À', 'B', 'C', 'Ç', 'D', 'E', 'É', 'È',
    'F', 'G', 'H', 'I', 'Í', 'Ï', 'J', 'K', 'L', 'M', 'N', 'Ñ',
    'O', 'Ó', 'Ò', 'P', 'Q', 'R', 'S', 'T',
    'U', 'Ú', 'Ü', 'V', 'W', 'X', 'Y', 'Z'
};


public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
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
            String resultado = "";
            
            if (opcion.equals("xifrar")) {
                resultado = xifraRot13(frase);
            } else if (opcion.equals("desxifrar")) {
                resultado = desxifraRot13(frase);
            }
            
            System.out.println("Resultat: " + resultado);
        }
    }
    scanner.close();
}


    public static String xifraRot13(String frase) {
        String fraseCifrada = "";
    for (int i = 0; i < frase.length(); i++) {
        char caracter = frase.charAt(i);
        String cambiado = xifrar(caracter, 13);
        fraseCifrada += cambiado;
    }
    return fraseCifrada;
    }
public static String desxifraRot13(String frase) {
    String fraseDescifrada = "";
    for (int i = 0; i < frase.length(); i++) {
        char caracter = frase.charAt(i);
        String cambiado = desxifrar(caracter, 13);
        fraseDescifrada += cambiado;
    }
    return fraseDescifrada;
}

    public static String xifrar(char letra, int desplaçament) {
        char tipoAbecedario[] = abecedario;
        String resultado = "";
        if (Character.isUpperCase(letra)) {
            tipoAbecedario = abecedarioMayuscula;
        }
        else if(!Character.isUpperCase(letra)&&!Character.isLowerCase(letra)){
            return Character.toString(letra);
        }
        for (int i = 0; i < tipoAbecedario.length; i++) {
            if (letra == (tipoAbecedario[i])) {
                resultado = Character.toString(tipoAbecedario[(i + desplaçament) % tipoAbecedario.length]);
            }
        }
        return resultado;
    }

    public static String desxifrar(char letra, int desplaçament) {
        char tipoAbecedario[] = abecedario;
        String resultado = "";
        if (Character.isUpperCase(letra)) {
            tipoAbecedario = abecedarioMayuscula;
        }
        else if(!Character.isUpperCase(letra)&&!Character.isLowerCase(letra)){
            return Character.toString(letra);
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
