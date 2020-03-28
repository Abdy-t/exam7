package com.example.exam7.service;

import com.example.exam7.dto.ClientDTO;
import com.example.exam7.model.Client;
import com.example.exam7.repository.ClientRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository=clientRepository;
    }

    public Client getClient() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return clientRepository.findByEmail(auth.getName()).get();
    }

    public ClientDTO register(ClientDTO clientDTO) {
        if (clientRepository.existsByEmail(clientDTO.getEmail())) {
            var user = Client.builder()
                    .name("Try again")
                    .email("A client with " + clientDTO.getEmail() + " email already exists")
                    .password("***")
                    .build();
            return ClientDTO.from(user);
        } else {
            var user = Client.builder()
                    .name(clientDTO.getName())
                    .email(clientDTO.getEmail())
                    .password(new BCryptPasswordEncoder().encode(clientDTO.getPassword()))
                    .build();
            clientRepository.save(user);
            return ClientDTO.from(user);
        }
    }
}
