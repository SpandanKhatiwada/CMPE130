import java.security.NoSuchAlgorithmException;
import java.security.*;
import java.util.Base64;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class KeyGenerate {

 public static SecretKey generateSecretKey() {
  KeyGenerator keyGen = null;
  try {
     keyGen = KeyGenerator.getInstance("AES");
     SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
     int keyBitSize = 256;

     keyGen.init(keyBitSize, secureRandom);
  } catch (NoSuchAlgorithmException e) {
   e.printStackTrace();
  }

  SecretKey secretKey = keyGen.generateKey();

  return secretKey;
 }

 public static  String encodedKey() {
  SecretKey secretKey = generateSecretKey();
  String encodedKey = Base64.getEncoder().encodeToString(
    secretKey.getEncoded());
  return encodedKey;
 }
 
 public static byte[] getSalt() 
 {
	 byte[] salt = new byte[16];
	 try
	 {
	 SecureRandom secureRandom = SecureRandom.getInstance("Sha1PRNG");
	 
	 
	 secureRandom.nextBytes(salt);
	
	 }
	 catch(NoSuchAlgorithmException e)
	 {
		 e.printStackTrace();
 }
	 return salt;
 
}
}