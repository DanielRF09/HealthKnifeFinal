
package Interfaces;

import Modelo.Receta;
import java.util.List;

public interface CRUDRecetas {
    
    public List listar();
    public List listarindexAdministrador();
    public List listarindexUsuario();
    public List listarindexPrincipal();
    public List listarindexNutriologo();
    public Receta list(int idReceta);
    public Receta listreceta(int idReceta);
    public Receta listrecetaPrincipal(int idReceta);
    public Receta listrecetaUsuario(int idReceta);
    public Receta listrecetaNutriologo(int idReceta);
    public boolean agregar(Receta rec);
    public boolean editar(Receta rec);
    public boolean eliminar(int idReceta);
}
