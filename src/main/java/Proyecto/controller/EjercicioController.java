package Proyecto.controller;

import Proyecto.entity.Ejercicio;
import Proyecto.service.IEjercicioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Steven
 */
@Controller
public class EjercicioController {
    
    @Autowired
    private IEjercicioService ejercicioService;

    @GetMapping("/ejercicio")
    public String index(Model model) {
        List<Ejercicio> listaEjercicio = ejercicioService.getAllEjercicio();
        model.addAttribute("ejercicios", listaEjercicio);
        return "ejercicio";
    }
    
    @GetMapping("/ejercicios")
    public String home(Model model) {
        List<Ejercicio> listaEjercicio = ejercicioService.getAllEjercicio();
        model.addAttribute("ejercicios", listaEjercicio);
        return "ejercicios";
    }

    @RequestMapping("/ejercicioTitulo")
    public String buscarTitulo(Model model, @Param("titulo") String titulo) {
        List<Ejercicio> listaEjercicio = ejercicioService.getEjercicioByTitulo(titulo);
        model.addAttribute("ejercicios", listaEjercicio);
        return "ejercicio";
    }

    @GetMapping("/crearEjercicio")
    public String crearEjercicio(Model model) {
        model.addAttribute("ejercicio", new Ejercicio());
        return "ejercicioCU";
    }

    @PostMapping("/guardarEjercicio")
    public String guardarEjercicio(@ModelAttribute Ejercicio ejercicio) {
        ejercicioService.saveEjercicio(ejercicio);
        return "redirect:/ejercicio";
    }

    @GetMapping("/actualizarEjercicio/{id}")
    public String actualizarEjercicio(@PathVariable("id") Long idEjercicio, Model model) {
        Ejercicio ejercicio = ejercicioService.getEjercicioById(idEjercicio);
        model.addAttribute("ejercicio", ejercicio);
        return "ejercicioCU";
    }

    @GetMapping("/eliminarEjercicio/{id}")
    public String eliminarEjercicio(@PathVariable long id) {
        ejercicioService.delete(id);
        return "redirect:/ejercicio";
    }
    
}
