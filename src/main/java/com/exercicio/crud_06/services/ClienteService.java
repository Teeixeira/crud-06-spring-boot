package com.exercicio.crud_06.services;

import com.exercicio.crud_06.models.ClienteModel;
import com.exercicio.crud_06.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ClienteModel save(ClienteModel clienteModel){
        return clienteRepository.save(clienteModel);
    }

    public List<ClienteModel> findAll(){
        return clienteRepository.findAll();
    }

    public ClienteModel findById(Long id){
        return clienteRepository.findById(id).get();
    }

    public void delete(Long id){
        clienteRepository.deleteById(id);
    }
}
