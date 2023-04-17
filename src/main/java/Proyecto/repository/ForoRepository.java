package Proyecto.repository;

import java.util.List;
import Proyecto.entity.Foro;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author aaron
 */
@Repository
public interface ForoRepository extends CrudRepository<Foro, Long> {
    @Query(value = "SELECT * FROM foro WHERE foro.titulo LIKE %:filtro%", nativeQuery = true)
    List<Foro> findByTitulo(@Param("filtro") String filtro);
}
