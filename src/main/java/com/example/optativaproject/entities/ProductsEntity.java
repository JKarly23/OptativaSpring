package com.example.optativaproject.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "productos")
@Data
public class ProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private CategoryEntity categoria;

    public Long getID() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public CategoryEntity getCategoria() {
        return this.categoria;
    }

    public void setCategoria(CategoryEntity categoria){
        this.categoria = categoria;
    }


}
