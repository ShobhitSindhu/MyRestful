package com.example.repository;

import com.example.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LaptopRepository extends JpaRepository<Laptop, Integer> {

    // Spring Data JPA auto-generates query
    List<Laptop> findByBrand(String brand);
}