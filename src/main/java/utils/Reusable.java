package utils;

import java.util.Random;

import com.github.javafaker.Faker;

public class Reusable {
	
	
	public static String generateUserName()
	{
		Faker faker = new Faker();
		
		return faker.name().fullName();
	}
	
	
	public static String generateFirstName()
	{
		Faker faker = new Faker();
		
		return faker.name().firstName();
	}
	
	public static String generateLastName()
	{
		Faker faker = new Faker();
		
		return faker.name().lastName();
	}
	
	
	public static String generateRandomString(int len) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	public static String generateRandomNumber(int len) {
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

}
