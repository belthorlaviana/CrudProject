package com.example.crudproject.Repository;


import com.example.crudproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Proporciona operaciones de persistencia para productos.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}