package com.sugarDreams.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ubicacion")
public class UbicacionController {

    
    @GetMapping("/ubicacion")
    public String Ubicacion(Model model) {

       
        model.addAttribute("Efallas");
        model.addAttribute("");

        return "/ubicacion/ubicacion";
    }

}