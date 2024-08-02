package com.dtidigital.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dtidigital.petshop.models.Petshop;

@Repository
public interface PetshopRepository extends JpaRepository<Petshop, Long> {
}
