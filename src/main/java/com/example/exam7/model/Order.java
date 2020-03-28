package com.example.exam7.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@Document(collection = "orders")
@Data
public class Order {
    @Id
    @Builder.Default
    private String id = UUID.randomUUID().toString();
    @DBRef
    private Client client;
    @DBRef
    private Food food;
    private LocalDate time;
}
