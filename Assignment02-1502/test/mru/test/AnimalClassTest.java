package mru.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Animals;

class AnimalClassTest {
	
	/**
	 * @author Denzel Pascual
	 */
	@Test
	void test() {
		Animals test1 = new Animals("2234567891", "test", "Testy", 12.12, 4, 7, "Rubber", "Large");
		String testAnimal = test1.toString();
		assertEquals("Animal [SN=2234567891, name=test, brand=Testy, price=12.12, availableCount=4, ageAppropraite=7, Material=Rubber, size=L]", testAnimal);
	}

}
