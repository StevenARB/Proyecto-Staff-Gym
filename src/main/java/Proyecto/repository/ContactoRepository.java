/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto.repository;

import Proyecto.entity.Contacto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jeffrey Mojica S
 */
@Repository
public interface ContactoRepository extends CrudRepository<Contacto,Long> {
    @Query(value = "SELECT * FROM contacto WHERE contacto.apellidos LIKE %:filtro%", nativeQuery = true)
    List<Contacto> findByApellidos(@Param("filtro") String filtro);

    public Contacto findByNombre(String username); 
}
