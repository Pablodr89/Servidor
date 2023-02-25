package com.BeerWorld.springRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BeerWorld.springRest.models.Usuarios;

@Repository
public interface UserRepository extends JpaRepository<Usuarios, Long> {

}
