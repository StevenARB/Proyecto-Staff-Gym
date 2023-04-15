package Proyecto.controller;

import Proyecto.entity.Cliente;
import Proyecto.service.IClienteService;
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
public class ClienteController {

    @Autowired
    private IClienteService clienteService;

    @GetMapping("/cliente")
    public String index(Model model) {
        List<Cliente> listaCliente = clienteService.getAllCliente();
        model.addAttribute("titulo", "Clientes");
        model.addAttribute("clientes", listaCliente);
        return "cliente";
    }

    @RequestMapping("/clienteCedula")
    public String buscarCedula(Model model, @Param("cedula") String cedula) {
        List<Cliente> listaCliente = clienteService.getClienteByCedula(cedula);
        model.addAttribute("titulo", "Clientes");
        model.addAttribute("clientes", listaCliente);
        return "cliente";
    }

    @GetMapping("/crearCliente")
    public String crearCliente(Model model) {
        model.addAttribute("titulo", "Nuevo Cliente");
        model.addAttribute("cliente", new Cliente());
        return "clienteCU";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteService.saveCliente(cliente);
        return "redirect:/cliente";
    }

    @GetMapping("/actualizarCliente/{id}")
    public String actualizarCliente(@PathVariable("id") Long idCliente, Model model) {
        Cliente cliente = clienteService.getClienteById(idCliente);
        model.addAttribute("titulo", "Actualizar Cliente");
        model.addAttribute("cliente", cliente);
        return "clienteCU";
    }

    @GetMapping("/eliminarCliente/{id}")
    public String eliminarCliente(@PathVariable long id) {
        clienteService.delete(id);
        return "redirect:/cliente";
    }
}
