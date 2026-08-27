package com.example.crudproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    private String description;

    // ⚠️ PROBLEMA SEMBRADO (Lab 1): EAGER en una colección.
    // Cada vez que se carga una categoría, se cargan TODOS sus productos.
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();
}
