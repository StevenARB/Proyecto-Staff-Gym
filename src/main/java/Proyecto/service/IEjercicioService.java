package Proyecto.service;

import Proyecto.entity.Ejercicio;
import java.util.List;

/**
 *
 * @author Steven
 */
public interface IEjercicioService {
    public List<Ejercicio> getAllEjercicio();
    public List<Ejercicio> getEjercicioByTitulo(String titulo);
    public Ejercicio getEjercicioById (long id);
    public void saveEjercicio(Ejercicio ejercicio);
    public void delete (long id);    
}
