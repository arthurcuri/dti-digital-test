package com.dtidigital.petshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Petshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double distance;
    private double weekdaySmallDogPrice;
    private double weekdayLargeDogPrice;
    private double weekendSmallDogPrice;
    private double weekendLargeDogPrice;

    public double getPriceForDayAndSize(boolean isWeekend, boolean isLarge) {
        if (isWeekend) {
            return isLarge ? weekendLargeDogPrice : weekendSmallDogPrice;
        } else {
            return isLarge ? weekdayLargeDogPrice : weekdaySmallDogPrice;
        }
    }
}
