package com.example.caloriecounter.model;

public class FoodEntry {
    private String foodName;
    private double quantity;
    private double calories;
    private String date;

    public FoodEntry(String foodName, double quantity, double calories, String date) {
        this.foodName = foodName;
        this.quantity = quantity;
        this.calories = calories;
        this.date = date;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
