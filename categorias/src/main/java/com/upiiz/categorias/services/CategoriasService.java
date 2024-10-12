package com.upiiz.categorias.services;

import com.upiiz.categorias.models.Categoria;
import com.upiiz.categorias.repository.CategoriasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// Se crea una instancia de la clase
@Service
public class CategoriasService {
    // Requiero inyectar al servicio

    // Requerimos repositorio(Datos - Listado) - Categoria
    CategoriasRepository categoriasRepository;
    // Constructor

    public CategoriasService (CategoriasRepository CategoriasRepository) {
        this.categoriasRepository = CategoriasRepository;
    }

    // Get - Todas las categorias
    public List<Categoria> getAllCategorias(){
        return categoriasRepository.obtenerCategorias();
    }

    // Get - Categoria por id
    public Categoria getCategoriaById(Long id){
        return categoriasRepository.obtenerCategoria(id);
    }

    // Post - Crear categoria
    public Categoria createCategoria(Categoria categoria){
        return categoriasRepository.guardar(categoria);
    }

    // Put - Actualizar categoria
    public Categoria updateCategoria(Categoria categoria){
        return categoriasRepository.actualizar(categoria);
    }

    // Delete - Eliminar categoria
    public void deleteCategoria(Long id){
        categoriasRepository.eliminar(id);
    }


}
