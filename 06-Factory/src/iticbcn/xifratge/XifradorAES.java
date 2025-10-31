package iticbcn.xifratge;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class XifradorAES {
     public static final String ALGORISME_XIFRAT = "AES";
    public static final String ALGORISME_HASH = "SHA-256";
    public static final String FORMAT_AES = "AES/CBC/PKCS5Padding";

    private static final int MIDA_IV = 16;
    private static byte[] iv = new byte[MIDA_IV];
    private static final String CLAU = "clau123";

    public byte[] xifraAES(String msg, String clau) throws Exception {
        //genera ivParameterSpec
        SecureRandom random = new SecureRandom();
        byte[] ivBytes = new byte[MIDA_IV];
        random.nextBytes(ivBytes);
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

        //genera hash
        MessageDigest digest = MessageDigest.getInstance(ALGORISME_HASH);
        byte[] keyHash = digest.digest(clau.getBytes());

        byte[] keyBytes = Arrays.copyOf(keyHash, 16);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, ALGORISME_XIFRAT);

        //encrypt
        Cipher cipher = Cipher.getInstance(FORMAT_AES);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);
        byte[] encrypted = cipher.doFinal(msg.getBytes());

        //combinar iv i part xifrada
        byte[] result = new byte[ivBytes.length + encrypted.length];
        System.arraycopy(ivBytes, 0, result, 0, ivBytes.length);
        System.arraycopy(encrypted, 0, result, ivBytes.length, encrypted.length);

        //return iv+msgxifrat
        return result;
    }

    public String desxifraAES(byte[] bIvIMsgXifrat, String clau) throws Exception {
        //extreure l'iv
        byte[] ivBytes = Arrays.copyOfRange(bIvIMsgXifrat, 0, MIDA_IV);
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);

        //extreure part xifrada
        byte[] encryptedPart = Arrays.copyOfRange(bIvIMsgXifrat, MIDA_IV, bIvIMsgXifrat.length);

        //fer hash de la clau
        MessageDigest digest = MessageDigest.getInstance(ALGORISME_HASH);
        byte[] keyHash = digest.digest(clau.getBytes());

        //desxifrar
        byte[] keyBytes = Arrays.copyOf(keyHash, 16);
        SecretKeySpec secretKey = new SecretKeySpec(keyBytes, ALGORISME_XIFRAT);
        Cipher cipher = Cipher.getInstance(FORMAT_AES);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);
        byte[] decrypted = cipher.doFinal(encryptedPart);

        //return string desxifrat
        return new String(decrypted);
    }

   
    }

