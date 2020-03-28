package com.example.exam7.repository;

import com.example.exam7.model.Cafe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CafeRepository extends PagingAndSortingRepository<Cafe, String> {
    Cafe getById(String id);
}
