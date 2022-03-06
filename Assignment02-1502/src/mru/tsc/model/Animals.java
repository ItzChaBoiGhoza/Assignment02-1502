package mru.tsc.model;

public class Animals extends ToyFormatting {
	
	String Material;
	/*
	 * char size can either be small, medium, large
	 * S, M, L
	 */
	char size;
	
	public Animals (String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String materials, String Size) {
		super(SN, name, brand, price, availableCount, ageAppropriate);
		Material = materials;
		size = Size.charAt(0);
	}

	public String getMaterial() {
		return Material;
	}

	public void setMaterial(String material) {
		Material = material;
	}

	public char getSize() {
		return size;
	}

	public void setSize(char size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Category:Animal, Serial Number: " + SN + ", Name: " + name + ", Brand: " + brand + ", Price: " + price + ", Available Count: "
				+ availableCount + ", Age Appropraite: " + ageAppropriate + ", Material: " + Material + ", Size:" + size;
	}
	
	public String format() {
		return SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropriate + ";" + Material + ";" + size;
	}
	
	
	
	

}
