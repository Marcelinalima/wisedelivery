package br.com.mbl.wisedelivery.dominio.dto.restaurantedto;

import java.util.Set;



import br.com.mbl.wisedelivery.dominio.restaurante.RestauranteCategoria;
import lombok.Data;

@Data
public class RestauranteSalvoDTO {

    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cnpj;
    private String logotipo;
    private Integer tempoEntrega;
    private  Set<RestauranteCategoria> categorias;

    
}