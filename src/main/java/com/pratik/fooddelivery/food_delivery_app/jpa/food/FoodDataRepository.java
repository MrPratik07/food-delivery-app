package com.pratik.fooddelivery.food_delivery_app.jpa.food;

import com.pratik.fooddelivery.food_delivery_app.fooddetail.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodDataRepository extends JpaRepository<Food, Integer> {
}
