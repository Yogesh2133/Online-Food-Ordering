package com.yogesh.Service;

import com.yogesh.model.Category;
import com.yogesh.model.Food;
import com.yogesh.model.Restaurant;
import com.yogesh.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    public Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
    void  deleteFood(Long foodId) throws  Exception;
    public List<Food> getRestaurantsFood(Long restaurantId,
                                         boolean isVegetarian,
                                         boolean isNonveg,
                                         boolean isSeasonal,
                                         String foodCategory);
    public  List<Food>searchFood(String keyword);
    public Food findFoodById(Long foodId)throws Exception;
    public Food updateAvailabilityStatus(Long foodId) throws Exception;

}
