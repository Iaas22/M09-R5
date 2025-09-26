
public class RotX  {
    public static char[]abecedarioMinuscula = "aàbcçdeéèfghiíïjklmnñoóòpqrstuúüvwxyz".toCharArray();
    public static char[]abecedarioMayuscula = "AÀBCÇDEÉÈFGHIÍÏJKLMNÑOÓÒPQRSTUÚÜVWXYZ".toCharArray();


 public static void main(String[] args) {
     String frase = "Hola, què tal?";
        String resultado = cambiarFrase(frase, "xifrar");
        System.out.println("Frase original: " + frase);
        System.out.println("Frase xifrada: " + resultado);
    
}


    public static String cambiarFrase(String frase, String modo) {
        // usar StringBuilder.append
        String fraseCambiada = "";
        for (int i = 0; i < frase.length(); i++) {
            char caracter = frase.charAt(i);
            if (modo.equals("xifrar")) {
                String cambiado = xifraRotX(String.valueOf(caracter), 13);
                fraseCambiada += cambiado;
            } else if (modo.equals("desxifrar")) {
                String cambiado = desxifraRotX(String.valueOf(caracter), 13);
                fraseCambiada += cambiado;
            }
        }
        return fraseCambiada;
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

public static String desxifraRotX (String cadena, int desplaçament){
String resultado = "";
return resultado;

}




}



