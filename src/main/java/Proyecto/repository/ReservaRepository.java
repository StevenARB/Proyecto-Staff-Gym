/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto.repository;

import Proyecto.entity.Reserva;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author keylo
 */
public interface ReservaRepository extends CrudRepository<Reserva, Long>{
     @Query(value = "SELECT * FROM reservacion WHERE reservacion.cedula LIKE %:filtro%", nativeQuery = true)
    List<Reserva> findByCedula(@Param("filtro") String filtro);

    public Reserva findByNombre(String username);
}
