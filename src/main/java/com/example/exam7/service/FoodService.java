package com.example.exam7.service;

import com.example.exam7.dto.FoodDTO;
import com.example.exam7.model.Cafe;
import com.example.exam7.model.Food;
import com.example.exam7.repository.CafeRepository;
import com.example.exam7.repository.FoodRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodService {
    private final CafeRepository cafeRepository;
    private final FoodRepository foodRepository;


    public FoodService(CafeRepository cafeRepository, FoodRepository foodRepository) {
        this.cafeRepository=cafeRepository;
        this.foodRepository=foodRepository;
    }

    public Slice<FoodDTO> getListOfDishes(String idCafe, Pageable pageable) {
        Cafe cafe = cafeRepository.getById(idCafe);
        var foods = foodRepository.findAllByCafe(cafe);
        List<Food> foodList = new ArrayList<>();
        foods.forEach(foodList::add);
        Page<Food> page = new PageImpl<>(foodList, pageable, foodList.size());
        return page.map(FoodDTO::from);
    }
}
