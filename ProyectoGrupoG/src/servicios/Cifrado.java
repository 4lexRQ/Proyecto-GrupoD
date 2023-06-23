package servicios;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Cifrado {
    
    /**
     * Este metodo cifra una clave registrada por el usuario la cual sera guardada en la BD
     * 
     * @param input cadena de texto que hace referencia a la clave registrada por el usuario
     * @return sb cadena de caracteres ya cifrado con el algoritmo Hasing SHA-256
     */
    public static String getSHA256(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
