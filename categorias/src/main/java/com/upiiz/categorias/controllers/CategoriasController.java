package com.upiiz.categorias.controllers;
import com.upiiz.categorias.models.Categoria;
import com.upiiz.categorias.services.CategoriasService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
public class CategoriasController {

    // Requiero inyectar el servicio
    CategoriasService categoriasService;
    public CategoriasController(CategoriasService categoriasService){
        this.categoriasService = categoriasService;
    }

    // Get - Todas las categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> getCategorias(){
        return ResponseEntity.ok(categoriasService.getAllCategorias());
    }

    // Get - Categoria por id
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getCategoria(@PathVariable Long id){
        return ResponseEntity.ok(categoriasService.getCategoriaById(id));
    }

    // Post - Crear categoria
    @PostMapping
    public ResponseEntity<Categoria> addCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.ok(categoriasService.createCategoria(categoria));
    }

    // Put - Actualizar categoria
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> putCategoria(@RequestBody Categoria categoria, @PathVariable Long id){
        // Que se requiere antes de actualizarla??
        categoria.setId(id);
        return ResponseEntity.ok(categoriasService.updateCategoria(categoria));
    }

    // Delete - Eliminar categoria por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
        categoriasService.deleteCategoria(id);
        return ResponseEntity.noContent().build();
    }
}
