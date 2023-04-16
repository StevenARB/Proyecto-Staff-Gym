/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.controller;

import Proyecto.entity.Contacto;
import Proyecto.service.IContactoService;
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
 * @author Jeffrey Mojica S
 */
@Controller
public class ContactoController {
    
    @Autowired
    private IContactoService contactoService;

    @GetMapping("/contacto")
    public String index(Model model) {
        List<Contacto> listaContacto = contactoService.getAllContacto();
        model.addAttribute("contacto", listaContacto);
        return "contacto";
    }

    @GetMapping("/crearContacto")
    public String crearContacto(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "crearContacto";
    }

    @PostMapping("/guardarContacto")
    public String guardarContacto(@ModelAttribute Contacto contacto) {
        contactoService.saveContacto(contacto);
        return "redirect:/contacto";
    }

    @GetMapping("/actualizarContacto/{id}")
    public String actualizarContacto(@PathVariable("id") Long idContacto, Model model) {
       Contacto contacto = contactoService.getContactoById(idContacto);
        model.addAttribute("contacto", contacto);
        return "crearContacto";
    }

    @GetMapping("/eliminarContacto/{id}")
    public String eliminarContacto(@PathVariable long id) {
        contactoService.delete(id);
        return "redirect:/contacto";
    }
    
     @RequestMapping("/ContactoApellidos")
    public String buscarApellidos(Model model, @Param("apellidos") String apellidos) {
        List<Contacto> listaContacto = contactoService.getContactoByApellidos(apellidos);
        model.addAttribute("contacto", listaContacto);
        return "contacto";
    }
}
