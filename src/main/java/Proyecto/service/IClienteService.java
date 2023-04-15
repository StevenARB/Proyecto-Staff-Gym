package Proyecto.service;

import Proyecto.entity.Cliente;
import java.util.List;

/**
 *
 * @author Steven
 */
public interface IClienteService {
    public List<Cliente> getAllCliente();
    public List<Cliente> getClienteByCedula(String cedula);
    public Cliente getClienteById (long id);
    public void saveCliente(Cliente cliente);
    public void delete (long id);
}
