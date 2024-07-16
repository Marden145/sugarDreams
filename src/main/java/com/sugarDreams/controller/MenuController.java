
package com.sugarDreams.controller;


import com.sugarDreams.service.CategoriaService;
import com.sugarDreams.service.FirebaseStorageService;
import com.sugarDreams.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/menu")


public class MenuController {
       @Autowired
    private ProductoService productoService;

    @Autowired
    private CategoriaService categoriaService;

//    @GetMapping("/menu")
//    public String reposteria(Model model) {
//        var lista = productoService.getProductos(false);
//        model.addAttribute("productos", lista);
//
//        var categorias = categoriaService.getCategorias(false);
//        model.addAttribute("categorias", categorias);
//
//        return "/menu/menu";
//    }

  
    
    @GetMapping("/menu")
    public String reposteria(Model model) {
        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        return "/menu/menu";
    }

}
