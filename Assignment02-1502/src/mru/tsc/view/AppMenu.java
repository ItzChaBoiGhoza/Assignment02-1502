package mru.tsc.view;

import java.util.Scanner;

import mru.tsc.model.ToyFormatting;

public class AppMenu {
Scanner input;
	
	public AppMenu() {
		input = new Scanner(System.in);
	}
	
	public int showAppMenu() {
		System.out.println("Welcome to Toy Store Company");
		System.out.println("\nHow We May Help You?");
		System.out.println("\n\t(1) Search Inventory and Purchase Toy");
		System.out.println("\t(2) Add New Toy");
		System.out.println("\t(3) Remove Toy");
		System.out.println("\t(4) Save & Exit");
		System.out.print("\nEnter Option: ");
		
		int option = input.nextInt();
		input.nextLine();
		return option;
	}
	
	public int showSubMenu() {
		System.out.println("\nSearch Toy With: ");
		System.out.println("\n\t(1) Serial Number (SN)");
		System.out.println("\t(2) Toy Name");
		System.out.println("\t(3) Type");
		System.out.println("\t(4) Back to Main Menu");
		System.out.print("\nEnter Option: ");
		
		int option = input.nextInt();
		input.nextLine();
		return option;
	}
	
	public String promptSerialNumber() {
		System.out.print("\nEnter Toy Serial Number: ");
		String serialNum = input.nextLine().trim();
		return serialNum;
	}
	
	public void showSerialNumber(ToyFormatting toySerialNum) throws Exception{
		if(toySerialNum != null) {
			System.out.print(toySerialNum);
			System.out.println(" ");
		} else {
			System.out.println("Toy not Found");
		}
	}
	
	public String promptToyName() {
		System.out.print("\nEnter Toy Name: ");
		String name = input.nextLine().trim();
		return name;
	}
	
	public void showName(ToyFormatting toyName) throws Exception{
		if(toyName != null) {
			System.out.print(toyName);
		} else {
			System.out.println("Toy not Found");
		}
	}
	
	public char promptType() {
		System.out.println("\nSearch the Type of Toy: ");
		System.out.println("\n\t(A) Animals");
		System.out.println("\t(B) Board Games");
		System.out.println("\t(F) Figures");
		System.out.println("\t(P) Puzzles");
		System.out.println("\t(E) Exit to Sub Menu");
		System.out.print("\nEnter Toy Type: ");
		
		char option = input.nextLine().toUpperCase().charAt(0);
		return option;
	}
	
	public char promptRemoveToy() {
		System.out.println("Do you want to delete this toy? (Y/N)");
		System.out.print("Enter option: ");
		char option = input.nextLine().toUpperCase().charAt(0);
		return option;
	}
}
