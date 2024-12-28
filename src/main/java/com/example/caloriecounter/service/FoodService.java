package com.example.caloriecounter.service;

import com.example.caloriecounter.model.FoodEntry;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodService {
    private final Map<String, List<FoodEntry>> foodLog = new HashMap<>();
    private final Map<String, Integer> foodDatabase = new HashMap<>();

    public FoodService() {
        foodDatabase.put("apple", 52);
        foodDatabase.put("banana", 96);
        foodDatabase.put("chicken breast", 165);
        foodDatabase.put("rice", 130);
        foodDatabase.put("bread", 265);
        foodDatabase.put("egg", 155);
    }

    public void addFoodEntry(String date, String foodName, double quantity) {
        double calories = (foodDatabase.getOrDefault(foodName, 0) / 100.0) * quantity;
        FoodEntry entry = new FoodEntry(foodName, quantity, calories, date);

        foodLog.putIfAbsent(date, new ArrayList<>());
        foodLog.get(date).add(entry);
    }

    public List<FoodEntry> getFoodEntriesByDate(String date) {
        return foodLog.getOrDefault(date, new ArrayList<>());
    }
}
