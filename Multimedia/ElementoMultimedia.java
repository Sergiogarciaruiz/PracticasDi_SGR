package multimedia;

import java.io.Serializable;

public abstract class ElementoMultimedia implements Serializable{
    
    private String titulo, autor;
    private int year, codigo;

    public ElementoMultimedia() {
    }

    public ElementoMultimedia(int codigo) {
        this.codigo = codigo;
    }
    
    

    public ElementoMultimedia(String título, String autor, int year, int codigo) {
        this.titulo = título;
        this.autor = autor;
        this.year = year;
        this.codigo = codigo;
    }

    public String getTítulo() {
        return titulo;
    }

    public void setTítulo(String título) {
        this.titulo = título;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + ", autor: " + autor + ", año: " + year + ", codigo: " + codigo;
    }
    

    
    
    
}
