package com.example.PruebaTecnica.controller;

import com.example.PruebaTecnica.dto.ClientDataDto;
import com.example.PruebaTecnica.dto.ClientResponseDto;
import com.example.PruebaTecnica.entity.ClientEntity;
import com.example.PruebaTecnica.exception.ClientNotFoundException;
import com.example.PruebaTecnica.service.Impl.ClientserviceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientController {
    private final ClientserviceImpl clientServiceImpl;

    @GetMapping("/findAll")
    public List<ClientEntity>findAll(){
        return clientServiceImpl.findAll();
    }
    @GetMapping("/findById/{id}")
    public ClientResponseDto findById(@PathVariable Long id)  throws ClientNotFoundException {
        return clientServiceImpl.findById(id);
    }
    @GetMapping("/findByName/{Nombre}")
    public ClientResponseDto findClienteByName(String nombre) throws ClientNotFoundException {
        return clientServiceImpl.findClienteByName(nombre);
    }
    @PostMapping("/save")
    public Object save(@RequestBody ClientDataDto clientDataDto){
        return clientServiceImpl.save(clientDataDto);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws ClientNotFoundException {
        clientServiceImpl.delete(id);
        return ResponseEntity.ok("Cliente eliminado con exito");
    }
    @PutMapping("/update/{id}")
    public ClientEntity update(@PathVariable Long id, @RequestBody ClientEntity clientEntity) throws ClientNotFoundException {
        return clientServiceImpl.update(id, clientEntity);
    }
}
