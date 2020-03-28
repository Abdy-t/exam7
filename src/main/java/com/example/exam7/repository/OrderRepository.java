package com.example.exam7.repository;

import com.example.exam7.model.Cafe;
import com.example.exam7.model.Client;
import com.example.exam7.model.Food;
import com.example.exam7.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, String> {
    Iterable<Order> findAllByClient(Client client);

}
