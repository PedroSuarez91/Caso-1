package com.libreria.pedrosuarez2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libreria.pedrosuarez2.model.Producto;
import com.libreria.pedrosuarez2.repository.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository ProductoRepository;

    public Producto createProducto(Producto producto){
        return ProductoRepository.agregarProducto(producto);
    }

    public List<Producto>readAll(){
        return ProductoRepository.listaProductos();
    }

    public String deleteProducto(String nombre){
        if(ProductoRepository.eliminarProductos(nombre)){
            return "producto eliminado";

        } 
        return "no se puede eliminar";
    }
}
