package Proyecto.repository;

import Proyecto.entity.Cliente;
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
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query(value = "SELECT * FROM clientes WHERE clientes.cedula LIKE %:filtro%", nativeQuery = true)
    List<Cliente> findByCedula(@Param("filtro") String filtro);
}
