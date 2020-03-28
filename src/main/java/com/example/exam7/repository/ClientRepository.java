package com.example.exam7.repository;

import com.example.exam7.model.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, String> {
    Optional<Client> findByEmail(String email);
    Client getById(String id);
}
