/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.service;

import Proyecto.entity.Entrenadores;
import Proyecto.repository.EntrenadoresRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeffrey Mojica S
 */
@Service
public class EntrenadoresService implements IEntrenadoresService {

    
     @Autowired
    private EntrenadoresRepository entrenadoresRepository;
     
     
    @Override
    public List<Entrenadores> listCoach() {
      return (List<Entrenadores>)entrenadoresRepository.findAll();
    }
    
}
