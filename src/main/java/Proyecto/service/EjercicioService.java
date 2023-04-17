package Proyecto.service;

import Proyecto.entity.Ejercicio;
import Proyecto.repository.EjercicioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Steven
 */
@Service
public class EjercicioService implements IEjercicioService {
    
    @Autowired
    private EjercicioRepository ejercicioRepository;

    @Override
    public List<Ejercicio> getAllEjercicio() {
        return (List<Ejercicio>) ejercicioRepository.findAll();
    }

    @Override
    public List<Ejercicio> getEjercicioByTitulo(String titulo) {
        return (List<Ejercicio>) ejercicioRepository.findByTitulo(titulo);
    }

    @Override
    public Ejercicio getEjercicioById(long id) {
        return ejercicioRepository.findById(id).orElse(null);
    }

    @Override
    public void saveEjercicio(Ejercicio ejercicio) {
        ejercicioRepository.save(ejercicio);
    }

    @Override
    public void delete(long id) {
        ejercicioRepository.deleteById(id);
    }
}
