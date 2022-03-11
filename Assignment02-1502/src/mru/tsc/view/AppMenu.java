package mru.tsc.view;

import java.util.Scanner;

import mru.tsc.model.ToyFormatting;

/**
 * Display the menus
 * @author Denzel Pascual & Ghoza Ghozali
 *
 */
public class AppMenu {
Scanner input;
	
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	/**
	 * This method shows the main menu of the app
	 * 
	 * @return Returns an integer
	 */
	public int showAppMenu() {
		System.out.println("Welcome to Toy Store Company");
		System.out.println("\nHow May We Help You?");
		System.out.println("\n\t(1) Search Inventory and Purchase Toy");
		System.out.println("\t(2) Add New Toy");
		System.out.println("\t(3) Remove Toy");
		System.out.println("\t(4) Save & Exit");
		System.out.println("");
		System.out.print("Enter Option: ");
		
		int option = input.nextInt();
		input.nextLine();
		return option;
	}
	
	/**
	 * This methods shows the subMenu to the user
	 * 
	 * @return Returns an integer entered by the user
	 */
	public int showSubMenu() {
		System.out.println("\nFind Toys With: ");
		System.out.println("\n\t(1) Serial Number (SN)");
		System.out.println("\t(2) Toy Name");
		System.out.println("\t(3) Type");
		System.out.println("\t(4) Back to Main Menu");
		System.out.println("");
		System.out.print("Enter Option: ");
		
		int option = input.nextInt();
		input.nextLine();
		return option;
	}
	
	/**
	 * Prompts the user for a Serial Number
	 * 
	 * @return
	 */
	public String promptSerialNumber() {
		System.out.print("\nEnter Toy Serial Number: ");
		String serialNum = input.nextLine().trim();
		return serialNum;
	}
	
	/**
	 * This method checks if the serial number is valid
	 * if toySerialNum does not equal null print it out
	 * otherwise print "Serial number not found"
	 * @param toySerialNum
	 * @throws Exception
	 */
	public void showSerialNumber(ToyFormatting toySerialNum) throws Exception{
		if(toySerialNum != null) {
			System.out.print(toySerialNum);
		} else {
			System.out.println("Serial Number not Found");
		}
	}
	
	/**
	 * Prompts the user for the toy name
	 * @return
	 */
	public String promptToyName() {
		System.out.print("\nEnter Toy Name: ");
		String name = input.nextLine().trim();
		return name;
	}
	
	/**
	 * This method checks if the name is valid.
	 * if toyName does not equal null print it out
	 * otherwise print "Toy not found"
	 * 
	 * @param toyName
	 * @throws Exception
	 */
	public void showName(ToyFormatting toyName) throws Exception{
		if(toyName != null) {
			System.out.print(toyName);
		} else {
			System.out.println("Toy not Found");
		}
	}
	
	/**
	 * Prompts the user for what type of toy they are looking for
	 * by using char
	 * 
	 * @return Returns a char
	 */
	public char promptType() {
		System.out.println("\nFind the Type of Toy: ");
		System.out.println("\n\t(A) Animal");
		System.out.println("\t(F) Figure");
		System.out.println("\t(P) Puzzle");
		System.out.println("\t(B) Board Game");
		System.out.println("");
		System.out.print("Enter Toy Type: ");
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}
}
