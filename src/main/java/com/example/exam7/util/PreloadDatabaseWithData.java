package com.example.exam7.util;

import com.example.exam7.model.Cafe;
import com.example.exam7.model.Client;
import com.example.exam7.model.Food;
import com.example.exam7.repository.CafeRepository;
import com.example.exam7.repository.ClientRepository;
import com.example.exam7.repository.FoodRepository;
import com.example.exam7.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Configuration
public class PreloadDatabaseWithData {
    Random rand = new Random();
    @Bean
    CommandLineRunner initDatabase(ClientRepository clientRepository, CafeRepository cafeRepository, FoodRepository foodRepository, OrderRepository orderRepository) {
        return(args) -> {
            clientRepository.deleteAll();
            cafeRepository.deleteAll();
            foodRepository.deleteAll();
            orderRepository.deleteAll();
            List<Client> users = Stream.generate(Client::randomClient)
                    .limit(10)
                    .collect(toList());
            clientRepository.saveAll(users);
            List<Cafe> cafes = Stream.generate(Cafe::randomCafe)
                    .limit(10)
                    .collect(toList());
            cafeRepository.saveAll(cafes);
            List<Food> foods = Stream.generate(() -> Food.randomFood(cafes.get(rand.nextInt(cafes.size()))))
                    .limit(20)
                    .collect(toList());
            foodRepository.saveAll(foods);

//            List<Client> posts = Stream.generate(() -> Client.addClient(users.get(r.nextInt(users.size()))))
//                    .limit(10)
//                    .collect(toList());
//            IntStream.range(0, 5).forEachOrdered(i -> clients.add(new Client(i + "id" , GenerateData.randomPersonName(),GenerateData.randomEmail())));
//            clientRepository.saveAll(clients);

//            List<Users> users = Stream.generate(Users::random)
//                    .limit(10)
//                    .collect(toList());
//            ur.saveAll(users);
//
//            List<Publication> posts = Stream.generate(() -> Publication.addPost(users.get(r.nextInt(users.size()))))
//                    .limit(10)
//                    .collect(toList());
//            pr.saveAll(posts);
//
//            List<Comment> comments = Stream.generate(() -> Comment.addComment(users.get(r.nextInt(users.size())), posts.get(r.nextInt(posts.size()))))
//                    .limit(10)
//                    .collect(toList());
//            cr.saveAll(comments);
//            System.out.println("done");
        };
    }
}
