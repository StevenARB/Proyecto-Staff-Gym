/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.controller;

import Proyecto.entity.Reserva;
import Proyecto.service.IReservaService;
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
 * @author keylo
 */

@Controller
public class ReservaController {
    
    @Autowired
    private IReservaService reservaService;
    
    
      @GetMapping("/reserva")
    public String index(Model model) {
        List<Reserva> listaReserva = reservaService.getAllReserva();
        model.addAttribute("titulo", "Reservacion");
        model.addAttribute("reservacion", listaReserva);
        return "reserva";
    }
    
    /*@GetMapping("/")
    public String home(Model model) {
        List<Anuncio> listaAnuncio = anuncioService.getAllAnuncio();
        model.addAttribute("anuncios", listaAnuncio);
        return "index";
    }

*/
    @RequestMapping("/reservaBuscar")
    public String buscarCedula(Model model, @Param("cedula") String cedula) {
        List<Reserva> listaReserva = reservaService.getReservaByCedula(cedula);
        model.addAttribute("tituloh1", "Reservacion");
        model.addAttribute("reservacion", listaReserva);
        return "reserva";
    }


    @GetMapping("/crearReserva")
    public String crearReserva(Model model) {
        model.addAttribute("tituloh2", "Nueva Reserva");
        model.addAttribute("reserva", new Reserva());
        return "reservaCU";
    }

    @PostMapping("/guardarReserva")
    public String guardarReserva(@ModelAttribute Reserva reserva) {
       reservaService.saveReserva(reserva);
        return "redirect:/reserva";
    }

    @GetMapping("/actualizarReserva/{id}")
    public String actualizaReserva(@PathVariable("id") Long idReserva, Model model) {
       Reserva reserva = reservaService.getReservaById(idReserva);
        model.addAttribute("tituloh2", "Actualizar Reserva");
        model.addAttribute("reserva", reserva);
        return "reservaCU";
    }

    @GetMapping("/eliminarReserva/{id}")
    public String eliminarReserva(@PathVariable long id) {
        reservaService.delete(id);
        return "redirect:/reserva";
    }
   
   
}
