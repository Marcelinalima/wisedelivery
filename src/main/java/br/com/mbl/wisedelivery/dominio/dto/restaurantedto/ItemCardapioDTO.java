package br.com.mbl.wisedelivery.dominio.dto.restaurantedto;
    
import java.math.BigDecimal;
import java.util.List;

import br.com.mbl.wisedelivery.dominio.restaurante.CategoriaItem;
import br.com.mbl.wisedelivery.dominio.restaurante.Restaurante;

import lombok.Data;
@Data

public class ItemCardapioDTO {
    private Long id;
    private String nome;

   
    private String descricao;
    private String imagem;
    private BigDecimal preco;
    private boolean destaque;
    private List<CategoriaItem> categorias;
    private Restaurante restaurante;

    
}
