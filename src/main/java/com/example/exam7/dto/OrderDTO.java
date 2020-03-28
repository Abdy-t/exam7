package com.example.exam7.dto;

import com.example.exam7.model.Order;
import lombok.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class OrderDTO {


    public static OrderDTO from(Order order) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String strDate = order.getTime().toString();
        String clientEmail = order.getClient().getEmail();
        String foodName = order.getFood().getName();
        return builder()
                .id(order.getId())
                .clientId(order.getClient().getId())
                .clientEmail(clientEmail)
                .foodId(order.getFood().getId())
                .foodName(foodName)
                .time(strDate)
                .build();
    }

    private String id;
    private String clientId;
    private String clientEmail;
    private String foodId;
    private String foodName;
    private String time;

}
