package util;

import java.security.SecureRandom;
import java.security.spec.KeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.util.Base64;

public class PasswordUtil {

    // Generate a random salt
    public static byte[] getSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    // Hash password with salt using PBKDF2
    public static String hashPassword(String password, byte[] salt) throws Exception {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256); // iterations=65536, key length=256
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = factory.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }

    // Combine salt + hash for storage
    public static String generateSecurePassword(String password) throws Exception {
        byte[] salt = getSalt();
        String hash = hashPassword(password, salt);
        String saltBase64 = Base64.getEncoder().encodeToString(salt);
        return saltBase64 + ":" + hash; // store as "salt:hash"
    }

    // Verify password
    public static boolean verifyPassword(String enteredPassword, String storedPassword) throws Exception {
        String[] parts = storedPassword.split(":");
        byte[] salt = Base64.getDecoder().decode(parts[0]);
        String hashOfInput = hashPassword(enteredPassword, salt);
        return hashOfInput.equals(parts[1]);
    }
}
