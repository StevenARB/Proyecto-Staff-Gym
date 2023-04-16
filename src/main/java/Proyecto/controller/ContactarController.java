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

    /* @RequestMapping("/buscarPorNombreU")
    public String buscar(Model model, @RequestParam("nombreU") String nombreU){    
         List<Contactar> listaContactarlo = contactarService.getContactarByNombreUsuario(nombreU);
         model.addAttribute("Titulo", "Contactar");
         model.addAttribute("contactar", listaContactarlo);      
          return "contactar";
    }*/
    
    
    /* @GetMapping("/personaNombreU")
    public String buscarPersonaNombreU(@RequestParam("nombre") String nombre, Model model) {
        List<Contactar> contactos = contactarService.findByNombreU(nombre);
        model.addAttribute("contactarlos", contactos);
        model.addAttribute("nombreU", nombre);
        return "contactar";
    }
    */
    
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

    @GetMapping("/crearContactar")
    public String crearContactar(Model model) {
        List<Entrenadores> listaEntrenadores = entrenadoresService.listCoach();
        model.addAttribute("titulo", "Contactar Nuevo Entrenador");
        model.addAttribute("contactarlos", new Contactar()); //envia el objeto, 
        model.addAttribute("entrenadores", listaEntrenadores);  //refencia la entidad entrenadores
        return "crearContactar";
        /*Ver el nombre del html */
    }

    @PostMapping("/guardarContactar")
    public String guardarContactar(@ModelAttribute Contactar contactar) {
        contactarService.saveContactar(contactar);
        return "redirect:/contactar";
    }

    @GetMapping("/actualizarContactar/{id}")
    public String actualizarContactar(@PathVariable("id") Long idContactar, Model model) {
        Contactar contactar = contactarService.getContactarById(idContactar);
        List<Entrenadores> listaEntrenadores = entrenadoresService.listCoach();
        model.addAttribute("titulo", "Actualizar Contacto del Entrenador");
        model.addAttribute("contactarlos", contactar);
        model.addAttribute("entrenadores", listaEntrenadores);
        model.addAttribute("mensaje", contactar.getMensaje()); // Establecer el valor del campo "mensaje"
        model.addAttribute("idEntrenador", contactar.getEntrenadores().getId()); // Establecer el valor del campo "entrenadores"
        return "crearContactar";
    }

    @GetMapping("/eliminarContactar/{id}")
    public String eliminarContactar(@PathVariable long id) {
        contactarService.delete(id);

        return "redirect:/contactar";
    }

}

/* @RequestMapping("/personaNombreU")
    public String buscar(Model model, @Param("palabraClave") String palabraClave) {
        List<Contactar> listaContactarlo = new ArrayList<>();
        if (palabraClave != null) {
            Contactar contactar = contactarService.findByNombre(palabraClave);
            if (contactar != null) {
                listaContactarlo.add(contactar);
            }
        } else {
            listaContactarlo = contactarService.getAllContactar();
        }
        model.addAttribute("Titulo", "Contactar");
        model.addAttribute("contactarlos", listaContactarlo);
        return "contactarlos";
    }*/
    
    
   /* @RequestMapping("/personaNombreU")
    public String buscar(Model model, @Param("nombreU") String nombreU) {
    List<Contactar> listaContactarlo = new ArrayList<>();
   if (nombreU != null) {
            Contactar contactar = contactarService.findByNombre(nombreU);
            if (contactar != null) {
                listaContactarlo.add(contactar);
            }
        } else {
            listaContactarlo = contactarService.getAllContactar();
        }
    model.addAttribute("Titulo", "Contactar");
    model.addAttribute("contactarlos", listaContactarlo);
    return "contactarlos";
}*/