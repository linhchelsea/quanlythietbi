package library;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class LibraryMD5 {
	public static String GetStringMD5(String md5){
		String res = "";
		MessageDigest md =null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		md.update(md5.getBytes());
		res = new BigInteger(1, md.digest()).toString(16);
		return res;
	}
}