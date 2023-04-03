package Proyecto.repository;

import Proyecto.entity.Anuncio;
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
public interface AnuncioRepository extends CrudRepository<Anuncio, Long> {
    
    @Query(value = "SELECT * FROM anuncios WHERE anuncios.titulo LIKE %:filtro%", nativeQuery = true)
    List<Anuncio> findByTitulo(@Param("filtro") String filtro);
}
