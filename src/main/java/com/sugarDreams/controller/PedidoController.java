package com.sugarDreams.controller;

import com.sugarDreams.domain.Pedido;
import com.sugarDreams.service.PedidoService;
import com.sugarDreams.service.FirebaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import com.sugarDreams.domain.Usuario;
import com.sugarDreams.service.UsuarioService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private FirebaseStorageService FirebaseStorageService;

    @GetMapping("/diseños")
    public String diseños() {
        return "/pedido/diseños";
    }

    @GetMapping("/personalizar")
    public String personalizar() {
        return "/pedido/personalizar";
    }

    @PostMapping("/guardar")
    public String guardar(Pedido pedido, @RequestParam("imagenFile") MultipartFile imagenFile) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Usuario usuario = usuarioService.getUsuarioPorUsername(userDetails.getUsername());

        pedido.setUsuario(usuario);

        pedidoService.save(pedido);

        if (!imagenFile.isEmpty()) {
            String rutaImagen = FirebaseStorageService.cargaImagen(imagenFile, "pedido", pedido.getIdQueque());
            pedido.setRutaImagen(rutaImagen);

            // Guardar nuevamente el pedido para actualizar con la ruta de la imagen
            pedidoService.save(pedido);
        }
        return "redirect:/pedido/personalizar";

    }

    @PostMapping("/pedidoUsuario")
    public String consultaUsuario(
            Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        Usuario usuario = usuarioService.getUsuarioPorUsername(userDetails.getUsername());

        var pedidos = pedidoService.usuario(usuario);

        model.addAttribute("pedidos", pedidos);
        model.addAttribute("usuario", usuario);

        return "/pedido/pedidoUsuario";
    }

    @GetMapping("/listado")
    public String listado(Model model, Pedido pedido) {
        var pedidos = pedidoService.getPedidos();
        model.addAttribute("pedidos", pedidos);

        return "/pedido/listado";
    }

    @GetMapping("/eliminar/{idQueque}")
    public String eliminar(Pedido pedido) {
        pedidoService.delete(pedido);

        return "redirect:/pedido/listado";
    }

}
