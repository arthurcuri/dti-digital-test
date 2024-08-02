package com.dtidigital.petshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.dtidigital.petshop.models.Petshop;
import com.dtidigital.petshop.repositories.PetshopRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PetshopRepository petshopRepository;

    @Override
    public void run(String... args) throws Exception {
        petshopRepository.save(new Petshop(null, "Meu Canino Feliz", 2.0, 20.0, 40.0, 24.0, 48.0));
        petshopRepository.save(new Petshop(null, "Vai Rex", 1.7, 15.0, 50.0, 20.0, 55.0));
        petshopRepository.save(new Petshop(null, "ChowChawgas", 0.8, 30.0, 45.0, 30.0, 45.0));
    }
}
