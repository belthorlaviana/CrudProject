package com.example.crudproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;


@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * muchos productos pertenecen a 1 categoria
     * el joinclumn ye pa que
     */
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false, length = 30)
    private String sku;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 200)
    private String description;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean active;

    /**
     * para auditoria de base de datos, este campo ni se puede insertar, ni alterar, ni actualizar, el valor debe de insertarse de forma automatica cuando se haga un insert, para ello despues de arrancar la app para que se hibernate cree la base de
     * datos con todos sus campos debemos actualizar la base de datos con el script que aparece en schema.sql
     *
     */
    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private Instant createdAt;
}
