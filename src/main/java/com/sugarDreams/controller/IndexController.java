package com.sugarDreams.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.sugarDreams.domain.Usuario;
import com.sugarDreams.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String inicio(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String Login(Model model, Usuario usuario) {
        model.addAttribute("usuario", usuario);

        return "/login";
    }

    @PostMapping("/login")
    public String confirmarLogin(Model model, Usuario usuario) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && auth.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            Usuario usuarioU = usuarioService.getUsuarioPorUsername(userDetails.getUsername());
            if (usuarioU.isActivo()) {
                return "redirect:/";
            }
            return "redirect:/login";
        } else {
            return "redirect:/login";
        }
    }

}
