/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda_mqucho.dao;

import com.tienda_mqucho.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Qucho
 */
public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    public List<Categoria> findByDescripcionContainingOrderByDescripcionAsc(String descripcion);
}
