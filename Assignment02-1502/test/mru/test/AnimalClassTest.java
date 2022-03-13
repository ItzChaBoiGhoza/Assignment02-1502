package mru.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Animals;

class AnimalClassTest {
	
	/**
	 * This test is to make sure the format matches
	 * @author Denzel Pascual
	 */
	@Test
	void test() {
		Animals test1 = new Animals("3456789012", "dolly", "MyBrand", 13.99, 6, 40, "wool", "M");
		String testAnimal = test1.format();
		assertEquals("3456789012;dolly;MyBrand;13.99;6;40;wool;M", testAnimal);
	}

}
