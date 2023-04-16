/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto.service;

import Proyecto.entity.Contactar;
import java.util.List;

/**
 *
 * @author Jeffrey Mojica S
 */
public interface IContactarService {
    
   
    public List<Contactar> getAllContactar();
    public Contactar getContactarById (long id);
    public void saveContactar(Contactar contactar);
    public void delete (long id);
    public List<Contactar> getContactarByNombreUsuario(String nombreU);
   
    
    
}
