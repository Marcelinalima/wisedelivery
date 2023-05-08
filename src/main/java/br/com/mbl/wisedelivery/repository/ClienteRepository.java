package br.com.mbl.wisedelivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mbl.wisedelivery.dominio.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente , Long>{
    
}