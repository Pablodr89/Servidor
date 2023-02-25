package com.BeerWorld.springRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BeerWorld.springRest.models.Productos;

@Repository
public interface ProductRepository extends JpaRepository<Productos, Long> {

}
