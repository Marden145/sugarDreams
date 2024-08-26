package com.sugarDreams.controller;

import com.sugarDreams.domain.Comentarios;
import com.sugarDreams.domain.Usuario;
import com.sugarDreams.service.ComentariosService;
import com.sugarDreams.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/comentarios")
public class ComentariosController {

    @Autowired
    private ComentariosService comentariosService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listado")
    public String listadoComentarios(Model model) {
        var comentarios = comentariosService.getComentarioss(false);
        model.addAttribute("comentarios", comentarios);
        return "/comentarios/listado";
    }

    @GetMapping("/agregar")
    public String mostrarFormularioAgregarComentario(Model model) {
        model.addAttribute("comentario", new Comentarios());
        return "/comentarios/agregar";
    }

    @PostMapping("/guardar")
    public String guardarComentario(@ModelAttribute Comentarios comentario) {
         Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Usuario usuario = usuarioService.getUsuarioPorUsername(userDetails.getUsername());
        comentario.setUsuario(usuario);
        comentariosService.save(comentario);
        
        return "redirect:/comentarios/agregar";
    }
}