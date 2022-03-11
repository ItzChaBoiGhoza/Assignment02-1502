package mru.tsc.model;

public class BoardGames extends ToyFormatting {
	
	String numOfPlayers;
	String designer;
	
	/**
	 * Constructor used to create the Board Games object.
	 * Arguments from the ToyFormatting superclass
	 * 
	 * @param SN
	 * @param name
	 * @param brand
	 * @param price
	 * @param availableCount
	 * @param ageAppropriate
	 * @param type
	 * @param type
	 */
	public BoardGames(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String players, String designers) {
		super (SN, name, brand, price, ageAppropriate, availableCount);
		numOfPlayers = players;
		designer = designers;
	}

	//Setters and getters generated by Eclipse
	public String getNumOfPlayers() {
		return numOfPlayers;
	}

	public void setNumOfPlayers(String numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}

	public String getDesigner() {
		return designer;
	}

	public void setDesigner(String designer) {
		this.designer = designer;
	}
	

	// ToString method, allows the Board Games object to appear in a readable form
	public String toString(){
		return "Category:BoardGame, Serial Number:" + SN + ", Name: " + name + ", Brand: " + brand + 
				", Price: " + price + ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
				", Number of Players: " + numOfPlayers + ", Designer: " + designer;
	}
	
	// This method creates the format for the Board Games class
	public String format() {
		return SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropriate + ";" + numOfPlayers + ";" + designer;
	}
}
