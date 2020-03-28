package com.example.exam7.controller;

import com.example.exam7.annotations.ApiPageable;
import com.example.exam7.dto.OrderDTO;
import com.example.exam7.service.CafeService;
import com.example.exam7.service.ClientService;
import com.example.exam7.service.FoodService;
import com.example.exam7.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;
    private final CafeService cafeService;
    private final FoodService foodService;
    private final ClientService clientService;



    public OrderController(OrderService orderService, CafeService cafeService, FoodService foodService, ClientService clientService) {
        this.orderService=orderService;
        this.cafeService=cafeService;
        this.foodService=foodService;
        this.clientService=clientService;
    }

    @PostMapping(path = "/{idFood}")
    public OrderDTO addOrder(@PathVariable String idFood) {
        var client = clientService.getClient();
        String id = client.getId();
        var orderDTO = orderService.addOrder(id, idFood);
        return orderDTO;
    }

    @ApiPageable
    @GetMapping
    public Slice<OrderDTO> getClientOrders(@ApiIgnore Pageable pageable) {
        var client = clientService.getClient();
        String id = client.getId();
        return orderService.getClientOrders(id, pageable);
    }
}
