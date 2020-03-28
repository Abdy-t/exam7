package com.example.exam7.model;

import com.example.exam7.util.GenerateData;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Document(collection = "cafes")
@Data
public class Cafe {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    private String name;
    private String description;

    public static Cafe randomCafe() {
        return builder()
                .name(GenerateData.randomPlace().getName())
                .description(GenerateData.randomPlace().getDescription())
                .build();
    }
}
