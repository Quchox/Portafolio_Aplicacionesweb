package com.tienda_mqucho.service.impl;

import com.tienda_mqucho.dao.CategoriaDao;
import com.tienda_mqucho.domain.Categoria;
import com.tienda_mqucho.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;





@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao;
    @Override
    @Transactional(readOnly = true) 
    public List<Categoria> getCategoria(boolean activo) {
        var lista=categoriaDao.findAll();
        
        if (activo){
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

   
}
