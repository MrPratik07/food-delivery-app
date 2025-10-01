package com.pratik.fooddelivery.food_delivery_app.controller;

import com.pratik.fooddelivery.food_delivery_app.exceptions.InvalidIdException;
import com.pratik.fooddelivery.food_delivery_app.fooddetail.Food;
import com.pratik.fooddelivery.food_delivery_app.fooddetail.FoodDetailDao;
import com.pratik.fooddelivery.food_delivery_app.foodservice.FoodDetailServiceImpl;
import com.pratik.fooddelivery.food_delivery_app.jpa.food.FoodDataRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public ResponseEntity<?> getFoodItemList() {
        try {
            List<Food> fooditems = foodDetailService.allFoodDetails();

            if (fooditems.isEmpty()) {
                Map<String, Object> response = new HashMap<>();
                response.put("success", false);
                response.put("message", "No Food Items Present: ");
                response.put("data", null);
                return ResponseEntity.ok(response);
            } else {
                return ResponseEntity.ok(fooditems);

            }

        } catch (Exception e) {
            Map<String, Object> response = new HashMap<>();
            response.put("success", false);
            response.put("message", "Error while fetching food item: " + e.getMessage());
            response.put("data", null);
            return ResponseEntity.ok(response);
        }
    }

    @GetMapping("/food/{id}")
    public ResponseEntity<?> getFoodItemById(@PathVariable int id) throws InvalidIdException {
        Optional<Food> foodItem = foodDetailService.getFoodById(id);
        return foodItem.map(ResponseEntity::ok)
                .orElseThrow(() -> new InvalidIdException("Food item with id " + id + " not found"));

    }

    @PostMapping("/addFoodItem")
    public ResponseEntity<?> addNewFoodItem(@Valid @RequestBody Food food) {
        try {
            Food savedFoodItem = foodDetailService.saveFood(food);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedFoodItem.getName()+" added successfully");
        } catch (Exception e) {
            Map<String, Object> errorBody = new HashMap<>();
            errorBody.put("success", false);
            errorBody.put("message", "Failed to add food item: " + e.getMessage());
            errorBody.put("data", null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorBody);
        }
    }


    @PutMapping("/food/{id}")
    public ResponseEntity<?> updateFoodItem(@PathVariable int id, @Valid @RequestBody Food food) throws InvalidIdException {

            Food foodItem = foodDetailService.updateFood(id, food);
            if(Objects.nonNull(foodItem)) {
                return ResponseEntity.status(HttpStatus.CREATED).body("Food item with Id :" + foodItem.getId() + " update successfully");
            } else {
                throw new InvalidIdException("Food item with id " + id + " not found");
            }

    }

    @DeleteMapping("/food/{id}")
    public ResponseEntity<?> removeFoodItemById(@PathVariable int id) throws InvalidIdException {
            boolean isDeleted = foodDetailService.deleteFood(id);
            if(isDeleted) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Food item with Id :"+ id + " deleted successfully");
            } else {
                throw new InvalidIdException("Food item with id " + id + " not found");
            }
    }
}
