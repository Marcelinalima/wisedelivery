package br.com.mbl.wisedelivery.service;

import java.util.List;

import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.RestauranteDTO;
import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.RestauranteIdDTO;
import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.RestauranteLoginDTO;
import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.RestauranteSalvoDTO;
import br.com.mbl.wisedelivery.dominio.restaurante.RestauranteCategoria;

public interface RestauranteService {
    
    RestauranteIdDTO procurarRestauranteIdPeloEmail(String email);

    RestauranteSalvoDTO procurarPeloEmail(String email);

    RestauranteSalvoDTO salvar(RestauranteDTO dto);

    List<RestauranteCategoria>pegaTodasAsCategorias();

    boolean logar(RestauranteLoginDTO restaurante);
    
}