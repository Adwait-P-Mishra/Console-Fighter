package main;

public class Player {

	private String name;
	private int health;
	private int strength;
	private int attack;

	public Player() {
		this.name = "Player";
		this.health = 100;
		this.strength = 0;
		this.attack = 0;
	}
	
	public Player(String name, int health, int strength, int attack) {
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.attack = attack;
	}
	
	public int attack(Player enemy, int diceRes) {
		int damage = (this.attack * diceRes) - enemy.getStrength();
		damage = damage >= 0 ? damage : 0;
		enemy.takeDamage(damage);
		return damage;
	}
	
	public void takeDamage(int damage) {
		if(damage > 0) this.health -= damage;
	}
	
	public boolean isAlive() {
		return this.health > 0;
	}
	
	
	// Getters and setters ---
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nHealth Points: " + health + "\nDefensive Strength: " + strength + "\nAttack Power: " + attack;
	}
}
