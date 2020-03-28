package com.example.exam7.repository;

import com.example.exam7.model.Cafe;
import com.example.exam7.model.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, String> {
    Iterable<Food> findAllByCafe(Cafe cafe);
    Food getById(String id);
}
