package com.upiiz.categorias.repository;

import com.upiiz.categorias.models.Categoria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CategoriasRepository {
    // Almacenar en un listado las categorias: salvar, listar, eliminar, actualizar
    // Generar de manera unica el id para cada categoria

    // Evitar el null pointer exception
    private List<Categoria> categorias = new ArrayList<Categoria>();
    private AtomicLong id = new AtomicLong();

    // Agregamos la categoria al listado y la regresamos - POST
    public Categoria guardar(Categoria categoria){
        categoria.setId(id.incrementAndGet());
        categorias.add(categoria);
        return categoria;
    }

    // Leer todas las categorias - GET
    public List<Categoria> obtenerCategorias() {
        return categorias;
    }

    // Leer una categoria con un id - GET
    public Categoria obtenerCategoria(Long id) {
        /*for(Categoria categoria : categorias){
            if(categoria.getId().equals(id))
                return categoria;
        }
        return null;*/
        // Funcional
        return categorias.stream().filter(categoria -> categoria.getId().equals(id)).findFirst().orElse(null);
    }

    // DELETE
    public void eliminar(Long id){
        categorias.removeIf(categoria -> categoria.getId().equals(id));
    }

    // PUT
    public Categoria actualizar(Categoria categoria){
        eliminar(categoria.getId());
        categorias.add(categoria);
        return categoria;
    }

}
