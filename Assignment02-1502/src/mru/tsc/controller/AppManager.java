package mru.tsc.controller;

import java.io.File;
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

	public void addToy() {
		
		
	}

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

	public void save() {
		
		
	}
	
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
}
