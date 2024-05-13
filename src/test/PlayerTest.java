package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.Player;

class PlayerTest {
	
	Player p1, p2;
	
	@BeforeEach
	void setUp() {
		p1 = new Player("A", 100, 10, 5);
		p2 = new Player("A", 100, 5, 10);
	}
	
	@Test
	void testAttack() {
		int res = p1.attack(p2, 2);
		Assertions.assertEquals(res, 5);
	}

	@Test
	void testTakeDamage() {
		p1.takeDamage(10);
		Assertions.assertEquals(p1.getHealth(), 90);
	}
	
	@Test
	void testIsAlive() {
		Assertions.assertEquals(p1.isAlive(), true);
		p1.takeDamage(100);
		Assertions.assertEquals(p1.isAlive(), false);
	}
}
