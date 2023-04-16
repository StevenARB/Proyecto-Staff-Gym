/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.controller;

import Proyecto.entity.Contactar;
import Proyecto.entity.Entrenadores;
import Proyecto.service.IContactarService;
import Proyecto.service.IEntrenadoresService;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Jeffrey Mojica S
 */

@Controller
public class ContactarController {

    @Autowired
    private IContactarService contactarService;

    @Autowired
    private IEntrenadoresService entrenadoresService;

    
     @RequestMapping("/buscarPorNombreU")
    public String buscarPorNombreU(@RequestParam("nombreU") String nombreU, Model model) {
        List<Contactar> contactarList = contactarService.getContactarByNombreUsuario(nombreU);
        model.addAttribute("contactarlos", contactarList);
        model.addAttribute("Titulo", "Resultados de búsqueda para " + nombreU);
        return "contactar";
    }
    

    @GetMapping("/contactar")
    public String index(Model model) {
        List<Contactar> listaContactarlo = contactarService.getAllContactar();
        model.addAttribute("Titulo", "Contactar");
        model.addAttribute("contactarlos", listaContactarlo);
        return "contactar";
    }

    @GetMapping("/contactarEntrenador")
    public String crearContactar(Model model) {
        List<Entrenadores> listaEntrenadores = entrenadoresService.listCoach();
        model.addAttribute("titulo", "Contactar Nuevo Entrenador");
        model.addAttribute("contactarlos", new Contactar()); //envia el objeto, 
        model.addAttribute("entrenadores", listaEntrenadores);  //refencia la entidad entrenadores
        return "contactarEntrenador";
        /*Ver el nombre del html */
    }

    @PostMapping("/guardarContactar")
    public String guardarContactar(@ModelAttribute Contactar contactar) {
        contactarService.saveContactar(contactar);
        return "redirect:/contactarEntrenador";
    }

    @GetMapping("/eliminarContactar/{id}")
    public String eliminarContactar(@PathVariable long id) {
        contactarService.delete(id);

        return "redirect:/contactar";
    }

}
