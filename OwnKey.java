import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;

import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
public class OwnKey{
	

	private static final String SECRET_KEY = Test.String();
	
	static byte[]A=Test.String1().getBytes();
	 
	  
	  private static final byte[] SALT = A;
	 public static String encrypt(String strToEncrypt) {
		    try {
		    	
		      byte[] iv = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
		      IvParameterSpec ivspec = new IvParameterSpec(iv);
		 
		      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
		      KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT, 65536, 256);
		      SecretKey tmp = factory.generateSecret(spec);
		      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
		 
		      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		      cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
		      return Base64.getEncoder()
		          .encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
		    } catch (Exception e) {
		      System.out.println("Error while encrypting: " + e.toString());
		    }
		    return null;
		  }
		  public static String decrypt(String strToDecrypt) {
			    try {
			      byte[] iv = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
			      IvParameterSpec ivspec = new IvParameterSpec(iv);
			 
			      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
			      KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT, 65536, 256);
			      
			      SecretKey tmp = factory.generateSecret(spec);
			      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
			 
			      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			      cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
			      return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
			    } catch (Exception e) {
			      System.out.println("Error while decrypting: " + e.toString());
			    }
			    return null;
			  }
public static String forget(String strToDecrypt, String SECRET_KEY,byte[] SALT) {
	   
	  try {
	      byte[] iv = { 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
	      IvParameterSpec ivspec = new IvParameterSpec(iv);
	 
	      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
	      KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT, 65536, 256);
	      SecretKey tmp = factory.generateSecret(spec);
	      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
	 
	      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
	      cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
	     
	      return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
	    } catch (Exception e) {
	      System.out.println("Error while decrypting: " + e.toString());
	    }
	    
	    return null;
	  }
}
