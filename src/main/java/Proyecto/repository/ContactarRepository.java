/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto.repository;

import Proyecto.entity.Contactar;
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
public interface ContactarRepository extends CrudRepository<Contactar,Long>{
    
   @Query(value="SELECT * FROM contactarlos WHERE contactarlos.nombreU LIKE %:filtro%", nativeQuery=true)
public List<Contactar> buscarPorNombreU(@Param("filtro") String filtro);


   
     
}
