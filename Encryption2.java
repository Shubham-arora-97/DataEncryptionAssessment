import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encryption2 {
private final static String salt="DGE$5SGr@3VsHYUMas2323E4d57vfBfFSTRU@!DSH(*%FDSdfg13sgfsg";
	public static void main(String[] args) {

		String password = "saikiran";
		System.out.println(password+" password hashed to " + md5Hash(password));

	}
	public static String md5Hash(String message) {
		String sam = "";
		if(null == message) 
			return null;
		message = message+salt;
		try {
				MessageDigest digest = MessageDigest.getInstance("MD5");
				digest.update(message.getBytes(), 0, message.length());
				sam = new BigInteger(1, digest.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
			}
return sam;
}
}
