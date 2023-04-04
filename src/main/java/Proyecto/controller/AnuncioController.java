package Proyecto.controller;

import Proyecto.entity.Anuncio;
import Proyecto.service.IAnuncioService;
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
public class AnuncioController {
    
    @Autowired
    private IAnuncioService anuncioService;

    @GetMapping("/anuncio")
    public String index(Model model) {
        List<Anuncio> listaAnuncio = anuncioService.getAllAnuncio();
        model.addAttribute("tituloh1anuncio", "Anuncios");
        model.addAttribute("anuncios", listaAnuncio);
        return "anuncio";
    }

    @RequestMapping("/anuncioTitulo")
    public String buscarTitulo(Model model, @Param("titulo") String titulo) {
        List<Anuncio> listaAnuncio = anuncioService.getAnuncioByTitulo(titulo);
        model.addAttribute("tituloh1anuncio", "Anuncios");
        model.addAttribute("anuncios", listaAnuncio);
        return "anuncio";
    }

    @GetMapping("/crearAnuncio")
    public String crearAnuncio(Model model) {
        model.addAttribute("tituloh2anuncio", "Nuevo Anuncio");
        model.addAttribute("anuncio", new Anuncio());
        return "anuncioCU";
    }

    @PostMapping("/guardarAnuncio")
    public String guardarAnuncio(@ModelAttribute Anuncio anuncio) {
        anuncioService.saveAnuncio(anuncio);
        return "redirect:/anuncio";
    }

    @GetMapping("/actualizarAnuncio/{id}")
    public String actualizarAnuncio(@PathVariable("id") Long idAnuncio, Model model) {
        Anuncio anuncio = anuncioService.getAnuncioById(idAnuncio);
        model.addAttribute("tituloh2anuncio", "Actualizar Anuncio");
        model.addAttribute("anuncio", anuncio);
        return "anuncioCU";
    }

    @GetMapping("/eliminarAnuncio/{id}")
    public String eliminarAnuncio(@PathVariable long id) {
        anuncioService.delete(id);
        return "redirect:/anuncio";
    }
    
}
