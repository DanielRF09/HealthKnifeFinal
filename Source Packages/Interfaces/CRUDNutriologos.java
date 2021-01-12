
package Interfaces;

import Modelo.Nutriologo;
import java.util.List;


public interface CRUDNutriologos {
    
    public List listar();
    public Nutriologo list(int idNutriologo);
    public boolean agregar(Nutriologo nut);
    public boolean editar(Nutriologo nut);
    public boolean eliminar(int idNutriologo);
}
