package com.dtidigital.petshop.services;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dtidigital.petshop.models.Petshop;
import com.dtidigital.petshop.repositories.PetshopRepository;

@Service
public class PetshopService {

    @Autowired
    private PetshopRepository petshopRepository;

    public Petshop findBestPetshop(LocalDate date, int smallDogs, int largeDogs) {
        List<Petshop> petshops = petshopRepository.findAll();
        Petshop bestPetshop = null;
        double bestPrice = Double.MAX_VALUE;

        boolean isWeekend = isWeekend(date);

        for (Petshop petshop : petshops) {
            double totalPrice = calculatePrice(petshop, isWeekend, smallDogs, largeDogs);

            if (totalPrice < bestPrice || (totalPrice == bestPrice && petshop.getDistance() < bestPetshop.getDistance())) {
                bestPrice = totalPrice;
                bestPetshop = petshop;
            }
        }

        return bestPetshop;
    }

    public double calculatePrice(Petshop petshop, boolean isWeekend, int smallDogs, int largeDogs) {
        double smallDogPrice = petshop.getWeekdaySmallDogPrice();
        double largeDogPrice = petshop.getWeekdayLargeDogPrice();

        if (isWeekend) {
            if (petshop.getName().equals("Meu Canino Feliz")) {
                smallDogPrice *= 1.20;
                largeDogPrice *= 1.20;
            } else if (petshop.getName().equals("Vai Rex")) {
                smallDogPrice = 20.00;
                largeDogPrice = 55.00;
            }
        }

        return (smallDogs * smallDogPrice) + (largeDogs * largeDogPrice);
    }

    private boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY;
    }
}
