package com.exercicio.crud_06.controllers;

import com.exercicio.crud_06.models.ClienteModel;
import com.exercicio.crud_06.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteModel> save(@RequestBody ClienteModel clienteModel){
        ClienteModel cliente = clienteService.save(clienteModel);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cliente.getId())
                .toUri();

        return ResponseEntity.ok().body(cliente);
    }

    @GetMapping
    public ResponseEntity<List<ClienteModel>> findAll(){
        List<ClienteModel> clientes = clienteService.findAll();

        return ResponseEntity.ok().body(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteModel> findById(@PathVariable Long id){
        ClienteModel cliente = clienteService.findById(id);

        return ResponseEntity.ok().body(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        clienteService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
