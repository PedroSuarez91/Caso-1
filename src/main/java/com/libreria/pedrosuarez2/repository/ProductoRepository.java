package com.libreria.pedrosuarez2.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.libreria.pedrosuarez2.model.Producto;

@Repository
public class ProductoRepository {
    private List<Producto>listaProductos = new ArrayList<>();

    public Producto agregarProducto(Producto producto){
        listaProductos.add(producto);
        return producto;
    }
    public List<Producto> listaProductos(){
        return listaProductos;
    }
    public boolean eliminarProductos(String nombre){
        return listaProductos.removeIf(b -> b.getNombre().equals(nombre));
    }
}

holi