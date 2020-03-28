package com.example.exam7.dto;

import com.example.exam7.model.Client;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ClientDTO {

    public static ClientDTO from(Client client) {
        return builder()
                .id(client.getId())
                .name(client.getName())
                .password(client.getPassword())
                .email(client.getEmail())
                .build();
    }

    private String id;
    private String name;
    private String password;
    private String email;
}
