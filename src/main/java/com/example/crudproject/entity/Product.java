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

    // ⚠️ @ManyToOne es EAGER por defecto en JPA: cargar un producto
    // dispara también la carga de su categoría (y ésta, con su EAGER
    // mal puesto, la de todos los productos hermanos...).
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @Column(nullable = false, length = 30)
    private String sku;

    @Column(nullable = false, length = 200)
    private String name;

    // Columna pesada: en los labs veremos cómo evitar traerla siempre (over-fetching)
    private String description;

    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean active;

    @Column(name = "created_at", nullable = false, updatable = false, insertable = false)
    private Instant createdAt;
}
