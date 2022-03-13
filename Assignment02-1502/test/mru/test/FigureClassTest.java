package mru.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Figures;

class FigureClassTest {

	/**
	 * This test is to make sure the format matches
	 * @author Denzel Pascual
	 */
	@Test
	void test() {
			Figures test1 = new Figures("1234567891", "Gundam", "MyBrand", 90.99, 18, 30, "A");
			String FigureTest = test1.format();
			assertEquals("1234567891;Gundam;MyBrand;90.99;18;30;A", FigureTest);
			
		}
}
