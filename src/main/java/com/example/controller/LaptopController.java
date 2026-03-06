package com.example.controller;

import com.example.model.Laptop;
import com.example.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptops")
public class LaptopController {

    @Autowired
    private LaptopService service;

    // CREATE
    @PostMapping("/addLaptop")
    public Laptop addLaptop(@RequestBody Laptop laptop) {
        return service.addLaptop(laptop);
    }

    // READ ALL
    @GetMapping
    public List<Laptop> getAllLaptops() {
        return service.getAllLaptops();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public Laptop getLaptopById(@PathVariable Integer id) {
        return service.getLaptopById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Laptop updateLaptop(@PathVariable Integer id,
                               @RequestBody Laptop laptop) {
        return service.updateLaptop(id, laptop);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteLaptop(@PathVariable Integer id) {
        service.deleteLaptop(id);
        return "Laptop deleted successfully";
    }

    // FIND BY BRAND
    @GetMapping("/brand/{brand}")
    public List<Laptop> getByBrand(@PathVariable String brand) {
        return service.getByBrand(brand);
    }
}