package com.nuvu.usermanagement.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class Utils {
    public static String cipher(String text) throws Exception {
        final byte[] bytes = text.getBytes(StandardCharsets.UTF_8);
        final Cipher aes = obtainsCipher(true);
        final byte[] encrypted = aes.doFinal(bytes);
        return Base64.getEncoder().encodeToString(encrypted);
    }

    public static String decipher(String encrypted) throws Exception {
        final Cipher aes = obtainsCipher(false);
        final byte[] bytes = aes.doFinal(Base64.getDecoder().decode(encrypted));
        return new String(bytes, StandardCharsets.UTF_8);
    }

    private static Cipher obtainsCipher(boolean isCipher) throws Exception {
        final String aesKey = "!A%D*G-KaPdSgVkYp3s6v8y/B?E(H+MbQeThWmZq4t7w!z$C&F)J@NcRfUjXn2r5u8x/A?D*G-KaPdSgVkYp3s6v9y$B&E)H+MbQeThWmZq4t7w!z%C*F-JaNcRfUjXn2r5u8x/A?D(G+KbPeSgVkYp3s6v9y$B&E)H@McQfTjWmZq4t7w!z%C*F-JaNdRgUkXp2r5u8x/A?D(G+KbPeShVmYq3t6v9y$B&E)H@McQfTjWnZr4u7x!z%C*F-JaNd";
        final MessageDigest digest = MessageDigest.getInstance("SHA");
        digest.update(aesKey.getBytes(StandardCharsets.UTF_8));
        final SecretKeySpec key = new SecretKeySpec(digest.digest(), 0, 16, "AES");
        final Cipher aes = Cipher.getInstance("AES/ECB/PKCS5Padding");
        if (isCipher) {
            aes.init(Cipher.ENCRYPT_MODE, key);
        } else {
            aes.init(Cipher.DECRYPT_MODE, key);
        }
        return aes;
    }
}
