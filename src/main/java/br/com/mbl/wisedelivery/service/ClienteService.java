package br.com.mbl.wisedelivery.service;

import br.com.mbl.wisedelivery.dominio.dto.ClienteDTO;
import br.com.mbl.wisedelivery.dominio.dto.ClienteLoginDTO;
import br.com.mbl.wisedelivery.dominio.dto.ClienteSalvoDTO;



public interface ClienteService {
    
    ClienteSalvoDTO salvar(ClienteDTO dto);

    boolean login(ClienteLoginDTO cliente);

    

}