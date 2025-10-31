package iticbcn;

public class XifradorRotX {
public static char[] abecedarioMinuscula = "aàbcçdeéèfghiíïjklmnñoóòpqrstuúüvwxyz".toCharArray();
    public static char[] abecedarioMayuscula = "AÀBCÇDEÉÈFGHIÍÏJKLMNÑOÓÒPQRSTUÚÜVWXYZ".toCharArray();

    
    public String xifraRotX(String cadena, int desplaçament) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            boolean encontrado = false;
            for (int j = 0; j < abecedarioMinuscula.length; j++) {
                if (c == abecedarioMinuscula[j]) {
                    int index = (j + desplaçament) % abecedarioMinuscula.length;
                    resultado.append(abecedarioMinuscula[index]);
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) continue;
            for (int j = 0; j < abecedarioMayuscula.length; j++) {
                if (c == abecedarioMayuscula[j]) {
                    int index = (j + desplaçament) % abecedarioMayuscula.length;
                    resultado.append(abecedarioMayuscula[index]);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    public String desxifraRotX(String cadena, int desplaçament) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            boolean encontrado = false;
            for (int j = 0; j < abecedarioMinuscula.length; j++) {
                if (c == abecedarioMinuscula[j]) {
                    int index = (j - desplaçament + abecedarioMinuscula.length) % abecedarioMinuscula.length;
                    resultado.append(abecedarioMinuscula[index]);
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) continue;
            for (int j = 0; j < abecedarioMayuscula.length; j++) {
                if (c == abecedarioMayuscula[j]) {
                    int index = (j - desplaçament + abecedarioMayuscula.length) % abecedarioMayuscula.length;
                    resultado.append(abecedarioMayuscula[index]);
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                resultado.append(c);
            }
        }
        return resultado.toString();
    }

    public void forcaBrutaRotX(String cadenaXifrada) {
        int n = abecedarioMinuscula.length;
        for (int desplaçament = 0; desplaçament < n; desplaçament++) {
            String desxifrat = desxifraRotX(cadenaXifrada, desplaçament);
            System.out.println("(" + desplaçament + ")->" + desxifrat);
        }
    }
}
