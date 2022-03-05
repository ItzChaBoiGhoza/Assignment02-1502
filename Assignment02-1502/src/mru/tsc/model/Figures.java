package mru.tsc.model;

public class Figures extends ToyFormatting {
	
	char classification;
	
	public Figures(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String Classification) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		classification = Classification.charAt(0);
	}

	public char getClassification() {
		return classification;
	}

	public void setClassification(char classification) {
		this.classification = classification;
	}
	
	public String toString() {
		return "Category: Figures [Serial Number: " + SN + ", Name: " + name + ", Brand: " + brand +
				", Price: " + price + ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
				", Classification: " + classification + "]";
	}
	
	public String format() {
		return SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropriate + ";" + classification;
	}
}
