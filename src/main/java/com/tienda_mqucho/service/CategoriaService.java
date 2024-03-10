package com.tienda_mqucho.service;

import com.tienda_mqucho.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    //Se define la firma del metodo para obtener los registros de categoria//
    public List<Categoria> getCategoria(boolean activo);
}
