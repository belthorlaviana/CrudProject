package com.example.crudproject.Repository;


import com.example.crudproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Proporciona operaciones de persistencia para categorías.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}