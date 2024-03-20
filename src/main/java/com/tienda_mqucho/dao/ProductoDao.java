/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tienda_mqucho.dao;

import com.tienda_mqucho.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Qucho
 */
public interface ProductoDao extends JpaRepository<Producto, Long>{
    
    // Esta consulta utiliza consultas ampliadas
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
    
    
    //Esta consulta utiliza consiltas JPQL
    @Query(value="SELECT p from Producto p WHERE p.precio BETWEEN :precioInf and :precioSup ORDER BY p.descripcion ASC")
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
    
    //Esta consulta utiliza consiltas SQL
    @Query(nativeQuery=true, value="SELECT * from Producto p WHERE p.precio BETWEEN :precioInf and :precioSup ORDER BY p.descripcion ASC")
    public List<Producto> metodoSQL(double precioInf, double precioSup);
}
