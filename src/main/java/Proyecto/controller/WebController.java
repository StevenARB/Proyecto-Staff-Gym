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
    public String nosotros() {
        return "nosotros";
    }

    @GetMapping("/productos")
    public String productos() {
        return "productos";
    }

    @GetMapping("/foro")
    public String foro() {
        return "foro";
    }

    @GetMapping("/membresia")
    public String membresia() {
        return "membresia";
    }

}
