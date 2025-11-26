import java.security.MessageDigest;
import java.security.spec.KeySpec;
import java.util.HexFormat;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Hashes {

    public int npass = 0;

    private final HexFormat hex = HexFormat.of();


    public String getSHA512AmbSalt(String pw, String salt) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(salt.getBytes());
        byte[] digest = md.digest(pw.getBytes());
        return hex.formatHex(digest);
    }


    public String getPBKDF2AmbSalt(String pw, String salt) throws Exception {

        KeySpec spec = new PBEKeySpec(pw.toCharArray(), salt.getBytes(), 65536, 160);

        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return hex.formatHex(hash);
    }


    public String forcaBruta(String algorithm, String hash, String salt) throws Exception {

        String charset = "abcdeFABCDEf1234567890!";

        npass = 0;
        char[] pwd = new char[6];

        for (int len = 1; len <= 6; len++) {
            String found = RecursivitatBruta(0, len, pwd, charset, algorithm, hash, salt);
            if (found != null)
                return found;
        }
        return null;
    }


    private String RecursivitatBruta(int pos, int len, char[] pwd, String charset,
                                     String algorithm, String hash, String salt) throws Exception {

        if (pos == len) {
            npass++;
            String intento = new String(pwd, 0, len);

            String intentoHash =
                    algorithm.equals("SHA-512")
                            ? getSHA512AmbSalt(intento, salt)
                            : getPBKDF2AmbSalt(intento, salt);

            if (intentoHash.equals(hash))
                return intento;

            return null;
        }

        for (int i = 0; i < charset.length(); i++) {
            pwd[pos] = charset.charAt(i);
            String result = RecursivitatBruta(pos + 1, len, pwd, charset, algorithm, hash, salt);
            if (result != null)
                return result;
        }

        return null;
    }


    public String getInterval(long t1, long t2) {
        long diff = t2 - t1;

        long ms = diff % 1000;
        long s  = (diff / 1000) % 60;
        long m  = (diff / 60000) % 60;
        long h  = (diff / 3600000);

        return String.format("%d dies / %d hores / %d minuts / %d segons / %d millis",
                0, h, m, s, ms);
    }


    public static void main(String[] args) throws Exception {
        String salt = "qpoweriruañslkdfjz";
        String pw = "aaabF!";
        Hashes h = new Hashes();
        String[] aHashes = { h.getSHA512AmbSalt(pw, salt), h.getPBKDF2AmbSalt(pw, salt) };

        String pwTrobat = null;
        String[] algorismes = { "SHA-512", "PBKDF2" };

        for (int i = 0; i < aHashes.length; i++) {
            System.out.println("=============\n");
            System.out.printf("Algorisme: %s\n", algorismes[i]);
            System.out.printf("Hash: %s\n", aHashes[i]);
            System.out.println("--------------------\n");
            System.out.println("-- Inici de força bruta ---\n");

            long t1 = System.currentTimeMillis();
            pwTrobat = h.forcaBruta(algorismes[i], aHashes[i], salt);
            long t2 = System.currentTimeMillis();

            System.out.printf("Pass      : %s\n", pwTrobat);
            System.out.printf("Provats: %s\n", h.npass);
            System.out.printf("Temps  : %s\n", h.getInterval(t1, t2));
            System.out.println("----------------\n\n");
        }
    }
}
