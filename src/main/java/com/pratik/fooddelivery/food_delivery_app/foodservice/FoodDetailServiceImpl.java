package com.pratik.fooddelivery.food_delivery_app.foodservice;

import com.pratik.fooddelivery.food_delivery_app.fooddetail.Food;
import com.pratik.fooddelivery.food_delivery_app.fooddetail.FoodDetailDao;
import com.pratik.fooddelivery.food_delivery_app.jpa.food.FoodDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodDetailServiceImpl {

    private FoodDetailDao foodDetailDao;

    @Autowired
    private FoodDataRepository repository;

    public  void saveFood(Food food) {
        repository.save(food);
    }

    public List<Food> allFoodDetails() {
        return repository.findAll();
    }

    public Optional<Food> getFoodById(int id) {
        return repository.findById(id);
    }

    public void deleteFood(int id) {
        repository.deleteById(id);
    }

}
