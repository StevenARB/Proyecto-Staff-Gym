package Proyecto.controller;

import Proyecto.entity.Usuario;
import Proyecto.service.IUsuarioService;
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
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuario")
    public String index(Model model) {
        List<Usuario> listaUsuario = usuarioService.getAllUsuario();
        model.addAttribute("titulo", "Usuarios");
        model.addAttribute("usuarios", listaUsuario);
        return "usuario";
    }

    @RequestMapping("/usuarioCedula")
    public String buscarCedula(Model model, @Param("cedula") String cedula) {
        List<Usuario> listaUsuario = usuarioService.getUsuarioByCedula(cedula);
        model.addAttribute("titulo", "Usuarios");
        model.addAttribute("usuarios", listaUsuario);
        return "usuario";
    }

    @GetMapping("/crearUsuario")
    public String crearUsuario(Model model) {
        model.addAttribute("titulo", "Nuevo Usuario");
        model.addAttribute("usuario", new Usuario());
        return "usuarioCU";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.saveUsuario(usuario);
        return "redirect:/usuario";
    }

    @GetMapping("/actualizarUsuario/{id}")
    public String actualizarUsuario(@PathVariable("id") Long idUsuario, Model model) {
        Usuario usuario = usuarioService.getUsuarioById(idUsuario);
        model.addAttribute("titulo", "Actualizar Usuario");
        model.addAttribute("usuario", usuario);
        return "usuarioCU";
    }

    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable long id) {
        usuarioService.delete(id);
        return "redirect:/usuario";
    }
}
