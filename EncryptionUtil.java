package com.assessment.que2;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {
	
	  private final String ALGORITHM = "AES";
	  
	 public String encrypt(String valueToEnc) throws Exception {
		    final String KEY = "thisisasecretkey";
		    if(KEY!=null && KEY!=""){
		    final byte[] keyValue =  KEY.getBytes();
	        Key key = generateKey(keyValue);
	        Cipher c = Cipher.getInstance(ALGORITHM);
	        c.init(Cipher.ENCRYPT_MODE, key);
	        byte[] encValue = c.doFinal(valueToEnc.getBytes());
	        String encryptedValue = Base64.getEncoder().encodeToString(encValue);
	        return encryptedValue;
		    }
		    else{
		    	throw new Exception();
		    }
	    }

	    public String decrypt(String encryptedValue) throws Exception {
	    	final String KEY = "thisisasecretkey";
	    	 if(KEY!=null && KEY!=""){
		    final byte[] keyValue =  KEY.getBytes();
	        Key key = generateKey(keyValue);
	        Cipher c = Cipher.getInstance(ALGORITHM);
	        c.init(Cipher.DECRYPT_MODE, key);
	        byte[] decordedValue = Base64.getDecoder().decode(encryptedValue);
	        byte[] decValue = c.doFinal(decordedValue);
	        String decryptedValue = new String(decValue);
	        return decryptedValue;
	    	}
			else{
			    	throw new Exception();
			}
	    }

	    private Key generateKey(byte [] keyValue) throws Exception {
	        Key key = new SecretKeySpec(keyValue, ALGORITHM);
	        return key;
	    }
		
		public static void main(String[] args){
			EncryptionUtil encUtil = new EncryptionUtil();
		   try {
			System.out.println(encUtil.encrypt("Hello World"));
			System.out.println(encUtil.decrypt("f5l9YeLvjGfI9qdj32hfqQ=="));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} 
}
