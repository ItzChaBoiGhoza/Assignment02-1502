package mru.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.BoardGames;

class BoardGameClassTest {

	/**
	 * @author Denzel Pascual
	 */
	@Test
	void test() {
		BoardGames test1 = new BoardGames("7890123456", "Mojang", "Mybrand", 20.99, 40, 14, "2-2", "YukiHaru");
		String testBoardGame = test1.format();
		assertEquals("7890123456;Mojang;MyBrand;20.99;40;14;2-2;YukiHaru", testBoardGame);
	}

}
