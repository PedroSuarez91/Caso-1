package com.libreria.pedrosuarez2.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {
    @NotBlank(message = "el producto no puede estar vacio")
    @Size(min = 4, max = 40, message = "el nombre del producto debe tener entre 4 y 40 caracteres")
    private String nombre;
    @Min(value = 0, message = "el valor debe ser psoitivo")
    @Max(value = 1000000, message = "el valor del producto no debe ser mayor al mayor al millon")
    private int precio;
    @NotBlank(message = "la categoria no puede estar vacia")
    @Size(min = 4, max = 40, message = "el nombre de la categoria debe tener entre 4 y 40 caracteres")
    private String categoria;
    
}
