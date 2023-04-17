package Proyecto.repository;

import Proyecto.entity.Ejercicio;
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
public interface EjercicioRepository extends CrudRepository<Ejercicio, Long> {
    
    @Query(value = "SELECT * FROM ejercicios WHERE ejercicios.titulo LIKE %:filtro%", nativeQuery = true)
    List<Ejercicio> findByTitulo(@Param("filtro") String filtro);
}
