package com.sugarDreams.controller;

import com.sugarDreams.domain.Favorito;
import com.sugarDreams.domain.Usuario;
import com.sugarDreams.service.FavoritoService;
import com.sugarDreams.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@Controller
@RequestMapping("/favorito")
public class FavoritoController {

    @Autowired
    private FavoritoService favoritoService;
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/guardar")
    public String guardar(Favorito favorito) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Usuario usuario = usuarioService.getUsuarioPorUsername(userDetails.getUsername());
        favorito.setUsuario(usuario);
        favoritoService.save(favorito);

        return "redirect:/menu/menu";

    }

    @GetMapping("/eliminar/{idFavorito}")
    public String eliminar(Favorito favorito) {
        favoritoService.delete(favorito);
        return "redirect:/menu/menu";

    }

    @PostMapping("/favoritoUsuario")
    public String consultaUsuario(
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Usuario usuario = usuarioService.getUsuarioPorUsername(userDetails.getUsername());

        var favoritos = favoritoService.usuario(usuario);

        model.addAttribute("favoritos", favoritos);
        model.addAttribute("usuario", usuario);

        return "/producto/favoritos";
    }

}
