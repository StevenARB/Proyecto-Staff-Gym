/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto.repository;

import Proyecto.entity.Contacto;
import Proyecto.entity.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author keylo
 */
public interface ProductoRepository extends CrudRepository<Producto, Long>{
      @Query(value = "SELECT * FROM producto WHERE producto.precio LIKE %:filtro%", nativeQuery = true)
    List<Producto> findByPrecio(@Param("filtro") String filtro);

    public Producto findBynombre_producto(String username); 
}
