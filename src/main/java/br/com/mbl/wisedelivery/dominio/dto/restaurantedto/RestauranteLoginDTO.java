package br.com.mbl.wisedelivery.dominio.dto.restaurantedto;

import lombok.Data;

@Data
public class RestauranteLoginDTO {

        private String email;
        private String senha;
        private String token;
    
    
}