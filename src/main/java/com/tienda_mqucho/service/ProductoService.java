package com.tienda_mqucho.service;

import com.tienda_mqucho.domain.Producto;
import java.util.List;


public interface ProductoService {
    
//Se define la firma del metodo para obtener los registros de producto//
    public List<Producto> getProducto(boolean activo);
    
    //se recupera un registro tomando el idProducto como clave de busqueda
    public Producto getProducto(Producto producto);
    
    //Si idProducto tienen un valor, se modifica ese registro
    //Si idProducto no tiene valor, se inserta un nuevo registro
    public void save(Producto producto);
    
    //Se elimina el registro que tenga el valor del idProducto pasado
    public void delete(Producto producto);
    
    // Esta consulta utiliza consultas ampliadas
    public List<Producto> metodoJPA(double precioInf, double precioSup);
    
    
    //Esta consulta utiliza consiltas JPQL
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
    
    //Esta consulta utiliza consiltas SQL
    public List<Producto> metodoSQL(double precioInf, double precioSup);
}
