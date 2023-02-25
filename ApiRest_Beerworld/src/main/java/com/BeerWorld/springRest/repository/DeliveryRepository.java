package com.BeerWorld.springRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BeerWorld.springRest.models.Pedidos;

@Repository
public interface DeliveryRepository extends JpaRepository<Pedidos, Long> {

}
