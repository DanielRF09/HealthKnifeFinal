
package Interfaces;

import Modelo.CRecetas;
import java.util.List;


public interface ICRecetas {
    
    public boolean Agregar (CRecetas cre);
    public List recetasGuardadas(int idUsuario);
    public CRecetas listrecetaGuardada(int idReceta);
    
}
