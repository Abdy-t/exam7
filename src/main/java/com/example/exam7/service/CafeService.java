package com.example.exam7.service;

import com.example.exam7.dto.CafeDTO;
import com.example.exam7.model.Cafe;
import com.example.exam7.repository.CafeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
public class CafeService {
    private final CafeRepository cafeRepository;

    public CafeService(CafeRepository cafeRepository) {
        this.cafeRepository = cafeRepository;
    }

    public Slice<CafeDTO> getAllCafes(Pageable pageable) {
        Page<Cafe> slice = cafeRepository.findAll(pageable);
        return slice.map(CafeDTO::from);
    }
}
