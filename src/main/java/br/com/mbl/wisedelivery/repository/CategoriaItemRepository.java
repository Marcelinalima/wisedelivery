package br.com.mbl.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mbl.wisedelivery.dominio.restaurante.CategoriaItem;

public interface CategoriaItemRepository extends JpaRepository<CategoriaItem, Long>{
    
}