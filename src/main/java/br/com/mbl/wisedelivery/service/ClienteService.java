package br.com.mbl.wisedelivery.service;

import br.com.mbl.wisedelivery.dominio.dto.clientedto.ClienteDTO;
import br.com.mbl.wisedelivery.dominio.dto.clientedto.ClienteLoginDTO;
import br.com.mbl.wisedelivery.dominio.dto.clientedto.ClienteSalvoDTO;



public interface ClienteService {
    
    ClienteSalvoDTO salvar(ClienteDTO dto);

    boolean login(ClienteLoginDTO cliente);

    

}