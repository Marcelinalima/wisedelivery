package br.com.mbl.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.mbl.wisedelivery.dominio.restaurante.ItemCardapio;

public interface ItemCardapioRepository extends JpaRepository<ItemCardapio, Long>{
    
}