package br.com.mbl.wisedelivery.service;

import java.util.List;

import br.com.mbl.wisedelivery.dominio.RestauranteCategoria;
import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.RestauranteDTO;
import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.RestauranteSalvoDTO;

public interface RestauranteService {

    RestauranteSalvoDTO salvar(RestauranteDTO dto);

    List<RestauranteCategoria>pegaTodasAsCategorias();
    
}