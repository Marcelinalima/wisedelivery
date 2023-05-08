package br.com.mbl.wisedelivery.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import br.com.mbl.wisedelivery.dominio.Cliente;
import br.com.mbl.wisedelivery.dominio.dto.ClienteDTO;
import br.com.mbl.wisedelivery.dominio.dto.ClienteSalvoDTO;
import br.com.mbl.wisedelivery.repository.ClienteRepository;
import br.com.mbl.wisedelivery.service.ClienteService;
import lombok.Getter;
@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    @Getter private ClienteRepository clienteRepository;

    @Override
    public ClienteSalvoDTO salvar(ClienteDTO dto) {
        
        return deClienteParaClienteSalvoDto(
            getClienteRepository().save(
          deDtoParaCliente(dto)
          )
        );  
    }    

    private Cliente deDtoParaCliente(ClienteDTO dto){
            Cliente cliente = new Cliente();
            BeanUtils.copyProperties(dto, cliente, "confirmasenha");
            return cliente;
    }

        
    private ClienteSalvoDTO deClienteParaClienteSalvoDto(Cliente cliente ) {
        ClienteSalvoDTO clienteSalvoDTO = new ClienteSalvoDTO();
        BeanUtils.copyProperties(cliente, clienteSalvoDTO, "confirmasenha");
        return clienteSalvoDTO;
    }
    
}
