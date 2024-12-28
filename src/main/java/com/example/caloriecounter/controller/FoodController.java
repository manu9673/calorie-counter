package com.example.caloriecounter.controller;

import com.example.caloriecounter.model.FoodEntry;
import com.example.caloriecounter.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/addFood")
    @ResponseBody
    public String addFood(@RequestParam String date, @RequestParam String foodName, @RequestParam double quantity) {
        foodService.addFoodEntry(date, foodName, quantity);
        return "Food added successfully!";
    }

    @GetMapping("/getLog")
    @ResponseBody
    public List<FoodEntry> getLog(@RequestParam String date) {
        return foodService.getFoodEntriesByDate(date);
    }
}
