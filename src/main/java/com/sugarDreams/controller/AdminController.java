
package com.sugarDreams.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author indira 
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/admin")
    public String admin(Model model) {

       
        model.addAttribute("Efallas");
        model.addAttribute("");

        return "/admin/admin";
    }
}
