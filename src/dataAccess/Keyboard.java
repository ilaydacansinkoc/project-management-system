package dataAccess;

import java.util.Scanner;

public class Keyboard {
	
	private static Scanner keyboard = new Scanner(System.in);
	
	public static String get() {
		
		return keyboard.nextLine();			

	}
	
	public static void close() {
		System.out.println("Keyboard closed");
		keyboard.close();
	}

}
