
package Interfaces;

import Modelo.Administrador;
import java.util.List;


public interface CRUDAdministradores {
    
    public List listar();
    public Administrador list(int idAdministrador);
    public boolean agregar(Administrador adm);
    public boolean editar(Administrador adm);
    public boolean eliminar(int idAdministrador);
    
}
