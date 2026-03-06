package com.example.service;

import com.example.model.Laptop;
import com.example.repository.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepository repository;

    public Laptop addLaptop(Laptop laptop) {
        return repository.save(laptop);
    }

    public List<Laptop> getAllLaptops() {
        return repository.findAll();
    }

    public Laptop getLaptopById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Laptop not found with id: " + id));
    }

    public Laptop updateLaptop(Integer id, Laptop newLaptop) {

        Laptop existing = getLaptopById(id);

        existing.setName(newLaptop.getName());
        existing.setBrand(newLaptop.getBrand());
        existing.setPrice(newLaptop.getPrice());
        existing.setRam(newLaptop.getRam());

        return repository.save(existing);
    }

    public void deleteLaptop(Integer id) {
        repository.deleteById(id);
    }

    public List<Laptop> getByBrand(String brand) {
        return repository.findByBrand(brand);
    }
}