package br.com.mbl.wisedelivery.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mbl.wisedelivery.controller.validator.Validator;
import br.com.mbl.wisedelivery.dominio.dto.ClienteDTO;
import br.com.mbl.wisedelivery.exception.SenhaInvalidaException;
import br.com.mbl.wisedelivery.service.ClienteService;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;


@Log4j2
@Controller
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    @Getter private ClienteService clienteService;

 @Autowired
@Getter private Validator<ClienteDTO> validator;

    @GetMapping("form-cadastro")
    public String formCadastroCliente( Model model){
        model.addAttribute("cliente", new ClienteDTO());
        return"cliente-cadastro";

    }
    @PostMapping("/save")
    public String salvarCliente( @ModelAttribute("cliente") ClienteDTO cliente){
        if(validator.validator(cliente)){
            throw new SenhaInvalidaException("Senha e confirmação não estão batendo");
        }
        getClienteService().salvar(cliente);
        return"cliente-cadastro";
    }
  
    
}