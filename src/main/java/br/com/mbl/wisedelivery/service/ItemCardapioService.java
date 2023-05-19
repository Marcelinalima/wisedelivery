package br.com.mbl.wisedelivery.service;

import java.util.List;


import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.ItemCardapioDTO;
import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.ItemCardapioTabelaDTO;
import br.com.mbl.wisedelivery.dominio.restaurante.CategoriaItem;

public interface ItemCardapioService {

    ItemCardapioDTO salvar(ItemCardapioDTO dto);

    ItemCardapioDTO procurarPeloId(Long id);

    List<ItemCardapioDTO> procurarTodos();

    void deletar(Long id);

    List<CategoriaItem> pegarTodasAsCategorias();

    List<ItemCardapioTabelaDTO> procurarTodosOsItensPeloIdDoRestaurante(Long id);

}