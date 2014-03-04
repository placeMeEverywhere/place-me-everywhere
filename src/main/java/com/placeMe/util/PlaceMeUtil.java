package com.placeMe.util;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class PlaceMeUtil {
		
	
	static {
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
	}
	
	private static final String passphrase = "The quick brown fox jumped over the lazy brown dog";
    private static final String salt = "Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura che la retta via era smarrita.";
    private static final int iterations = 2000;
    private static final int keyLength = 256;
    private static final SecureRandom random = new SecureRandom();
	
    public static byte [] encrypt(String plaintext) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        SecretKey key = generateKey(passphrase);

        Cipher cipher = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher.init(Cipher.ENCRYPT_MODE, key, generateIV(cipher), random);
        return cipher.doFinal(plaintext.getBytes());
    }

    public static String decrypt(byte [] ciphertext) throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        SecretKey key = generateKey(passphrase);

        Cipher cipher = Cipher.getInstance("AES/CTR/NOPADDING");
        cipher.init(Cipher.DECRYPT_MODE, key, generateIV(cipher), random);
        return new String(cipher.doFinal(ciphertext));
    }
    
    private static SecretKey generateKey(String passphrase) throws NoSuchAlgorithmException, InvalidKeySpecException {
        PBEKeySpec keySpec = new PBEKeySpec(passphrase.toCharArray(), salt.getBytes(), iterations, keyLength);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWITHSHA256AND256BITAES-CBC-BC");
        return keyFactory.generateSecret(keySpec);
    }

    private static IvParameterSpec generateIV(Cipher cipher) {
        byte [] ivBytes = new byte[cipher.getBlockSize()];
        random.nextBytes(ivBytes);
        return new IvParameterSpec(ivBytes);
    }

}
