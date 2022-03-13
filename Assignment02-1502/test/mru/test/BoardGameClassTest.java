package mru.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.BoardGames;

class BoardGameClassTest {

	/**
	 * This test is to make sure the format matches
	 * @author Denzel Pascual
	 */
	@Test
	void test() {
		BoardGames test1 = new BoardGames("9012345678", "pokecards", "Mybrand", 13.99, 20, 12, "2-5", "Kyle");
		String testBoardGame = test1.format();
		assertEquals("9012345678;pokecards;MyBrand;13.99;20;12;2-5;Kyle", testBoardGame);
	}

}
