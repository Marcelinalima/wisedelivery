package br.com.mbl.wisedelivery.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mbl.wisedelivery.dominio.Restaurante;
import br.com.mbl.wisedelivery.dominio.RestauranteCategoria;
import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.RestauranteDTO;
import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.RestauranteSalvoDTO;
import br.com.mbl.wisedelivery.repository.RestauranteCategoriaRepository;
import br.com.mbl.wisedelivery.repository.RestauranteRepository;
import br.com.mbl.wisedelivery.service.RestauranteService;
import lombok.Getter;

@Service
public class RestauranteServiceImpl  implements RestauranteService{
     
    @Autowired
    @Getter
    private RestauranteRepository restauranteRepository;


    @Autowired
    @Getter 
    private RestauranteCategoriaRepository restauranteCategoriaRepository;

    @Override
    public RestauranteSalvoDTO salvar(RestauranteDTO dto) {
       return deRestauranteParaRestauranteSalvoDto(getRestauranteRepository().save(deDtoParaRestaurante(dto)));
      
    }

    @Override
    public List<RestauranteCategoria> pegaTodasAsCategorias() {
        return getRestauranteCategoriaRepository().findAll();
        
    }

    private Restaurante deDtoParaRestaurante(RestauranteDTO dto){
        Restaurante restaurante = new Restaurante();
        BeanUtils.copyProperties(dto, restaurante, "confirmaSenha");
        return restaurante;

    }
    private RestauranteSalvoDTO deRestauranteParaRestauranteSalvoDto(Restaurante restaurante){
        RestauranteSalvoDTO dto = new RestauranteSalvoDTO();
        BeanUtils.copyProperties(restaurante, dto,"confirmaSenha");
        return dto;

    }

   
    
}