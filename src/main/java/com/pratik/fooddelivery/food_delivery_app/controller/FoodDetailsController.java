package com.pratik.fooddelivery.food_delivery_app.controller;

import com.pratik.fooddelivery.food_delivery_app.fooddetail.Food;
import com.pratik.fooddelivery.food_delivery_app.fooddetail.FoodDetailDao;
import com.pratik.fooddelivery.food_delivery_app.jpa.food.FoodDataRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FoodDetailsController {

    private FoodDetailDao foodDetailDao;

    private FoodDataRepository repository;

    public FoodDetailsController(FoodDetailDao foodDetailDao, FoodDataRepository repository) {
        this.foodDetailDao=foodDetailDao;
        this.repository=repository;
    }


    @GetMapping("/food")
    public List<Food> getFoodItemList() {
        return repository.findAll();
    }

    @GetMapping("/food/{id}")
    public Optional<Food> getFoodItemById(@PathVariable int id) {
        return repository.findById(id);
    }

    @PostMapping("/add")
    public void addNewFoodItem(@Valid @RequestBody Food food)  {
        repository.save(food);
    }

    @DeleteMapping("/food/{id}")
    public void removeFoodItemaaById(@PathVariable int id)  {
        repository.deleteById(id);
    }
}
