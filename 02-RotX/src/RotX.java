
public class RotX  {
    public static char[]abecedarioMinuscula = "aàbcçdeéèfghiíïjklmnñoóòpqrstuúüvwxyz".toCharArray();
    public static char[]abecedarioMayuscula = "AÀBCÇDEÉÈFGHIÍÏJKLMNÑOÓÒPQRSTUÚÜVWXYZ".toCharArray();

    
public static void main(String[] args) {
    String frase = "Hola, què tal?";
    String resultadoXifrada = xifraRotX(frase, 13);
    System.out.println("Frase xifrada: " + resultadoXifrada);

    String resultadoDesxifrada = desxifraRotX(resultadoXifrada, 13);
    System.out.println("Frase desxifrada: " + resultadoDesxifrada);
}

public static String xifraRotX ( String cadena, int desplaçament) {
    String resultado = "";
    for (int i = 0; i < cadena.length(); i++) {
        char c = cadena.charAt(i);
        boolean encontrado = false;
        for (int j = 0; j < abecedarioMinuscula.length; j++) {
            if (c == abecedarioMinuscula[j]) {
                int index = (j + desplaçament) % abecedarioMinuscula.length;
                resultado += abecedarioMinuscula[index];
                encontrado = true;
                break;
            }
        }
        if (encontrado) continue;
        for (int j = 0; j < abecedarioMayuscula.length; j++) {
            if (c == abecedarioMayuscula[j]) {
                int index = (j + desplaçament) % abecedarioMayuscula.length;
                resultado += abecedarioMayuscula[index];
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            resultado += c;
        }
    }
    return resultado;

}

public static String desxifraRotX (String cadena, int desplaçament) {
    String resultado = "";
    for (int i = 0; i < cadena.length(); i++) {
        char c = cadena.charAt(i);
        boolean encontrado = false;
        for (int j = 0; j < abecedarioMinuscula.length; j++) {
            if (c == abecedarioMinuscula[j]) {
                int index = (j - desplaçament + abecedarioMinuscula.length) % abecedarioMinuscula.length;
                resultado += abecedarioMinuscula[index];
                encontrado = true;
                break;
            }
        }
        if (encontrado) continue;
        for (int j = 0; j < abecedarioMayuscula.length; j++) {
            if (c == abecedarioMayuscula[j]) {
                int index = (j - desplaçament + abecedarioMayuscula.length) % abecedarioMayuscula.length;
                resultado += abecedarioMayuscula[index];
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            resultado += c;
        }
    }
    return resultado;
}




}



