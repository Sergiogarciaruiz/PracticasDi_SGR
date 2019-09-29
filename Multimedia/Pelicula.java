package multimedia;

import java.util.ArrayList;

public class Pelicula extends ElementoMultimedia {

    ArrayList actores;
    private String pais;
    private double duracion;

    public Pelicula(int codigo) {
        super(codigo);
    }

    public Pelicula(String país, double duracion, String título, String autor, int year, int codigo, ArrayList actores) {
        super(título, autor, year, codigo);
        this.pais = país;
        this.duracion = duracion;
        this.actores = actores;
    }

    public Pelicula() {
    }

    public ArrayList getActores() {
        return actores;
    }

    public void setActores(ArrayList actores) {
        this.actores = actores;
    }

    public String getPaís() {
        return pais;
    }

    public void setPaís(String país) {
        this.pais = país;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
    
    public String lista(){
    return "\nActores" + actores;
    
    }

    @Override
    public String toString() {

       return "Pelicula{" + super.toString() + ", pais: " + pais + ", duracion: " + duracion +"."+ lista();


    }
}
