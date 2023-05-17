package br.com.mbl.wisedelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mbl.wisedelivery.dominio.restaurante.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{


    Optional<Restaurante>findByEmail(String email);
    
}