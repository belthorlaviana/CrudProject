package com.example.crudproject.controller;

import com.example.crudproject.dto.request.ProductDtoRequest;
import com.example.crudproject.dto.response.ProductDtoResponse;
import com.example.crudproject.entity.Product;
import com.example.crudproject.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "API para la gestión de productos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //ESTI ENDPOINT TA FECHU ENTERU
    @Operation(summary = "Crear un producto", description = "Crea un nuevo producto en la base de datos")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Producto creado correctamente"), @ApiResponse(responseCode = "400", description = "Datos del producto incorrectos", content = @Content)})
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody ProductDtoRequest product) {

        Product createdProduct = productService.create(product);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    //ESTI ENDPOINT TA FECHU ENTERU
    @Operation(summary = "Obtener todos los productos", description = "Obtiene la lista completa de productos")
    @ApiResponse(responseCode = "200", description = "Lista de productos obtenida correctamente")
    @GetMapping
    public ResponseEntity<List<ProductDtoResponse>> findAll() {

        return ResponseEntity.ok(productService.findAll());
    }

    //ESTI ENDPOINT TA FECHU ENTERU
    @Operation(summary = "Obtener un producto por ID", description = "Busca un producto utilizando su identificador")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Producto encontrado"), @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)})
    @GetMapping("/{id}")
    public ResponseEntity<ProductDtoResponse> findById(

            @Parameter(description = "ID del producto", example = "1", required = true) @PathVariable Long id) {

        return ResponseEntity.ok(productService.findById(id));
    }

    @Operation(summary = "Actualizar un producto", description = "Actualiza los datos de un producto existente")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Producto actualizado correctamente"), @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content), @ApiResponse(responseCode = "400", description = "Datos incorrectos", content = @Content)})
    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@Parameter(description = "ID del producto", example = "1", required = true) @PathVariable Long id,
                                          @RequestBody ProductDtoRequest productDto) {

        return ResponseEntity.ok(productService.update(id, productDto));
    }

    @Operation(summary = "Eliminar un producto", description = "Elimina un producto de la base de datos")
    @ApiResponses(value = {@ApiResponse(responseCode = "204", description = "Producto eliminado correctamente"), @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(

            @Parameter(description = "ID del producto", example = "1", required = true) @PathVariable Long id) {

        productService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
