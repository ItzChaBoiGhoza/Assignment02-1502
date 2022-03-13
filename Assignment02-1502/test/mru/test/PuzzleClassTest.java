package mru.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Puzzles;

class PuzzleClassTest {

	/**
	 * This test is to make sure the format matches
	 * @author Denzel Pascual
	 */
	@Test
	void test() {
		Puzzles test1 = new Puzzles("4567890123", "mojang", "MyBrand", 14.99, 20, 14, "C");
		String PuzzleTest = test1.format();
		assertEquals("4567890123;mojang;MyBrand;14.99;20;14;C", PuzzleTest);
	}

}
