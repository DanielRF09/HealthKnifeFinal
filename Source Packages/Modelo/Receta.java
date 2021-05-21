
package Modelo;

/**
 *
 * @author Daniel
 */
public class Receta {
    
    //Variables
    int idReceta;
    String nombreReceta;
    String imgReceta;
    String descripcion;
    int caloriasReceta;
    String tiempoReceta;
    Double precioReceta;
    String ingredientes;
    String procesos;
    String enfermedades;
    int idCategoriasRecetas;
    String nombreCategoria;

    public Receta() {
    }

    public Receta(int idReceta, String nombreReceta, String imgReceta, String descripcion, int caloriasReceta, String tiempoReceta, Double precioReceta, String ingredientes, String procesos, String enfermedades, int idCategoriasRecetas, String nombreCategoria) {
        this.idReceta = idReceta;
        this.nombreReceta = nombreReceta;
        this.imgReceta = imgReceta;
        this.descripcion = descripcion;
        this.caloriasReceta = caloriasReceta;
        this.tiempoReceta = tiempoReceta;
        this.precioReceta = precioReceta;
        this.ingredientes = ingredientes;
        this.procesos = procesos;
        this.enfermedades = enfermedades;
        this.idCategoriasRecetas = idCategoriasRecetas;
        this.nombreCategoria = nombreCategoria;
    }
    
    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public String getImgReceta() {
        return imgReceta;
    }

    public void setImgReceta(String imgReceta) {
        this.imgReceta = imgReceta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCaloriasReceta() {
        return caloriasReceta;
    }

    public void setCaloriasReceta(int caloriasReceta) {
        this.caloriasReceta = caloriasReceta;
    }

    public String getTiempoReceta() {
        return tiempoReceta;
    }

    public void setTiempoReceta(String tiempoReceta) {
        this.tiempoReceta = tiempoReceta;
    }

    public Double getPrecioReceta() {
        return precioReceta;
    }

    public void setPrecioReceta(Double precioReceta) {
        this.precioReceta = precioReceta;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getProcesos() {
        return procesos;
    }

    public void setProcesos(String procesos) {
        this.procesos = procesos;
    }

    public String getEnfermedades() {
        return enfermedades;
    }

    public void setEnfermedades(String enfermedades) {
        this.enfermedades = enfermedades;
    }

    public int getIdCategoriasRecetas() {
        return idCategoriasRecetas;
    }

    public void setIdCategoriasRecetas(int idCategoriasRecetas) {
        this.idCategoriasRecetas = idCategoriasRecetas;
    }

    
  
    
}
