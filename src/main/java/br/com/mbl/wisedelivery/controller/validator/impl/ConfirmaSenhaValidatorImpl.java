package br.com.mbl.wisedelivery.controller.validator.impl;

import org.springframework.stereotype.Component;

import br.com.mbl.wisedelivery.controller.validator.Validator;
import br.com.mbl.wisedelivery.dominio.dto.ClienteDTO;

@Component
public class ConfirmaSenhaValidatorImpl implements Validator<ClienteDTO>{

    @Override
    public boolean validator(ClienteDTO cliente) {
        return !cliente.getSenha().equals(cliente.getConfirmaSenha());
    }

    
}