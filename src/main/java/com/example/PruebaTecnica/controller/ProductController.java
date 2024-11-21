package com.example.PruebaTecnica.controller;

import com.example.PruebaTecnica.dto.ProductDataDto;
import com.example.PruebaTecnica.dto.ProductRequestDto;
import com.example.PruebaTecnica.entity.ProductEntity;
import com.example.PruebaTecnica.exception.ClientNotFoundException;
import com.example.PruebaTecnica.service.Impl.ClientserviceImpl;
import com.example.PruebaTecnica.service.Impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;
    private final ClientserviceImpl clientservice;

    @PostMapping("/save")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDataDto productDataDto){
        try {
            ProductEntity product = productService.save(
                productDataDto.getTipoCuenta(),
                productDataDto.getSaldo(),
                productDataDto.getExentaGMF(),
                productDataDto.getClienteId()
        );
            return ResponseEntity.ok(product);
        }catch(IllegalArgumentException exception){
         return ResponseEntity.badRequest().body(Map.of("error", exception.getMessage()));
        }catch (ClientNotFoundException exception){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", exception.getMessage()));
        }catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Map.of("error", "Error interno del servidor: "+exception.getMessage()));
        }
    }
    @PutMapping("/update/{id}")
    public ProductEntity updateProduct (@PathVariable Long id, @RequestBody ProductRequestDto productRequestDto){
        return productService.updateProduct(id, productRequestDto);
    }
}