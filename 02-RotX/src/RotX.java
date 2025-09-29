public class RotX  {
    public static char[] abecedarioMinuscula = "aàbcçdeéèfghiíïjklmnñoóòpqrstuúüvwxyz".toCharArray();
    public static char[] abecedarioMayuscula = "AÀBCÇDEÉÈFGHIÍÏJKLMNÑOÓÒPQRSTUÚÜVWXYZ".toCharArray();

    public static void main(String[] args) {
        String frase = "Hola, què tal?";
        int desplaçament = 2;

        String resultadoXifrada = xifraRotX(frase, desplaçament);
        System.out.println("Frase xifrada: " + resultadoXifrada);

        String resultadoDesxifrada = desxifraRotX(resultadoXifrada, desplaçament);
        System.out.println("Frase desxifrada: " + resultadoDesxifrada);

        System.out.println("\nForça bruta sobre la frase xifrada:");
        forcaBrutaRotX(resultadoXifrada);

        // Altres proves d'exemple
        System.out.println("\nXifrat (2)-XYZ => " + xifraRotX("XYZ", 2));
        System.out.println("Desxifrat (2)-ZAÁ => " + desxifraRotX("ZAÁ", 2));
        System.out.println("\nXifrat (4)-Hola, Mr. calçot => " + xifraRotX("Hola, Mr. calçot", 4));
        System.out.println("Desxifrat (4)-Ïqoc, Óú. écoèqü => " + desxifraRotX("Ïqoc, Óú. écoèqü", 4));
        System.out.println("\nXifrat (6)-Perdó, per tu què és? => " + xifraRotX("Perdó, per tu què és?", 6));
        System.out.println("Desxifrat (6)-Úiüht, úiü wx ùxì ív? => " + desxifraRotX("Úiüht, úiü wx ùxì ív?", 6));
    }

    public static String xifraRotX(String cadena, int desplaçament) {
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

    public static String desxifraRotX(String cadena, int desplaçament) {
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

    public static void forcaBrutaRotX(String cadenaXifrada) {
        int n = abecedarioMinuscula.length;
        for (int desplaçament = 0; desplaçament < n; desplaçament++) {
            String desxifrat = desxifraRotX(cadenaXifrada, desplaçament);
            System.out.println("(" + desplaçament + ")->" + desxifrat);
        }
    }
}
