/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proyecto.service;

import Proyecto.entity.Contacto;
import Proyecto.repository.ContactoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jeffrey Mojica S
 */
@Service
public class ContactoService implements IContactoService {

    @Autowired
    private ContactoRepository contactoRepository;
    
    @Override
    public List<Contacto> getAllContacto() {
       return (List<Contacto>)contactoRepository.findAll(); 
    }

    @Override
    public Contacto getContactoById(long id) {
       return contactoRepository.findById(id).orElse(null);
    }

    @Override
    public void saveContacto(Contacto contacto) {
       contactoRepository.save(contacto);
    }

    @Override
    public void delete(long id) {
        contactoRepository.deleteById(id);
    }
    
}
