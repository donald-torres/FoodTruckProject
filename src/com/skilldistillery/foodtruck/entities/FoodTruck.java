package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private static int nextTruckId = 1110;
	private int currentTruckId;
	private String foodTruckName;
	private String foodTruckFood;
	private int foodTruckRating;

	public FoodTruck(String foodTruckName, String foodTruckFood, int foodTruckRating) {
		this.foodTruckName = foodTruckName;
		this.foodTruckFood = foodTruckFood;
		this.foodTruckRating = foodTruckRating;
	}

	public void setNextTruckId() {
		this.currentTruckId = nextTruckId;
		nextTruckId++;
	}

	public int getTruckId() {
		return this.currentTruckId;
	}

	public String getFoodTruckName() {
		return foodTruckName;
	}

	public void setFoodTruckName(String foodTruckName) {
		this.foodTruckName = foodTruckName;
	}

	public String getFoodTruckFood() {
		return foodTruckFood;
	}

	public void setFoodTruckFood(String foodTruckFood) {
		this.foodTruckFood = foodTruckFood;
	}

	public int getFoodTruckRating() {
		return foodTruckRating;
	}

	public void setFoodTruckRating(int foodTruckRating) {
		this.foodTruckRating = foodTruckRating;
	}

	@Override
	public String toString() {
		return "\nName of truck: " + foodTruckName + ", Food truck serves: " + foodTruckFood + ", Rating: "
				+ foodTruckRating + ", Truck ID number: " + getTruckId();
	}

}
