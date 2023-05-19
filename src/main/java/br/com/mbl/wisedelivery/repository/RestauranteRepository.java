package br.com.mbl.wisedelivery.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mbl.wisedelivery.dominio.restaurante.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Long>{


    Optional<Restaurante> findByEmail(String email);
    
}