package mru.tsc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.view.AppMenu;
import mru.tsc.model.Figures;
import mru.tsc.exceptions.IncorrectInput;
import mru.tsc.exceptions.PlayersChecking;
import mru.tsc.model.Animals;
import mru.tsc.model.Puzzles;
import mru.tsc.model.BoardGames;
import mru.tsc.model.ToyFormatting;

/*
 * @author Denzel Pascual & Ghoza Ghozali
 */
public class AppManager {
	
	
	private final String FILE_PATH = "res/Toys.txt";
	Scanner input = new Scanner(System.in);
	ArrayList<ToyFormatting> toys;
	AppMenu appMen;
	
	/**
	 * Constructor
	 * This class creates a new instance of the ArrayList and new instance of the appMenu class
	 * Calls loadData and launchApplication method
	 * 
	 * @throws Exception
	 */
	public AppManager() throws Exception {
		toys = new ArrayList<>();
		appMen = new AppMenu();
		loadData();
		launchApplication();
	}

	/**
	 * The method launchApplication is responsible for running the App.
	 * Calls showAppMenu from the appMenu Class();
	 * Displays Four choices; searchToy, Add Toy, Remove Toy, and Save and Exit
	 * Loops until the user hits save and exit
	 * @throws Exception 
	 */

	private void launchApplication() throws Exception {
		boolean flag = true;
		int option;
		while (flag) {
			
			option = appMen.showAppMenu();
			
			switch (option) {
			
			case 1:
				searchToyMenu();
				break;
			case 2:
				addToy();
				break;
			case 3:
				String sn = appMen.promptSerialNumber();
				ToyFormatting toySerial = searchBySerial(sn);
				appMen.showSerialNumber(toySerial);
				System.out.println(" ");
				char remove = appMen.promptRemoveToy();
				removeToy(sn, remove);
				break;
			case 4:
				save();
				flag = false;
			}
		}
	}

	
	/**
	 * searchToyMenu displays four option to the user which searches for
	 * (toys serial number, toy name, toy type, and a return to Main menu)
	 * 
	 * @throws Exception
	 */
	public void searchToyMenu() throws Exception {
		boolean flag = true;
		int option;
		while (flag) {
			
			option = appMen.showSubMenu();
			
			switch (option) {
			
			case 1:
				String sn = appMen.promptSerialNumber();
				ToyFormatting toySerial= searchBySerial(sn);
				appMen.showSerialNumber(toySerial);
				System.out.println("\nPress Enter to Continue");
				input.nextLine();
				break;
			case 2:
				String name = appMen.promptToyName();
				toySearchByName(name);
				System.out.println("\nPress Enter to Continue");
				input.nextLine();
				break;
			case 3:
				char type = appMen.promptType();
				toySearchByType(type);
				System.out.println("\nPress Enter to Continue");
				input.nextLine();
				break;
			case 4:
				launchApplication();
			}
		}
	}

	/**
	 * This method searches for the serial number and check if SN is 
	 * equal to the serial number entered
	 * 
	 * @param sn
	 * @return
	 */
	private ToyFormatting searchBySerial(String sn) {
		ToyFormatting toy = null;
		
		for(ToyFormatting t : toys) {
			if(t.getSN().equals(sn)) {
				toy = t;
				break;
			}
		}
		
		return toy;
	}

	/**
	 * addToy() adds a toy into the database
	 * @throws Exception
	 */
	public void addToy() throws Exception {
		String sn = serialNumChecker();
		boolean serialNumTaken = duplicateSerialNum(sn);
		while(serialNumTaken) {
			System.out.println("That Serial Number already exists");
			System.out.println("Please enter a new Serial Number");
			serialNumTaken = duplicateSerialNum(sn);
		}
		String toyType = typeChecker(("" + sn).charAt(0));
		if(toyType == "A") {
			addToyAnimal(sn);
		}
		if(toyType == "B") {
			addToyBoardGame(sn);
		}
		if(toyType == "F") {
			addToyFigure(sn);
		}
		if(toyType == "P") {
			addToyPuzzle(sn);
		}
		launchApplication();
	}

