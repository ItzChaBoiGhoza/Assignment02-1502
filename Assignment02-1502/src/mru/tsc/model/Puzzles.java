package mru.tsc.model;

public class Puzzles extends ToyFormatting{
	
	/*
	 * The puzzle-type can either be Mechanical, Cryptic, Logic, Trivia, or Riddle.
	 * M, C, L, T, R
	 */
	char puzzleType;
	
	public Puzzles(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String PuzzleType) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		puzzleType = PuzzleType.charAt(0);
	}

	public char getPuzzleType() {
		return puzzleType;
	}

	public void setPuzzleType(char puzzleType) {
		this.puzzleType = puzzleType;
	}
	
	public String toString() {
		return "Category: Puzzles [Serial Number: " + SN + ", Name: " + name + ", Brand: " + brand +
				", Price: " + price + ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
				", Puzzle Type: " + puzzleType + "]";
	}
	
	public String format() {
		return SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropriate + ";" + puzzleType;
	}

}
