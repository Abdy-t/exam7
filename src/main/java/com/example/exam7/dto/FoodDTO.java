package com.example.exam7.dto;

import com.example.exam7.model.Food;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class FoodDTO {

    public static FoodDTO from(Food food) {
        return builder()
                .id(food.getId())
                .name(food.getName())
                .type(food.getType())
                .price(food.getPrice())
                .cafe(food.getCafe().getId())
                .build();
    }

    private String id;
    private String name;
    private String type;
    private int price;
    private String cafe;
}
