package Proyecto.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import Proyecto.entity.Usuario;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author aaron
 */

public class Userprincipal implements UserDetails {
    private Usuario usuario;
    
    public Userprincipal(Usuario usuario){
        this.usuario = usuario;
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        
        this.usuario.getPermissionList().forEach(p -> {
            GrantedAuthority authority = new SimpleGrantedAuthority(p);
            authorities.add(authority);
        });
        
        this.usuario.getRoleList().forEach(r -> {
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
            authorities.add(authority);
        });
        return authorities;
    }
    
    @Override
    public String getPassword() {
        return this.usuario.getPassword();
    }
    
    @Override
    public String getUsername() {
        return this.usuario.getNombre();
    }
    
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }
    
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }
    
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }
    
    @Override
    public boolean isEnabled(){
        return this.usuario.getActive() == 1;
    }
}
