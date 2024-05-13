package main;

import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
				
		do {
			Scanner sc = new Scanner(System.in);
			
			Battle battle = new Battle();
			System.out.println("\nWelcome to the Magical Arena!");
			System.out.println("What would you like to play:");
			System.out.println("1. Single Player Game");
			System.out.println("2. Two Player Game");
			System.out.println("3. Exit");
			System.out.print("Enter your choice:");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				battle.startSinglePlayerGame();
				break;
			case 2:
				battle.startTwoPlayerGame();
				break;
			case 3:
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("\nInvalid selection! Please try again.");
			}
		} while (true);
	}
}
