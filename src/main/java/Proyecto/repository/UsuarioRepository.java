package Proyecto.repository;

import Proyecto.entity.Usuario;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Steven
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    @Query(value = "SELECT * FROM usuarios WHERE usuarios.email LIKE %:filtro%", nativeQuery = true)
    List<Usuario> findByEmail(@Param("filtro") String filtro);

    Usuario findByNombre(String username);
}
