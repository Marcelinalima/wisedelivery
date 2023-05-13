package br.com.mbl.wisedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mbl.wisedelivery.dominio.dto.restaurantedto.RestauranteDTO;
import br.com.mbl.wisedelivery.service.RestauranteService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("restaurantes")
public class RestauranteController {


    @Autowired
   private RestauranteService restauranteService;
    

    @GetMapping("form-cadastro")
    String formCadastroRestaurante(Model model){
        model.addAttribute("restaurante", new RestauranteDTO());
        model.addAttribute("categorias",restauranteService.pegaTodasAsCategorias());
        return "restaurante-cadastro";
    }

    @PostMapping("salvar")
    public String salvarRestaurante(@ModelAttribute("restaurante") @Valid RestauranteDTO dto) { 
        restauranteService.salvar(dto);
        return"restaurante-cadastro";

    }

    
}