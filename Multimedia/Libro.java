package multimedia;

public class Libro extends ElementoMultimedia{

    private String edicion, soporteDigital;
    private int numeroPaginas;

    public Libro(int codigo) {
        super(codigo);
    }
    
    

    public Libro(String edicion, String soporteDigital, int numeroPaginas, String título, String autor, int year, int codigo) {
        super(título, autor, year, codigo);
        this.edicion = edicion;
        this.soporteDigital = soporteDigital;
        this.numeroPaginas = numeroPaginas;
    }

    public String getEdición() {
        return edicion;
    }

    public void setEdición(String edición) {
        this.edicion = edición;
    }

    public String getSoporteDigital() {
        return soporteDigital;
    }

    public void setSoporteDigital(String soporteDigital) {
        this.soporteDigital = soporteDigital;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" + super.toString() + " edicion: " + edicion + ", soporte digital: " + soporteDigital + ", numero de páginas: " + numeroPaginas + '}';
    }

   

}
