package main;

import java.util.Random;
import java.util.Scanner;

public class Battle {
	
	Player player1 = new Player(),
			player2 = new Player();

	
	public void startSinglePlayerGame() {

		System.out.println("\nYou have selected \"Single Player Game\".");

		// Getting user player stats from the user 
		player1 = getPlayerStatsFromUser();
		
		// setting computer player stats
        Random rand = new Random();
        int attack = 4 + rand.nextInt(7); 
        int strength = rand.nextInt(15-attack);
        strength =  strength >= 10 ? 10 : strength;
        player2 = new Player("Computer", 100, strength, attack);
        
		displayBothPlayerStats();
        startBattle(true);
	}
	

	public void startTwoPlayerGame() {
		
		System.out.println("\nYou have selected \"Two Player Game\".");
		
		System.out.println("\nPlayer 1, Enter your details:");
		// Getting user player1 stats from the user 
		player1 = getPlayerStatsFromUser();
		
		System.out.println("\nPlayer 2, Enter your details:");
		// Getting user player1 stats from the user 
		player2 = getPlayerStatsFromUser();

		displayBothPlayerStats();
		startBattle(false);
	}
	
	public Player getPlayerStatsFromUser() {

		Scanner sc1 = new Scanner(System.in);
		
		Boolean isChoiceInvalid = false;
		
		System.out.println("Enter player name:");		
		String name = sc1.nextLine();
		System.out.println("You will start with 100 Health Points." + 
							"\nYou now have to enter your Attack Power and Defensive Strength Power" +
							"\nYou have a total of 15 points and both can be maximum 10");
		int attack, strength;
		do {
			System.out.println("Enter Attack Power:");
			attack = sc1.nextInt();
			System.out.println("Enter Strength:");
			strength = sc1.nextInt();
			isChoiceInvalid = (attack + strength > 15 && attack + strength < 0) ? true : false;
			if(isChoiceInvalid) System.out.println("Invalid input!");
			else {
				
			}
		} while(isChoiceInvalid);
		
		return new Player(name, 100, strength, attack);
	}
	
	public void startBattle(Boolean isSinglePlayer) {
		
		System.out.println("\nTime to start the battle!");

		int playerTurn;
		int diceRes = 0;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Player attacker;
		Player nonAttacker;
		if(player1.getHealth() == player2.getHealth()) {
			playerTurn = rollDice() % 2 == 0 ? 2:1;
		} else {
			playerTurn = player1.getHealth() < player2.getHealth() ? 1 : 2;
		}

		do{
			if(playerTurn == 1)	{
				attacker = player1;
				nonAttacker = player2;
			} else {
				attacker = player2;
				nonAttacker = player1;			
			}
			
			System.out.println("\nPlayer "+ playerTurn + "'s Turn");
			System.out.println(attacker.getName()+ " Attacks");
			if((isSinglePlayer && playerTurn == 1) || (!isSinglePlayer)) {
				System.out.println("press any key to roll the dice!");
				scanner.nextLine();
			}
			System.out.println("Rolling!");
			try {
				Thread.sleep(500);
				System.out.print(".");
				Thread.sleep(500);
				System.out.print(".");
				Thread.sleep(500);
				System.out.print(".");
				Thread.sleep(500);
				System.out.println(".");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			diceRes = rollDice();
			System.out.println(attacker.getName() + " Rolled: " + diceRes);
			System.out.println(attacker.getName()+ " Attacking with " + attacker.getAttack()*diceRes + " power");
			int damage = attacker.attack(nonAttacker, diceRes);
			System.out.println(attacker.getName()+ " did " + damage + " damage to " + nonAttacker.getName());
			if(!nonAttacker.isAlive()) break;
			
			System.out.println(attacker.getName() + "'s turn is now over. Current stats:");
			displayBothPlayerStats();
			
			System.out.println("\nPress any key to Continue!");
			scanner.nextLine();

			playerTurn = playerTurn == 1 ? 2 : 1;
		}while(player1.isAlive() && player2.isAlive());
		
		System.out.println(attacker.getName() + " Wins!!!");			
		System.out.println("\nPress any key to Continue!");
		scanner.nextLine();
	}
	
	public void displayBothPlayerStats() {
		
		// Displaying stats
        System.out.println("\nPlayer 1:\n"+ player1.toString());
        System.out.println("\nPlayer 2:\n"+ player2.toString());
	}
	
	public int rollDice() {
        Random rand = new Random();
		return 1 + rand.nextInt(6);
	}
	
}
