package Proyecto.service;

import Proyecto.entity.Usuario;
import java.util.List;

/**
 *
 * @author Steven
 */
public interface IUsuarioService {
    public List<Usuario> getAllUsuario();
    public List<Usuario> getUsuarioByCedula(String cedula);
    public Usuario getUsuarioById (long id);
    public void saveUsuario(Usuario usuario);
    public void delete (long id);
    public Usuario findByNombre (String username);
}
