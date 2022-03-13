package mru.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mru.tsc.model.Figures;

class FigureClassTest {

	/**
	 * @author Denzel Pascual
	 */
	@Test
	void test() {
			Figures test1 = new Figures("1234567891", "test", "Testy", 12.12, 4, 7, "Doll");
			String FigureTest = test1.toString();
			assertEquals("Figure [SN=1234567891, name=test, brand=Testy, price=12.12, availableCount=4, ageAppropraite=7, classification=D]", FigureTest);
			
		}
}
