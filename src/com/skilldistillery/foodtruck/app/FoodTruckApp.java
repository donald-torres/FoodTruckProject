package com.skilldistillery.foodtruck.app;

import java.util.Scanner;

import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {
	Scanner kb = new Scanner(System.in);
	private FoodTruck[] fleet = new FoodTruck[5];
	private String userName;
	private String userFood;
	private int userRate;
	private int numTrk = 0;

	public static void main(String[] args) {

		FoodTruckApp fta = new FoodTruckApp();
		fta.run();

	}

	public void run() {
		System.out.println("Hello and welcome to Rate My Taste ");

		for (int i = 0; i < fleet.length; i++) {
			System.out.print("Please enter in the name(s) of up to 5 Food Trucks or type quit to move on: ");
			userName = kb.nextLine();
			if (userName.equals("quit") || userName.equals("QUIT") || userName.equals("Quit"))
				break;

			System.out.print("Please enter what food that Food Truck sells: ");
			userFood = kb.nextLine();

			System.out.print("What would you rate that Food Truck from 1 to 5 stars: ");
			userRate = kb.nextInt();
			kb.nextLine();

			FoodTruck truck = new FoodTruck(userName, userFood, userRate);
			fleet[i] = truck;
			numTrk++;
			truck.setNextTruckId();

		}
		menu();
		int userMenu;
		do {
			userMenu = kb.nextInt();

			switch (userMenu) {
			case 1:
				allTrucks();
				break;
			case 2:
				truckAverage();
				break;
			case 3:
				highestRating();
				break;
			case 4:
				System.out.println("Goodbye!");
				kb.close();
				System.exit(0);
			default:
				System.out.println("Invalid Entry");
			}
			menu();
		} while (userMenu != 4);

	}

	private void allTrucks() {
		FoodTruck[] allListedTrucks = new FoodTruck[numTrk];
		for (int spot = 0; spot < fleet.length; spot++) {
			if (fleet[spot] != null) {
				allListedTrucks[spot] = fleet[spot];
			} else {
				break;
			}
			System.out.println(allListedTrucks[spot]);
		}
	}

	private void truckAverage() {
		double theAverage = 0.0;
		double sum = 0.0;
		for (int spot = 0; spot < fleet.length; spot++) {
			if (fleet[spot] != null) {
				sum += fleet[spot].getFoodTruckRating();
			} else {
				break;
			}
			theAverage = sum / numTrk;
		}
		System.out.printf("The average is %.1f\n", theAverage);

	}

	private void highestRating() {
		int rate = 0;
		int bigRate = 1;
		int highSpot = 0;
		for (int spot = 0; spot < fleet.length; spot++) {
			if (fleet[spot] != null) {
				rate = fleet[spot].getFoodTruckRating();
				if (rate >= bigRate) {
					bigRate = rate;
					highSpot = spot;
				}
			} else {
				break;
			}

		}
		System.out.println("The Highest rating is " + bigRate + " for " + fleet[highSpot]);

	}

	private void menu() {
		System.out.println();
		System.out.println("     Choose from the following options.     ");
		System.out.println("////////////////////////////////////////////");
		System.out.println("////////////////////////////////////////////");
		System.out.println("////////////////////////////////////////////");
		System.out.println("/ 1. List all Existing food trucks.        /");
		System.out.println("/ 2. See the average rating of food trucks./");
		System.out.println("/ 3. Display highest-rated food truck.     /");
		System.out.println("/ 4. Quit the program.                     /");
		System.out.println("////////////////////////////////////////////");
		System.out.println("////////////////////////////////////////////");
		System.out.println("////////////////////////////////////////////");
	}

}
