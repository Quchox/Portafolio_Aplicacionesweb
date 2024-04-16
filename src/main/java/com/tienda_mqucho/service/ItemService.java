package com.tienda_mqucho.service;

import com.tienda_mqucho.domain.Item;
import java.util.ArrayList;
import java.util.List;


public interface ItemService {
    //Esta estructura almacena en memoria LA LISTA
    List<Item> listaItems = new ArrayList<>();
    
    public List<Item> gets();
    
    public Item get(Item item);
    
    public void delete(Item item );
    
    public void save(Item item );
    
    public void update(Item item );
    
    public void facturar();
}
