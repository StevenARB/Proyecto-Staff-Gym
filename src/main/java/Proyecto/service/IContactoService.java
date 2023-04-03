/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Proyecto.service;

import Proyecto.entity.Contacto;
import java.util.List;

/**
 *
 * @author Jeffrey Mojica S
 */
public interface IContactoService {
    public List<Contacto> getAllContacto();
    public Contacto getContactoById (long id);
    public void saveContacto(Contacto contacto);
    public void delete (long id);
}
