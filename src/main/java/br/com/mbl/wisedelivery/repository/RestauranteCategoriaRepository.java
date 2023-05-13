package br.com.mbl.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mbl.wisedelivery.dominio.RestauranteCategoria;

public interface RestauranteCategoriaRepository extends JpaRepository<RestauranteCategoria,Long>{
    
}