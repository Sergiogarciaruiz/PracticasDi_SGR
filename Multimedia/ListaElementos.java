package multimedia;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

public class ListaElementos implements Serializable{

    private Hashtable<Integer, ElementoMultimedia> listadoElementos;

    public ListaElementos() {
        listadoElementos = new Hashtable();
    }

    public void agregarElemento(ElementoMultimedia ele) {
        listadoElementos.put(ele.getCodigo(), ele);
    }

    public boolean comprobarLista(int codigo) {
        return listadoElementos.containsKey(codigo);
    }

    public void eliminarElemento(int codigo) {
        listadoElementos.remove(codigo);
    }

    public void listarElementos() {
        Enumeration<ElementoMultimedia> e = listadoElementos.elements();
        while (e.hasMoreElements()) {
            ElementoMultimedia ele = e.nextElement();
            System.out.println(ele);

        }
    }
    

    
    public boolean comprobarVacio(){
    return listadoElementos.isEmpty();
    
    }

}
