package br.com.mbl.wisedelivery.service.impl;

import java.util.List;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.ItemCardapioDTO;
import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.ItemCardapioTabelaDTO;
import br.com.mbl.wisedelivery.dominio.restaurante.CategoriaItem;
import br.com.mbl.wisedelivery.dominio.restaurante.ItemCardapio;
import br.com.mbl.wisedelivery.dominio.restaurante.Restaurante;
import br.com.mbl.wisedelivery.exception.ObjetoNaoEncontradoException;
import br.com.mbl.wisedelivery.repository.CategoriaItemRepository;
import br.com.mbl.wisedelivery.repository.ItemCardapioRepository;
import br.com.mbl.wisedelivery.repository.RestauranteRepository;
import br.com.mbl.wisedelivery.service.ItemCardapioService;
import lombok.Getter;

@Service
public class ItemCardapioServiceServiceImpl implements ItemCardapioService {

    @Autowired @Getter
    private ItemCardapioRepository itemCardapioRepository;

    @Autowired @Getter
    private CategoriaItemRepository categoriaItemRepository;

    @Autowired @Getter
    private RestauranteRepository restauranteRepository;

    @Override
    public ItemCardapioDTO salvar(ItemCardapioDTO dto) {
        ItemCardapio itemCardapio = getItemCardapioRepository().save(deDtoParaItemCardapio(dto));
        dto = deItemCardapioParaItemCardapioDTO(itemCardapio);
        return dto;
    }

    @Override
    public ItemCardapioDTO procurarPeloId(Long id) {
        ItemCardapio item = getItemCardapioRepository().findById(id).orElseThrow( ()-> new ObjetoNaoEncontradoException("Não foi encontrado nenhum item para o ID: " + id));
        return deItemCardapioParaItemCardapioDTO(item);
    }

    @Override
    public List<ItemCardapioDTO> procurarTodos() {
        return getItemCardapioRepository().findAll().stream().map(item -> deItemCardapioParaItemCardapioDTO(item)).toList();
    }

    @Override
    public void deletar(Long id) {
        getItemCardapioRepository().deleteById(id);
    }

    @Override
    public List<CategoriaItem> pegarTodasAsCategorias() {
        return getCategoriaItemRepository().findAll();
    }

    private ItemCardapio deDtoParaItemCardapio(ItemCardapioDTO dto){
        ItemCardapio itemCardapio = new ItemCardapio();
        BeanUtils.copyProperties(dto, itemCardapio);
        return itemCardapio;
    }

    private ItemCardapioDTO deItemCardapioParaItemCardapioDTO(ItemCardapio itemCardapio){
        ItemCardapioDTO dto = new ItemCardapioDTO();
        BeanUtils.copyProperties(itemCardapio, dto);
        return dto;
    }

    private ItemCardapioTabelaDTO deItemCardapioParaItemCardapioTabelaDTO(ItemCardapio itemCardapio){
        ItemCardapioTabelaDTO dto = new ItemCardapioTabelaDTO();
        BeanUtils.copyProperties(itemCardapio, dto, "restaurante, categorias");
        dto.setRestauranteId(itemCardapio.getRestaurante().getId());
        
        dto.setCategorias(itemCardapio.getCategorias().stream().map(
            categoria -> categoria.getNome()
        ).toList());

        return dto;
    }

    @Override
    public List<ItemCardapioTabelaDTO> procurarTodosOsItensPeloIdDoRestaurante(Long restauranteId) {
        Restaurante restaurante = getRestauranteRepository().findById(restauranteId).orElseThrow( () -> new ObjetoNaoEncontradoException("Não foi encontrado restaurante para este id"));
        return getItemCardapioRepository().findByRestaurante(restaurante).stream().map(item -> deItemCardapioParaItemCardapioTabelaDTO(item)).toList();
    }

} 