package com.dtidigital.petshop.controllers;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.dtidigital.petshop.models.Petshop;
import com.dtidigital.petshop.services.PetshopService;

@RestController
@RequestMapping("/petshops")
public class PetshopController {

    @Autowired
    private PetshopService petshopService;

    @GetMapping("/best")
    public String getBestPetshop(@RequestParam String date,
                                 @RequestParam int smallDogs,
                                 @RequestParam int largeDogs) {
        LocalDate parsedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Petshop bestPetshop = petshopService.findBestPetshop(parsedDate, smallDogs, largeDogs);

        double totalPrice = petshopService.calculatePrice(bestPetshop, parsedDate.getDayOfWeek() == DayOfWeek.SATURDAY || parsedDate.getDayOfWeek() == DayOfWeek.SUNDAY, smallDogs, largeDogs);

        return String.format("Nome do melhor canil: %s, Preço total: R$%.2f", bestPetshop.getName(), totalPrice);
    }
}
