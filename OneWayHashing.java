package com.assignment.oneWayHashing;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class OneWayHashing {
	
	private static final String ALGORITHM = "MD5";
	
	//This 
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance(ALGORITHM); 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
	
	String encrypt(String str) throws NoSuchAlgorithmException {
		byte[] hash = getSHA(str);
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));  
        while (hexString.length() < 32)  
        {
            hexString.insert(0, '0');  
        }  
        return hexString.toString();
	}
	
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(System.in);

			System.out.println("Enter the Text to Encrypt");
			String str = scan.nextLine();
			str = str.toLowerCase();
			OneWayHashing owh = new OneWayHashing();
			String s1 = owh.encrypt(str);
			System.out.println("For Input 1 "+str+" SHA is : "+s1);
			System.out.println("Enter the Text to Check Hashing");
			String str1 = scan.nextLine();
			str = str1.toLowerCase();
			String s2 = owh.encrypt(str1);
			System.out.println("For Input 1 "+str1+" SHA is : "+s2);
			
			if(s1.contentEquals(s2)) {
				System.out.println("Messages Are Same");
			}
			else {
				System.out.println("Messages are not same");
			}
			scan.close();
		}
		catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}