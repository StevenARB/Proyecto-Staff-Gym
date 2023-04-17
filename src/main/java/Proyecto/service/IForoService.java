package Proyecto.service;

import java.util.List;
import Proyecto.entity.Foro;
/**
 *
 * @author aaron
 */
public interface IForoService {
    public List<Foro> getAllForo();
    public List<Foro> getForoByTitulo(String titulo);
    public Foro getForoById(long id);
    public void saveForo(Foro foro);
    public void delete (long id);
    
}
