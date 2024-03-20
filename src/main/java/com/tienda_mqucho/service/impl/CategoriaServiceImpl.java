package com.tienda_mqucho.service.impl;

import com.tienda_mqucho.dao.CategoriaDao;
import com.tienda_mqucho.domain.Categoria;
import com.tienda_mqucho.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao categoriaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategoria(boolean activo) {
        var lista = categoriaDao.findAll();

        if (activo) {
            lista.removeIf(c -> !c.isActivo());
        }
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    public List<Categoria> getCategoriasPorNombre(String descripcion) {
        return categoriaDao.findByDescripcionContainingOrderByDescripcionAsc(descripcion);
    }

    @Override
    public Categoria getCategoriaById(Long idCategoria) {
        return categoriaDao.findById(idCategoria).orElse(null);
    }

    @Override
    public List<Categoria> findByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
