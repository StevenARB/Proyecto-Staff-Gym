package Proyecto.repository;

import Proyecto.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steven
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Long> {}
