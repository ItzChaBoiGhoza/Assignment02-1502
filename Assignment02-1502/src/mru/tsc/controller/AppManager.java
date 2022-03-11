package mru.tsc.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import mru.tsc.view.AppMenu;
import mru.tsc.model.Figures;
import mru.tsc.model.Animals;
import mru.tsc.model.Puzzles;
import mru.tsc.model.BoardGames;
import mru.tsc.model.ToyFormatting;

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
	 * @author Denzel Pascaul & Ghoza Ghozali
	 */
	public AppManager() throws Exception {
		toys = new ArrayList<>();
		appMen = new AppMenu();
		loadData();
		launchApplication();
	}

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
				removeToy();
				break;
			case 4:
				save();
				flag = false;
			}
		}
	}

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
				System.out.println("");
				System.out.println("Press Enter to Continue");
				input.nextLine();
				break;
			case 2:
				String name = appMen.promptToyName();
				ToyFormatting toyName = searchByName(name);
				appMen.showName(toyName);
				toySearchByName(name);
				System.out.println("");
				System.out.println("Press Enter to Continue");
				input.nextLine();
				break;
			case 3:
				char type = appMen.promptType();
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
	 * This method searches for the name of the toy in the ArrayList
	 * 
	 * @param name
	 * @return
	 */
	private ToyFormatting searchByName(String name) {
		ToyFormatting toy = null;
		
		for(ToyFormatting t : toys) {
			if(t.getName().equals(name)) {
				toy = t;
				break;
			}
		}
		return toy;
	}

	public void addToy() {
		
		
	}
	
	public void removeToy() {
		
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
	 * 
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
			
				if(typeChecker(serialNum) == "F") {
					ToyFormatting figure = new Figures(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6]);
					toys.add(figure);
				}
				if(typeChecker(serialNum) == "B") {
					ToyFormatting boardGame = new BoardGames(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toys.add(boardGame);
				}
				if(typeChecker(serialNum) == "A") {
					ToyFormatting animal = new Animals(splittedLine[0], splittedLine[1], splittedLine[2],
							Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]),
							Integer.parseInt(splittedLine[5]), splittedLine[6], splittedLine[7]);
					toys.add(animal);
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
		for (ToyFormatting t : toys) {
			if ((t.getName().toUpperCase()).contains(toyName.toUpperCase())) {
				toy = t;
				if (toy instanceof Puzzles)
				{
					Puzzles P = (Puzzles) toy;
					System.out.println(P.toString());
				}
				if (toy instanceof Animals)
				{
					Animals A = (Animals) toy;
					System.out.println(A.toString());
				}
				if (toy instanceof BoardGames)
				{
					BoardGames B = (BoardGames) toy;
					System.out.println(B.toString());
				}
				if (toy instanceof Figures)
				{
					Figures F = (Figures) toy;
					System.out.println(F.toString());
				}
			}
		}
	}
	
	public void toySearchByType() {
		
	}
}
