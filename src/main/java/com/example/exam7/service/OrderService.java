package com.example.exam7.service;

import com.example.exam7.dto.FoodDTO;
import com.example.exam7.dto.OrderDTO;
import com.example.exam7.model.Food;
import com.example.exam7.model.Order;
import com.example.exam7.repository.CafeRepository;
import com.example.exam7.repository.ClientRepository;
import com.example.exam7.repository.FoodRepository;
import com.example.exam7.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final FoodRepository foodRepository;
    private final CafeRepository cafeRepository;

    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository, FoodRepository foodRepository, CafeRepository cafeRepository){
        this.orderRepository=orderRepository;
        this.clientRepository=clientRepository;
        this.foodRepository=foodRepository;
        this.cafeRepository=cafeRepository;
    }

    public OrderDTO addOrder(String idC, String idF) {
        LocalDate time = LocalDate.now();
        var order = Order.builder()
                .client(clientRepository.getById(idC))
                .food(foodRepository.getById(idF))
                .time(time)
                .build();
        orderRepository.save(order);
        return OrderDTO.from(order);
    }

    public Slice<OrderDTO> getClientOrders(String idC, Pageable pageable) {
        var client = clientRepository.getById(idC);
        Iterable<Order> orders = orderRepository.findAllByClient(client);
        List<Order> orderList = new ArrayList<>();
        orders.forEach(orderList::add);
        Page<Order> page = new PageImpl<>(orderList, pageable, orderList.size());
        return page.map(OrderDTO::from);
    }
}
