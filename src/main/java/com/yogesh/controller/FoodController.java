package com.yogesh.controller;

import com.yogesh.Service.FoodService;
import com.yogesh.Service.RestaurantService;
import com.yogesh.Service.UserService;
import com.yogesh.model.Food;
import com.yogesh.model.Restaurant;
import com.yogesh.model.User;
import com.yogesh.request.CreateFoodRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/search")
    public ResponseEntity<List<Food>> searchFood(@RequestParam String name,
                                                @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);
        List<Food> food=foodService.searchFood(name);
        return  new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @GetMapping("/restaurant/restaurantId")
    public ResponseEntity<List<Food>> getRestaurantFood(
            @RequestParam boolean vagetarian,
            @RequestParam boolean seasonal,
            @RequestParam boolean nonveg,
            @RequestParam(required = false) String food_category,
            @PathVariable Long restaurantId,

            @RequestHeader("Authorization") String jwt) throws Exception {
        User user=userService.findUserByJwtToken(jwt);

        List<Food> food=foodService.getRestaurantsFood(restaurantId,vagetarian,nonveg,seasonal,food_category);

        return  new ResponseEntity<>(food, HttpStatus.OK);
    }
}
