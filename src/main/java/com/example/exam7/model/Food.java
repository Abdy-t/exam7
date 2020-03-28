package com.example.exam7.model;

import com.example.exam7.util.GenerateData;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;
import java.util.UUID;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Document(collection = "foods")
@Data
public class Food {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String name;
    private String type;
    private int price;
    @DBRef
    private Cafe cafe;
    private static final Random r = new Random();

    public static Food randomFood(Cafe cafe) {
        return builder()
                .name(GenerateData.randomDish().getName())
                .type(GenerateData.randomDish().getType())
                .price(r.nextInt(100) + 50)
                .cafe(cafe)
                .build();
    }

}
