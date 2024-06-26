package com.pratik.fooddelivery.food_delivery_app.jpa;

import com.pratik.fooddelivery.food_delivery_app.fooddetail.Food;
import com.pratik.fooddelivery.food_delivery_app.jpa.food.FoodDataRepository;
import com.pratik.fooddelivery.food_delivery_app.jpa.user.UserDataRepository;
import com.pratik.fooddelivery.food_delivery_app.userdetail.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class FoodJpaCommandLineRunner implements CommandLineRunner {

    @Autowired
    private FoodDataRepository foodDataRepository;

    @Autowired
    private UserDataRepository userDataRepository;

    @Override
    public void run(String... args) throws Exception {
        foodDataRepository.save(new Food(1,"pizza",100));
        foodDataRepository.save(new Food(2,"juice",150));
        foodDataRepository.save(new Food(3,"burger",200));
        foodDataRepository.save(new Food(4,"pasta",200));

       //userDataRepository.save(new User(1,"i am posting this blog"));

    }
}
