package com.sugarDreams.controller;

import com.sugarDreams.domain.Curso;
import com.sugarDreams.service.CursoService;
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

@Controller
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/reposteria")
    public String reposteria(Model model, Curso curso) {
        var lista = cursoService.getCursos(curso);
        List<Curso> cursosReposteria = lista.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase("Reposteria"))
                .collect(Collectors.toList());
        model.addAttribute("cursosReposteria", cursosReposteria);
        return "/curso/reposteria";
    }

    @GetMapping("/brownie")
    public String brownie(Model model, Curso curso) {
        var lista = cursoService.getCursos(curso);
        List<Curso> cursosBrownie = lista.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase("Brownie"))
                .collect(Collectors.toList());
        model.addAttribute("cursosBrownie", cursosBrownie);
        return "/curso/brownie";
    }

    @GetMapping("/queque")
    public String queque(Model model, Curso curso) {
        var lista = cursoService.getCursos(curso);
        List<Curso> cursosQueque = lista.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase("Queque"))
                .collect(Collectors.toList());
        model.addAttribute("cursosQueque", cursosQueque);
        return "/curso/queque";
    }

    @GetMapping("/quequeSeco")
    public String quequeSeco(Model model, Curso curso) {
        var lista = cursoService.getCursos(curso);
        List<Curso> cursosQuequeSeco = lista.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase("QuequeSeco"))
                .collect(Collectors.toList());
        model.addAttribute("cursosQuequeSeco", cursosQuequeSeco);
        return "/curso/quequeSeco";

    }

    @PostMapping("/guardar")
    public String guardar(Curso curso) {
        cursoService.save(curso);
        return "redirect:/curso/reposteria";
    }

    @GetMapping("/eliminar/{idCurso}")
    public String eliminar(Curso curso) {
        cursoService.delete(curso);
        return "redirect:/curso/reposteria";
    }

    @GetMapping("/modificar/{idCurso}")
    public String modificar(Curso curso, Model model) {
        curso = cursoService.getIdCurso(curso);
        model.addAttribute("curso", curso);
        return "/curso/modificar";
    }

    @GetMapping("/confirmacion")
    public String confirmacion() {
        return "/curso/confirmacion";
    }

}
