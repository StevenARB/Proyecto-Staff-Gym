package Proyecto.controller;

import java.util.List;
import Proyecto.entity.Foro;
import Proyecto.service.IForoService;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author aaron
 */
@Controller
public class ForoController {

    @Autowired
    private IForoService foroService;

    @GetMapping("/foro")
    public String index(Model model) {
        List<Foro> listaForo = foroService.getAllForo();
        model.addAttribute("foro", listaForo);
        return "foro";
    }

    @GetMapping("/crearForo")
    public String crearForo(Model model) {
        model.addAttribute("foro", new Foro());
        return "foro";
    }

    @PostMapping("/guardarForo")
    public String guardarForo(@ModelAttribute Foro foro) {
        foroService.saveForo(foro);
        return "redirect:/foro";
    }

    @RequestMapping("/foroTitulo")
    public String buscarForo(Model model, @Param("titulo") String titulo) {
        List<Foro> listaForo = foroService.getForoByTitulo(titulo);
        model.addAttribute("foro", listaForo);
        return "foro";
    }

    @GetMapping("/eliminarForo/{id}")
    public String eliminarForo(@PathVariable long id) {
        foroService.delete(id);
        return "redirect:/foroCU";
    }
}
