package Proyecto.service;

import Proyecto.entity.Anuncio;
import Proyecto.repository.AnuncioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Steven
 */
@Service
public class AnuncioService implements IAnuncioService {
    
    @Autowired
    private AnuncioRepository anuncioRepository;

    @Override
    public List<Anuncio> getAllAnuncio() {
        return (List<Anuncio>) anuncioRepository.findAll();
    }

    @Override
    public List<Anuncio> getAnuncioByTitulo(String titulo) {
        return (List<Anuncio>) anuncioRepository.findByTitulo(titulo);
    }

    @Override
    public Anuncio getAnuncioById(long id) {
        return anuncioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveAnuncio(Anuncio anuncio) {
        anuncioRepository.save(anuncio);
    }

    @Override
    public void delete(long id) {
        anuncioRepository.deleteById(id);
    }
}
