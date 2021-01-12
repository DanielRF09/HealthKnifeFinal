
package Modelo;


public class Blog {
    
    //Variables
    int idBlog;
    String imgBlog;
    String tituloBlog;
    String cuerpoBlog;

    public Blog() {
    }

    public Blog(int idBlog, String imgBlog, String tituloBlog, String cuerpoBlog) {
        this.idBlog = idBlog;
        this.imgBlog = imgBlog;
        this.tituloBlog = tituloBlog;
        this.cuerpoBlog = cuerpoBlog;
    }

    public int getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(int idBlog) {
        this.idBlog = idBlog;
    }

    public String getImgBlog() {
        return imgBlog;
    }

    public void setImgBlog(String imgBlog) {
        this.imgBlog = imgBlog;
    }

    public String getTituloBlog() {
        return tituloBlog;
    }

    public void setTituloBlog(String tituloBlog) {
        this.tituloBlog = tituloBlog;
    }

    public String getCuerpoBlog() {
        return cuerpoBlog;
    }

    public void setCuerpoBlog(String cuerpoBlog) {
        this.cuerpoBlog = cuerpoBlog;
    }
    
    
}
