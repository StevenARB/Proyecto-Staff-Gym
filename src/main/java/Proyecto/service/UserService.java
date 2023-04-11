package Proyecto.service;

import Proyecto.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author aaron
 */
@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    public IUsuarioService usuarioService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = this.usuarioService.findByNombre(username);
        Userprincipal userPrincipal = new Userprincipal(usuario);
        return userPrincipal;
    }
}
