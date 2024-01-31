package com.example.digmenu.controller;

import com.example.digmenu.food.Food;
import com.example.digmenu.food.FoodRepository;
import com.example.digmenu.food.FoodRequestDTO;
import com.example.digmenu.food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public List<FoodResponseDTO> getAll() {
        return foodRepository.findAll().stream().map(FoodResponseDTO::new).toList();
    }

    @PostMapping
    public void insert(@RequestBody FoodRequestDTO data) {
        Food food = new Food(data);
        foodRepository.save(food);
        return;
    }
}
