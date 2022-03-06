package mru.tsc.model;

public class BoardGames extends ToyFormatting {
	
	String numOfPlayers;
	String designer;
	
	public BoardGames(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String players, String designers) {
		super (SN, name, brand, price, ageAppropriate, availableCount);
		numOfPlayers = players;
		designer = designers;
	}

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
	

	public String toString(){
		return "Category:BoardGame, Serial Number:" + SN + ", Name: " + name + ", Brand: " + brand + 
				", Price: " + price + ", Available Count: " + availableCount + ", Age Appropriate: " + ageAppropriate +
				", Number of Players: " + numOfPlayers + ", Designer: " + designer;
	}
	
	public String format() {
		return SN + ";" + name + ";" + brand + ";" + price + ";" + availableCount + ";" + ageAppropriate + ";" + numOfPlayers + ";" + designer;
	}
}
