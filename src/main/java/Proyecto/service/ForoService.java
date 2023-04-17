package Proyecto.service;

import java.util.List;
import Proyecto.entity.Foro;
import Proyecto.repository.ForoRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author aaron
 */
@Service
public class ForoService implements IForoService {
    
    @Autowired
    private ForoRepository foroRepository;
    
    @Override
    public List<Foro> getAllForo() {
        return (List<Foro>) foroRepository.findAll();
    }
    
    @Override
    public List<Foro> getForoByTitulo(String titulo) {
        return (List<Foro>) foroRepository.findByTitulo(titulo);
    }
    @Override
    public Foro getForoById(long id) {
        return foroRepository.findById(id).orElse(null);
    }
    
    @Override
    public void saveForo(Foro foro) {
        foroRepository.save(foro);
    }
    
    @Override
    public void delete(long id) {
        foroRepository.deleteById(id);
    }
}
