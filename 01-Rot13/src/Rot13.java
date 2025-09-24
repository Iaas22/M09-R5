

public class Rot13 {
    static String abecedario[]={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    public static void main(String[] args) {
       String resultado = xifraRot13("a",13);
       System.out.println(resultado);
    }

    
    public static String xifraRot13(String letra,int desplaçament){
        for (int i = 0; i < abecedario.length; i++) {
            if (letra.equals(abecedario[i])) {
                return abecedario[(i + desplaçament) % abecedario.length];
            }
        }
        return letra; 
    }
} 
