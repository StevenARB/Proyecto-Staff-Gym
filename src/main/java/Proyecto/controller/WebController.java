package Proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Steven
 */
@Controller
public class WebController {

    @GetMapping("/nosotros")
    public String nosotros(Model model) {
        return "nosotros";
    }

    @GetMapping("/productos")
    public String productos(Model model) {
        return "productos";
    }

    @GetMapping("/foro")
    public String foro(Model model) {
        return "foro";
    }

    @GetMapping("/membresia")
    public String membresia(Model model) {
        return "membresia";
    }

}