	/**
	 * removeToy() removes a toy in the database
	 * @param sn
	 * @param type
	 * @throws Exception
	 */
	public void removeToy(String sn, char type) throws Exception {
		int i = 0;
		if(type == 'Y') {
			while(i < toys.size()) {
				String storedSN = toys.get(i).getSN();
				if(storedSN.equals(sn)) {
					toys.remove(i);
					System.out.println("\nToy removed");
					System.out.println(" ");
				}
				i++;
			}
		}
	}

	/**
	 * This methods saves new information into the database, and exits the program
	 * 
	 * @throws IOException
	 */
	public void save() throws IOException {
		File db = new File(FILE_PATH);
		PrintWriter saveHere = new PrintWriter(db);
		
		System.out.println("");
		System.out.println("Saving Data Into Database...");
		System.out.println("");
		
		System.out.println("*********** THANKS FOR VISITING US! ***********");
		
		int i = 0;
		while(i < toys.size()) {
			if (toys.get(i) instanceof Animals) {
				Animals A = (Animals)toys.get(i);
				saveHere.println(A.format());
			}
			if (toys.get(i) instanceof BoardGames) {
				BoardGames B = (BoardGames)toys.get(i);
				saveHere.println(B.format());
			}
			if (toys.get(i) instanceof Figures) {
				Figures F = (Figures)toys.get(i);
				saveHere.println(F.format());
			}
			if (toys.get(i) instanceof Puzzles) {
				Puzzles P = (Puzzles)toys.get(i);
				saveHere.println(P.format());
			}
			i++;
		}
		saveHere.close();
	}
	
	/**
	 * This method checks if the serial number entered by the user is the same
	 * as the one in the database.
	 * It check if it is a duplicate of the one in the database
	 * 
	 * @param sn
	 * @return
	 */
	public boolean duplicateSerialNum(String sn) {
		boolean repeatSN = false;
		String storedSN = "0";
		int i = 0;
		while(i < toys.size()) {
			storedSN = toys.get(i).getSN();
			if(storedSN.equals(sn)) {
				repeatSN = true;
			}
			i++;
		}
		return repeatSN;
	}
	
	/**
	 * This method prompts the user for the serial number 
	 * and checks for if the length of the serial number is equal to "10"
	 * if not it will output a message saying "Enter a 10 digit number"
	 * 
	 * @return
	 */
	public String serialNumChecker() {
		boolean valid = false;
		String s = "0";
		System.out.print("Enter Serial Number: ");
		while(valid == false) {
			if(input.hasNextLong()) {
				s = input.next();
				input.nextLine();
				int length = String.valueOf(s).length();
				if(length != 10) {
					System.out.println("Please enter a 10 digit number");
				} else {
					valid = true;
				}
			} else {
				System.out.println("Please input a number");
				input.nextLine();
			}
		}
		return s;
	}
	
