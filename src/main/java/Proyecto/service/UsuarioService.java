package Proyecto.service;

import Proyecto.entity.Usuario;
import Proyecto.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Steven
 */
@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> getAllUsuario() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> getUsuarioByEmail(String email) {
        return (List<Usuario>) usuarioRepository.findByEmail(email);
    }

    @Override
    public Usuario getUsuarioById(long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }
    @Override
    public Usuario findByNombre (String username) {
        return usuarioRepository.findByNombre(username);
    }}
