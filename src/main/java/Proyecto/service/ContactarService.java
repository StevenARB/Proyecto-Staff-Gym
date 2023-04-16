/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.service;

import Proyecto.entity.Contactar;
import Proyecto.entity.Contacto;
import Proyecto.repository.ContactarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeffrey Mojica S
 */
@Service
public class ContactarService implements IContactarService{

    @Autowired
    private ContactarRepository contactarRepository;
      
    
    
    @Override
    public List<Contactar> getAllContactar() {
        return(List<Contactar>)contactarRepository.findAll();   
    }
    

    @Override
    public Contactar getContactarById(long id) {
      return contactarRepository.findById(id).orElse(null);
    }

    @Override
    public void saveContactar(Contactar contactar) {
         contactarRepository.save(contactar);
    }

    @Override
    public void delete(long id) {
        contactarRepository.deleteById(id);
    }

    @Override
    public List<Contactar> getContactarByNombreUsuario(String nombreU) {
       return (List<Contactar>) contactarRepository.buscarPorNombreU(nombreU);
    }

   
  
    
}
