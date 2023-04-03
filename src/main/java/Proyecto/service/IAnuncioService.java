package Proyecto.service;

import Proyecto.entity.Anuncio;
import java.util.List;

/**
 *
 * @author Steven
 */
public interface IAnuncioService {
    public List<Anuncio> getAllAnuncio();
    public List<Anuncio> getAnuncioByTitulo(String titulo);
    public Anuncio getAnuncioById (long id);
    public void saveAnuncio(Anuncio anuncio);
    public void delete (long id);
}
