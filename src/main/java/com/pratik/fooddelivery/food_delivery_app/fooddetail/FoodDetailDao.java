package com.pratik.fooddelivery.food_delivery_app.fooddetail;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class FoodDetailDao {

    private static List<Food> foodList = new ArrayList<>();

    private static int FoodItemCount = 0;

    static {
        foodList.add(new Food(++FoodItemCount,"Pizza",100));
        foodList.add(new Food(++FoodItemCount,"Burger",50));
        foodList.add(new Food(++FoodItemCount,"Pasta",150));
    }

    public List<Food> findAll() {
        return foodList;
    }

    public Food findById(int id){
        Predicate<Food> predicate = food -> food.getId().equals(id);
    return foodList.stream().filter(predicate).findFirst().get();
    }

    public void saveNewItem(Food food) {
        food.setId(++FoodItemCount);
        foodList.add(food);
    }

    public void removeFoodItem(int id) {
        Predicate<Food> predicate = food -> food.getId().equals(id);
        foodList.removeIf(predicate);
    }
}
