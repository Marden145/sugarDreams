package com.sugarDreams.controller;
import com.sugarDreams.domain.Personalizar;
import com.sugarDreams.service.PersonalizarService;
import com.sugarDreams.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/pedido")
public class PersonalizarController {
    @Autowired
    private PersonalizarService personalizarService;
    
    @GetMapping("/diseños")
    public String diseños(){
        
        
        return "/pedido/diseños";
        
    }
    
    @GetMapping("/personalizar")
    public String personalizar(){
        
        
        return "/pedido/personalizar";
        
    }
   @Autowired
    private FirebaseStorageService FirebaseStorageService;
    @PostMapping("/guardar")
    public String guardar(Personalizar personalizar,
            @RequestParam("imagenFile") MultipartFile imagenFile){
        if (!imagenFile.isEmpty()) {
            personalizarService.save(personalizar);
            String rutaImagen= FirebaseStorageService.cargaImagen(imagenFile, "personalizar",
                    personalizar.getIdQueque());
            personalizar.setRutaImagen(rutaImagen);
            
            
        }
           
        personalizarService.save(personalizar);
        
        
        
        return "redirect:/pedido/personalizar";
        
        
    }
    
}