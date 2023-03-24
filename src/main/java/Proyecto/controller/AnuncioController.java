package Proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Steven
 */

@Controller
public class AnuncioController {
    
    @GetMapping("/anuncio")
    public String index(Model model) {
        return "anuncio";
    }
    
}
