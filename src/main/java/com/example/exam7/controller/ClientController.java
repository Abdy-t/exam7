package com.example.exam7.controller;

import com.example.exam7.dto.ClientDTO;
import com.example.exam7.service.ClientService;
import com.example.exam7.service.UserAuthService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ClientController {
    private final UserAuthService userAuthService;
    private final ClientService clientService;

    public ClientController(UserAuthService userAuthService, ClientService clientService) {
        this.userAuthService=userAuthService;
        this.clientService=clientService;
    }

    @PostMapping(path="/register", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClientDTO registerClient(@RequestBody ClientDTO clientDTO) {
        return clientService.register(clientDTO);
    }
}
