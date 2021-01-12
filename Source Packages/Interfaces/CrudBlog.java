
package Interfaces;

import Modelo.Blog;
import java.util.List;

public interface CrudBlog {
    
    //Metodos
    public List listar();
    public List listarUsuarios();
    public List listarNutriologos();
    public Blog list(int idBlog);
    public boolean agregar(Blog blo);
    public boolean editar(Blog blo);
    public boolean eliminar(int idBlog);
}
