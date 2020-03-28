package com.example.exam7.dto;

import com.example.exam7.model.Cafe;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CafeDTO {

    public static CafeDTO from(Cafe cafe) {
        return builder()
                .id(cafe.getId())
                .name(cafe.getName())
                .description(cafe.getDescription())
                .build();
    }

    private String id;
    private String name;
    private String description;
}
