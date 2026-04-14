package com.libreria.pedrosuarez2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libreria.pedrosuarez2.model.Producto;
import com.libreria.pedrosuarez2.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/productos")
public class ProductoController {
    @Autowired
    private ProductoService ProductoService;
    @GetMapping
    public ResponseEntity<?>getProductos(){
        List<Producto>listaProductos = ProductoService.readAll();
        if(listaProductos.isEmpty()){
            return ResponseEntity
            .status(404)
            .body("No hay productos ingresados");
        }
        return ResponseEntity.ok(listaProductos);
    }
    @PostMapping
    public ResponseEntity<?>postProductos(@Valid @RequestBody Producto producto){
        Producto p = ProductoService.createProducto(producto);
        if (p!=null) {
            return ResponseEntity.status(HttpStatus.CREATED).body("producto creado");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no se ha creado el producto");    
    }
    @DeleteMapping("{nombre}")
    public String deleteProducto(@PathVariable String nombre){
        return ProductoService.deleteProducto(nombre);
    }
    

    
}
