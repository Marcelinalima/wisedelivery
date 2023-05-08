package br.com.mbl.wisedelivery.dominio;


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "restaurante")
public class Restaurante  extends Usuario{
    
    @Getter @Setter
    private String cnpj;

    @Getter @Setter
    private String logotipo;

    @Getter @Setter
    private BigDecimal taxaEntrega;

    @Getter @Setter
    private Integer tempoEntrega;


    @ManyToAny
    @JoinTable(
        name = "restaurante_relacao_categorias",
        joinColumns = @JoinColumn(name = "restaurante_id"),
        inverseJoinColumns = @JoinColumn(name= "categoria_restaurante_id")
    )
    private  Set<RestauranteCategoria> categorias = new HashSet<>();


    

    
    
}