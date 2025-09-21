package com.pratik.fooddelivery.food_delivery_app.controller;

import com.pratik.fooddelivery.food_delivery_app.fooddetail.Food;
import com.pratik.fooddelivery.food_delivery_app.fooddetail.FoodDetailDao;
import com.pratik.fooddelivery.food_delivery_app.foodservice.FoodDetailServiceImpl;
import com.pratik.fooddelivery.food_delivery_app.jpa.food.FoodDataRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodDetailsController {

    private FoodDetailDao foodDetailDao;

    private FoodDataRepository repository;

    private FoodDetailServiceImpl foodDetailService;

    public FoodDetailsController(FoodDetailDao foodDetailDao, FoodDataRepository repository, FoodDetailServiceImpl foodDetailService) {
        this.foodDetailDao=foodDetailDao;
        this.repository=repository;
        this.foodDetailService=foodDetailService;
    }


    @GetMapping("/food")
    public List<Food> getFoodItemList() {
        return foodDetailService.allFoodDetails();
    }

    @GetMapping("/food/{id}")
    public Optional<Food> getFoodItemById(@PathVariable int id) {
        return foodDetailService.getFoodById(id);
    }

    @PostMapping("/add")
    public void addNewFoodItem(@Valid @RequestBody Food food)  {
        foodDetailService.saveFood(food);
        }

    @DeleteMapping("/food/{id}")
    public void removeFoodItemById(@PathVariable int id)  {
        foodDetailService.deleteFood(id);
    }
}
