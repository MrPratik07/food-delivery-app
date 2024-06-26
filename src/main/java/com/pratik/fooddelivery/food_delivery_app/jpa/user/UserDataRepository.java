package com.pratik.fooddelivery.food_delivery_app.jpa.user;

import com.pratik.fooddelivery.food_delivery_app.userdetail.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataRepository extends JpaRepository<User,Integer> {
}
