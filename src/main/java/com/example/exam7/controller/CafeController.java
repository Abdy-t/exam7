package com.example.exam7.controller;

import com.example.exam7.annotations.ApiPageable;
import com.example.exam7.dto.CafeDTO;
import com.example.exam7.dto.FoodDTO;
import com.example.exam7.service.CafeService;
import com.example.exam7.service.FoodService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@RequestMapping("/cafe")
public class CafeController {
    private final CafeService cafeService;
    private final FoodService foodService;

    public CafeController(CafeService cafeService, FoodService foodService) {
        this.cafeService=cafeService;
        this.foodService=foodService;
    }

    @ApiPageable
    @GetMapping
    public Slice<CafeDTO> allCafes(@ApiIgnore Pageable pageable) {
        return cafeService.getAllCafes(pageable);
    }

    @ApiPageable
    @GetMapping("/{idCafe}")
    public Slice<FoodDTO> listOfDishes(@PathVariable String idCafe, @ApiIgnore Pageable pageable) {
        return foodService.getListOfDishes(idCafe, pageable);
    }
}
