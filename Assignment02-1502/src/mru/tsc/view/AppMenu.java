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
		System.out.print("Enter Option: ");
		
		int option = input.nextInt();
		input.nextLine();
		return option;
	}
	
	public int showSubMenu() {
		System.out.println("\nFind Toys With: ");
		System.out.println("\n\t(1) Serial Number (SN)");
		System.out.println("\t(2) Toy Name");
		System.out.println("\t(3) Type");
		System.out.println("\t(4) Back to Main Menu");
		System.out.print("Enter Option: ");
		
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
			System.out.println(toySerialNum);
		} else {
			System.out.println("Serial Number not found");
		}
	}
	
	public String promptToyName() {
		System.out.print("\nEnter Toy Name: ");
		String name = input.nextLine();
		return name;
	}
	
	public void showName(ToyFormatting toyName) throws Exception{
		if(toyName != null) {
			System.out.println(toyName);
		} else {
			System.out.println("Toy not found");
		}
	}
	
	public char promptType() {
		System.out.println("\nFind the Type of Toy: ");
		System.out.println("\n\t(A) Animal");
		System.out.println("\t(F) Figure");
		System.out.println("\t(P) Puzzle");
		System.out.println("\t(B) Board Game");
		System.out.print("Enter Toy Type: ");
		char option = input.nextLine().toLowerCase().charAt(0);
		return option;
	}
	
	public void showType(ToyFormatting toyType) {
		if(toyType != null) {
			
		}
	}
}
