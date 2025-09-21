package com.pratik.fooddelivery.food_delivery_app.foodservice;

import com.pratik.fooddelivery.food_delivery_app.fooddetail.Food;
import com.pratik.fooddelivery.food_delivery_app.fooddetail.FoodDetailDao;
import com.pratik.fooddelivery.food_delivery_app.jpa.food.FoodDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodDetailServiceImpl {

    private static final Logger logger = LoggerFactory.getLogger(FoodDetailServiceImpl.class);

    private FoodDetailDao foodDetailDao;

    @Autowired
    private FoodDataRepository repository;

    public Food saveFood(Food food) {
        try {
            repository.save(food);
        } catch (Exception e) {
            logger.info("error while saving food item", e);
        }
        return food;
    }

    public List<Food> allFoodDetails() {
        return repository.findAll();
    }

    public Optional<Food> getFoodById(int id) {
        return repository.findById(id);
    }

    public boolean deleteFood(int id) {
        boolean deleted = false;
        Optional<Food> fooditem = repository.findById(id);
        if(fooditem.isPresent()) {
            repository.deleteById(id);
            deleted = true;
        }
        return deleted;
    }

    public Food updateFood(int id, Food updatedItem) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(updatedItem.getName());
                    existing.setPrice(updatedItem.getPrice());
                    return repository.save(existing);
                })
                .orElse(null);
        }
    }