	/**
	 * The loadData function reads the text from the text file. 
	 * It determines what type of toy it is reading based on the Serial Number. 
	 * After knowing the type of toy, it splits the data up into the appropriate pieces 
	 * and uses those pieces to initialize correct type of toy and then adds those toys to the toy ArrayList.
	 * 
	 * @throws Exception
	 */
	public void loadData() throws Exception {
		File db = new File(FILE_PATH);
		String currentLine;
		String[] splittedLine;
		
		if(db.exists()) {
			Scanner fileReader = new Scanner(db);
			
			while(fileReader.hasNextLine()) {
				
				currentLine = fileReader.nextLine();
				splittedLine = currentLine.split(";");
				char serialNum = splittedLine[0].charAt(0);
			
				if(typeChecker(serialNum) == "A") {
					ToyFormatting animal = new Animals(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toys.add(animal);
				}
				if(typeChecker(serialNum) == "B") {
					ToyFormatting boardGame = new BoardGames(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toys.add(boardGame);
				}
				if(typeChecker(serialNum) == "F") {
					ToyFormatting figure = new Figures(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(figure);
				}
				if(typeChecker(serialNum) == "P") {
					ToyFormatting puzzle = new Puzzles(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(puzzle);
				}
			}
			fileReader.close();
		}
	}
	
	/**
	 * This method takes in the first digits of the serial number 
	 * and uses a switch method to determine what type of toy it is.
	 * 
	 * @param serialNumber
	 * @return Returns the type of toy as char
	 */
	public String typeChecker(char serialNumber) {
		String Type = null;
		switch (serialNumber) {
		case '0':
		case '1':
			Type = "F";
			break;
		case '2':
		case '3':
			Type = "A";
			break;
		case '4':
		case '5':
		case '6':
			Type = "P";
			break;
		case '7':
		case '8':
		case '9':
			Type = "B";
			break;
		}
		return Type;
	}
	
	/**
	 * This methods searches a toy by its name and prints the output
	 * by using the toString method
	 * 
	 * @param toyName
	 */
	public void toySearchByName(String toyName) {
		ToyFormatting toy = null;
		for(ToyFormatting t : toys) {
			if((t.getName().toUpperCase()).contains(toyName.toUpperCase())) {
				toy = t;
				if(toy instanceof Animals) {
					Animals animal = (Animals) toy;
					System.out.println(animal.toString());
				}
				if(toy instanceof BoardGames) {
					BoardGames boardGame = (BoardGames) toy;
					System.out.println(boardGame.toString());
				}
				if(toy instanceof Figures) {
					Figures figure = (Figures) toy;
					System.out.println(figure.toString());
				}
				if(toy instanceof Puzzles) {
					Puzzles puzzle = (Puzzles) toy;
					System.out.println(puzzle.toString());
				}
			}
		}
	}
	
	public void toySearchByType(char toyType) throws Exception {
		int i;
		if(toyType == 'A') {
			i = 0;
			while(i < toys.size()) {
				if(toys.get(i) instanceof Animals) {
					Animals animal = (Animals) toys.get(i);
					System.out.println(animal.toString());
				}
				i++;
			}
		}
		if(toyType == 'B') {
			i = 0;
			while(i < toys.size()) {
				if(toys.get(i) instanceof BoardGames) {
					BoardGames boardGame = (BoardGames) toys.get(i);
					System.out.println(boardGame.toString());
				}
				i++;
			}
		}
		if(toyType == 'F') {
			i = 0;
			while(i < toys.size()) {
				if(toys.get(i) instanceof Figures) {
					Figures figure = (Figures) toys.get(i);
					System.out.println(figure.toString());
				}
				i++;
			}
		}
		if(toyType == 'P') {
			i = 0;
			while(i < toys.size()) {
				if(toys.get(i) instanceof Puzzles) {
					Puzzles puzzle = (Puzzles) toys.get(i);
					System.out.println(puzzle.toString());
				}
				i++;
			}
		}
		if(toyType == 'E') {
			searchToyMenu();
		}
	}

	public void addNewToyAnimal(String sn, String name, String brand, double price, int availableCount, int ageAppropriate, String materials, String size) {
		ToyFormatting animal = new Animals(sn, name, brand, price, availableCount, ageAppropriate, materials, size);
		toys.add(animal);
	}
	
	public void addToyAnimal(String sn) throws IncorrectInput{
		boolean validation = false;
		String name = appMen.promptName();
		String brand = appMen.promptBrand();
		double price = appMen.promptPrice();
		int availableCount = appMen.promptAvailableToy();
		int ageAppropriate = appMen.promptAgeRecommendation();
		String materials = appMen.promptMaterial();
		String size = null;
		while(validation == false) {
			System.out.println("Choose the size of Animal: ");
			System.out.println("\n\t(S) Small");
			System.out.println("\t(M) Medium");
			System.out.println("\t(L) Large");
			System.out.print("\nEnter Size: ");
			char option = input.nextLine().toUpperCase().charAt(0);
			
			if(option == 'S' || option == 'M' || option == 'L') {
				validation = true;
				size = "" + option;
			} else {
				System.out.println("Please enter a valid option");
				input.nextLine();
			}
		}
		addNewToyAnimal(sn, name, brand, price, availableCount, ageAppropriate, materials, size);
		System.out.println("\n --------- Toy has been added ---------");
		System.out.println("\nPress Enter to Continue");
		input.nextLine();
	}
	
	public void addNewToyBoardGame(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String players, String designers) {
		ToyFormatting boardGame = new BoardGames(SN, name, brand, price, ageAppropriate, availableCount, designers, designers);
		toys.add(boardGame);
	}
	
	public void addToyBoardGame(String sn) throws IncorrectInput, PlayersChecking {
		String name = appMen.promptName();
		String brand = appMen.promptBrand();
		double price = appMen.promptPrice();
		int availableCount = appMen.promptAvailableToy();
		int ageAppropriate = appMen.promptAgeRecommendation();
		String players = appMen.promptPlayers();
		String designers = appMen.promptDesigner();
		addNewToyBoardGame(sn, name, brand, price, availableCount, ageAppropriate, players, designers);
		System.out.println("\n --------- Toy has been added ---------");
		System.out.println("\nPress Enter to Continue");
		input.nextLine();
	}
	
	public void addNewToyFigure(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String classification) {
		ToyFormatting figure = new Figures(SN, name, brand, price, availableCount, ageAppropriate, classification);
		toys.add(figure);
	}
	
	public void addToyFigure(String sn) {
		boolean validation = false;
		String name = appMen.promptName();
		String brand = appMen.promptBrand();
		double price = appMen.promptPrice();
		int availableCount = appMen.promptAvailableToy();
		int ageAppropriate = appMen.promptAgeRecommendation();
		String classification = null;
		while(validation == false) {
			System.out.println("Choose a classification for Figure: ");
			System.out.println("\n\t(A) Action");
			System.out.println("\t(D) Doll");
			System.out.println("\t(H) Historic");
			System.out.print("\nEnter Classification: ");
			char option = input.nextLine().toUpperCase().charAt(0);
			
			if(option == 'A' || option == 'D' || option == 'H') {
				validation = true;
				classification = "" + option;
			} else {
				System.out.println("Please enter a valid option");
				input.nextLine();
			}
		}
		
		addNewToyFigure(sn, name, brand, price, availableCount, ageAppropriate, classification);
		System.out.println("\n --------- Toy has been added ---------");
		System.out.println("\nPress Enter to Continue");
		input.nextLine();
	}
	
	public void addNewToyPuzzle(String SN, String name, String brand, double price, int availableCount, int ageAppropriate, String puzzleType) {
		ToyFormatting puzzle = new Puzzles(SN, name, brand, price, ageAppropriate, ageAppropriate, puzzleType);
		toys.add(puzzle);
	}
	
	public void addToyPuzzle(String sn) {
		boolean validation = false;
		String name = appMen.promptName();
		String brand = appMen.promptBrand();
		double price = appMen.promptPrice();
		int availableCount = appMen.promptAvailableToy();
		int ageAppropriate = appMen.promptAgeRecommendation();
		String puzzleType = null;
		while(validation == false) {
			System.out.println("Choose a Puzzle Type: ");
			System.out.println("\n\t(C) Cryptic");
			System.out.println("\t(L) Logic");
			System.out.println("\t(M) Mechanical");
			System.out.println("\t(R) Riddle");
			System.out.println("\t(T) Trivia");
			System.out.print("\nEnter Puzzle Type: ");
			char option = input.nextLine().toUpperCase().charAt(0);
			
			if(option == 'C' || option == 'L' || option == 'M' || option == 'R' || option == 'T') {
				validation = true;
				puzzleType = "" + option;
			} else {
				System.out.println("Please enter a valid option");
				input.nextLine();
			}
		}
		
		addNewToyPuzzle(sn, name, brand, price, availableCount, ageAppropriate, puzzleType);
		System.out.println("\n --------- Toy has been added ---------");
		System.out.println("\nPress Enter to Continue");
		input.nextLine();
	}
}
