package Proyecto.repository;

import Proyecto.entity.Producto;
import org.springframework.data.repository.CrudRepository;


/**
 *
 * @author keylo
 */
public interface ProductoRepository extends CrudRepository<Producto, Long> {}
