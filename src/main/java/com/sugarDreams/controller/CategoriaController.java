/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sugarDreams.controller;




import com.sugarDreams.domain.Categoria;
import com.sugarDreams.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;
    
    @GetMapping("/listado")
    public String listado(Model model) {
        var categorias= categoriaService.getCategorias(false);
        
        
        model.addAttribute("categorias",categorias);
         model.addAttribute("totalCategorias",categorias.size());
        return "/categoria/listado";
    }
    
    
    
    @PostMapping("/guardar")
    public String guardar(Categoria categoria) {
        
        
        categoriaService.save(categoria);
        return "redirect:/categoria/listado";
    }
    
    @GetMapping("/eliminar/{idCategoria}")
    public String eliminar (Categoria categoria){
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }
   
    @GetMapping("/modificar/{idCategoria}")
    public String modificar (Categoria categoria,Model model){
        categoria = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", categoria);
                
        return "/categoria/modificar";
    }
   
}
