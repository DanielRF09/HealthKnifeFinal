
package Interfaces;

import Modelo.Usuario;
import java.util.List;

public interface CRUDUsuarios {
    public List listar();
    public Usuario list(int idUsuario);
    public boolean agregar(Usuario usu);
    public boolean editar(Usuario usu);
    public boolean eliminar(int idUsuario);
    
    
}
