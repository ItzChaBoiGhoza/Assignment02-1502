package mru.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Puzzles;

class PuzzleClassTest {

	/**
	 * @author Denzel Pascual
	 */
	@Test
	void test() {
		Puzzles test1 = new Puzzles("5234567891", "test", "Testy", 12.12, 4, 7, "L");
		String PuzzleTest = test1.format();
		assertEquals("Puzzle [SN=5234567891, name=test, brand=Testy, price=12.12, availableCount=4, ageAppropraite=7, puzzleType=L]", PuzzleTest);
	}

}
