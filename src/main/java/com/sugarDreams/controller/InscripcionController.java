package com.sugarDreams.controller;

import com.sugarDreams.domain.Inscripcion;
import com.sugarDreams.domain.Usuario;
import com.sugarDreams.service.InscripcionService;
import com.sugarDreams.service.UsuarioService;
import com.sugarDreams.service.FirebaseStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
@RequestMapping("/inscripcion")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/guardar")
    public String guardar(Inscripcion inscripcion) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Usuario usuario = usuarioService.getUsuarioPorUsername(userDetails.getUsername());
        inscripcion.setUsuario(usuario);
        

        inscripcionService.save(inscripcion);

        return "redirect:/menu/menu";

    }

    @GetMapping("/eliminar/{idInscripcion}")
    public String eliminar(Inscripcion inscripcion) {
        inscripcionService.delete(inscripcion);
        return "redirect:/menu/menu";

    }

    @PostMapping("/inscripcionUsuario")
    public String consultaUsuario(
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Usuario usuario = usuarioService.getUsuarioPorUsername(userDetails.getUsername());
        
        var inscripciones = inscripcionService.usuario(usuario);

        model.addAttribute("inscripciones", inscripciones);
        model.addAttribute("usuario", usuario);

        return "/curso/inscripcionUsuario";
    }

}
