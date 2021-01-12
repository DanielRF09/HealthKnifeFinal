
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
    String ingrediente1;
    String ingrediente2;
    String ingrediente3;
    String ingrediente4;
    String ingrediente5;
    String ingrediente6;
    String ingrediente7;
    String ingrediente8;
    String ingrediente9;
    String ingrediente10;
    String proceso1;
    String proceso2;
    String proceso3;
    String proceso4;
    String proceso5;
    String proceso6;
    String proceso7;
    String proceso8;
    String enfermedad;
    String enfermedad2;
    String enfermedad3;
    int idCategoriasRecetas;
    String nombreCategoria;

    public Receta() {
    }

    public Receta(int idReceta, String nombreReceta, String imgReceta, String descripcion, int caloriasReceta, String tiempoReceta, Double precioReceta, String ingrediente1, String ingrediente2, String ingrediente3, String ingrediente4, String ingrediente5, String ingrediente6, String ingrediente7, String ingrediente8, String ingrediente9, String ingrediente10, String proceso1, String proceso2, String proceso3, String proceso4, String proceso5, String proceso6, String proceso7, String proceso8, String enfermedad, String enfermedad2, String enfermedad3, int idCategoriasRecetas, String nombreCategoria) {
        this.idReceta = idReceta;
        this.nombreReceta = nombreReceta;
        this.imgReceta = imgReceta;
        this.descripcion = descripcion;
        this.caloriasReceta = caloriasReceta;
        this.tiempoReceta = tiempoReceta;
        this.precioReceta = precioReceta;
        this.ingrediente1 = ingrediente1;
        this.ingrediente2 = ingrediente2;
        this.ingrediente3 = ingrediente3;
        this.ingrediente4 = ingrediente4;
        this.ingrediente5 = ingrediente5;
        this.ingrediente6 = ingrediente6;
        this.ingrediente7 = ingrediente7;
        this.ingrediente8 = ingrediente8;
        this.ingrediente9 = ingrediente9;
        this.ingrediente10 = ingrediente10;
        this.proceso1 = proceso1;
        this.proceso2 = proceso2;
        this.proceso3 = proceso3;
        this.proceso4 = proceso4;
        this.proceso5 = proceso5;
        this.proceso6 = proceso6;
        this.proceso7 = proceso7;
        this.proceso8 = proceso8;
        this.enfermedad = enfermedad;
        this.enfermedad2 = enfermedad2;
        this.enfermedad3 = enfermedad3;
        this.idCategoriasRecetas = idCategoriasRecetas;
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

    public String getIngrediente1() {
        return ingrediente1;
    }

    public void setIngrediente1(String ingrediente1) {
        this.ingrediente1 = ingrediente1;
    }

    public String getIngrediente2() {
        return ingrediente2;
    }

    public void setIngrediente2(String ingrediente2) {
        this.ingrediente2 = ingrediente2;
    }

    public String getIngrediente3() {
        return ingrediente3;
    }

    public void setIngrediente3(String ingrediente3) {
        this.ingrediente3 = ingrediente3;
    }

    public String getIngrediente4() {
        return ingrediente4;
    }

    public void setIngrediente4(String ingrediente4) {
        this.ingrediente4 = ingrediente4;
    }

    public String getIngrediente5() {
        return ingrediente5;
    }

    public void setIngrediente5(String ingrediente5) {
        this.ingrediente5 = ingrediente5;
    }

    public String getIngrediente6() {
        return ingrediente6;
    }

    public void setIngrediente6(String ingrediente6) {
        this.ingrediente6 = ingrediente6;
    }

    public String getIngrediente7() {
        return ingrediente7;
    }

    public void setIngrediente7(String ingrediente7) {
        this.ingrediente7 = ingrediente7;
    }

    public String getIngrediente8() {
        return ingrediente8;
    }

    public void setIngrediente8(String ingrediente8) {
        this.ingrediente8 = ingrediente8;
    }

    public String getIngrediente9() {
        return ingrediente9;
    }

    public void setIngrediente9(String ingrediente9) {
        this.ingrediente9 = ingrediente9;
    }

    public String getIngrediente10() {
        return ingrediente10;
    }

    public void setIngrediente10(String ingrediente10) {
        this.ingrediente10 = ingrediente10;
    }

    public String getProceso1() {
        return proceso1;
    }

    public void setProceso1(String proceso1) {
        this.proceso1 = proceso1;
    }

    public String getProceso2() {
        return proceso2;
    }

    public void setProceso2(String proceso2) {
        this.proceso2 = proceso2;
    }

    public String getProceso3() {
        return proceso3;
    }

    public void setProceso3(String proceso3) {
        this.proceso3 = proceso3;
    }

    public String getProceso4() {
        return proceso4;
    }

    public void setProceso4(String proceso4) {
        this.proceso4 = proceso4;
    }

    public String getProceso5() {
        return proceso5;
    }

    public void setProceso5(String proceso5) {
        this.proceso5 = proceso5;
    }

    public String getProceso6() {
        return proceso6;
    }

    public void setProceso6(String proceso6) {
        this.proceso6 = proceso6;
    }

    public String getProceso7() {
        return proceso7;
    }

    public void setProceso7(String proceso7) {
        this.proceso7 = proceso7;
    }

    public String getProceso8() {
        return proceso8;
    }

    public void setProceso8(String proceso8) {
        this.proceso8 = proceso8;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getEnfermedad2() {
        return enfermedad2;
    }

    public void setEnfermedad2(String enfermedad2) {
        this.enfermedad2 = enfermedad2;
    }

    public String getEnfermedad3() {
        return enfermedad3;
    }

    public void setEnfermedad3(String enfermedad3) {
        this.enfermedad3 = enfermedad3;
    }
    
    

    public int getIdCategoriasRecetas() {
        return idCategoriasRecetas;
    }

    public void setIdCategoriasRecetas(int idCategoriasRecetas) {
        this.idCategoriasRecetas = idCategoriasRecetas;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    } 
    
}
