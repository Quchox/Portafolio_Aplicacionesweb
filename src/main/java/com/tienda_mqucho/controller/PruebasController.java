package com.tienda_mqucho.controller;


import com.tienda_mqucho.domain.Categoria;
import com.tienda_mqucho.service.CategoriaService;
import com.tienda_mqucho.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("/pruebas")
public class PruebasController {
    
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;
    
    // "/producto/listado"
    @GetMapping("/listado")
    public String listado(Model model){
        var lista = productoService.getProducto(false);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());
        
        //Para poder hacer los options del select...
        var categorias = categoriaService.getCategoria(true);
        model.addAttribute("categorias", categorias);
        
        return "/pruebas/listado";
    }
    
    @GetMapping("/listado/{idCategoria}")
    public String listado(Categoria categoria, Model model){
        categoria = categoriaService.getCategoria(categoria);
        var productos=categoria.getProductos();
        model.addAttribute("productos", productos);
        
        var categorias = categoriaService.getCategoria(true);
        model.addAttribute("categorias", categorias);
       
        return "/pruebas/listado";
    }
    
     @GetMapping("/listado2")
    public String listado2(Model model){
        var lista = productoService.getProducto(false);
        model.addAttribute("productos", lista);
      
        return "/pruebas/listado2";
    }
    
    @PostMapping("/query1")
    public String consultaQuery1(@RequestParam(value="precioInf")double precioInf,
                                 @RequestParam(value="precioSup")double precioSup,
                                 Model model){
        var lista = productoService.metodoJPA(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }
    
    @PostMapping("/query2")
    public String consultaQuery2(@RequestParam(value="precioInf")double precioInf,
                                 @RequestParam(value="precioSup")double precioSup,
                                 Model model){
        var lista = productoService.metodoJPQL(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }
    
    @PostMapping("/query3")
    public String consultaQuery3(@RequestParam(value="precioInf")double precioInf,
                                 @RequestParam(value="precioSup")double precioSup,
                                 Model model){
        var lista = productoService.metodoSQL(precioInf, precioSup);
        model.addAttribute("productos", lista);
        model.addAttribute("precioInf", precioInf);
        model.addAttribute("precioSup", precioSup);
        return "/pruebas/listado2";
    }
  
}
