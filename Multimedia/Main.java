package multimedia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int opcion2 = 0;
        ListaElementos lista = new ListaElementos();

//        File ficheroObjeto = new File("src/documentos/Biblioteca.obj");
//        ObjectInputStream ois = null;
//        try {
//            ois = new ObjectInputStream(new FileInputStream(ficheroObjeto));
//            lista = (Hashtable<Integer, ElementoMultimedia>) ois.readObject();
//            Enumeration<ElementoMultimedia> elementos = lista.elements();
//            while (elementos.hasMoreElements()) {
//                ElementoMultimedia encontrado = elementos.nextElement();
//                listapro.put(encontrado.getCodigo(), encontrado);
//                System.out.println("Entontrado");
//            }
//            lista = listapro;
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                ois.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        do {
            System.out.println("        1.-Agregar\n"
                    + "        2.-Eliminar\n"
                    + "        3.-Listar\n"
                    + "        4.-Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    int codigo,
                     year;
                    String titulo,
                     autor;

                    System.out.println("¿Que elemento multimedia quiere agregar?");
                    System.out.println("        1.-Libro\n"
                            + "        2.-Musica\n"
                            + "        3.-Pelicula\n"
                            + "        4.-Volver");
                    opcion2 = sc.nextInt();

                    File fO = new File("src/documentos/Biblioteca.obj");
                    ObjectOutputStream oos = null;

                    switch (opcion2) {
                        case 1:
                            String edicion,
                             soporteDigital;
                            int numeroPaginas;

                            System.out.println("Introduce los datos del libro");
                            System.out.println("Codigo");
                            codigo = sc.nextInt();
                            if (!lista.comprobarLista(codigo)) {
                                System.out.println("Titulo");
                                titulo = sc.next();
                                sc.nextLine();
                                System.out.println("Autor");
                                autor = sc.next();
                                sc.nextLine();
                                System.out.println("Año");
                                year = sc.nextInt();
                                System.out.println("Edición");
                                edicion = sc.next();
                                sc.nextLine();
                                System.out.println("Soporte Digital");
                                soporteDigital = sc.next();
                                sc.nextLine();

                                System.out.println("Numero de paginas");
                                numeroPaginas = sc.nextInt();

                                ElementoMultimedia libro = new Libro(edicion, soporteDigital, numeroPaginas, titulo, autor, year, codigo);
                                lista.agregarElemento(libro);

                                try {
                                    oos = new ObjectOutputStream(new FileOutputStream(fO));
                                    oos.writeObject(libro);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    // el archivo ha provocado el fallo
                                } finally {
                                    try {
                                        oos.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        // el cerrado ha provocado el fallo
                                    }
                                }

                                System.out.println("Agregado");

                            } else {
                                System.out.println("El codigo ya esta en uso");
                            }
                            break;
                        case 2:
                            String soporte;
                            String directox;
                            double duracion;
                            boolean directo;

                            System.out.println("Introduce los datos de la cancion");
                            System.out.println("Codigo");
                            codigo = sc.nextInt();
                            if (!lista.comprobarLista(codigo)) {
                                System.out.println("Titulo");
                                titulo = sc.next();
                                sc.nextLine();
                                System.out.println("Autor");
                                autor = sc.next();
                                sc.nextLine();
                                System.out.println("Año");
                                year = sc.nextInt();
                                System.out.println("Soporte");
                                soporte = sc.next();
                                sc.nextLine();
                                System.out.println("Directo (S/N)");
                                directox = sc.next();
                                sc.nextLine();
                                if (directox.equalsIgnoreCase("s")) {
                                    directox = "true";
                                    directo = Boolean.parseBoolean(directox);
                                } else {
                                    directox = "false";
                                    directo = Boolean.parseBoolean(directox);
                                }
                                System.out.println("Duracion");
                                duracion = sc.nextDouble();
                                ElementoMultimedia musica = new Musica(soporte, duracion, directo, titulo, autor, year, codigo);
                                lista.agregarElemento(musica);

                                try {
                                    oos = new ObjectOutputStream(new FileOutputStream(fO));
                                    oos.writeObject(musica);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    // el archivo ha provocado el fallo
                                } finally {
                                    try {
                                        oos.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        // el cerrado ha provocado el fallo
                                    }
                                }
                                System.out.println("Agregado");

                            } else {
                                System.out.println("El codigo ya esta en uso");
                            }
                            break;
                        case 3:
                            String pais;
                            ArrayList<String> actores = new ArrayList();

                            System.out.println("Introduce los datos de la pelicula");
                            System.out.println("Codigo");
                            codigo = sc.nextInt();
                            if (!lista.comprobarLista(codigo)) {
                                System.out.println("Titulo");
                                titulo = sc.next();
                                sc.nextLine();
                                System.out.println("Autor");
                                autor = sc.next();
                                sc.nextLine();
                                System.out.println("Año");
                                year = sc.nextInt();
                                System.out.println("Pais");
                                pais = sc.next();
                                sc.nextLine();
                                System.out.println("Duracion");
                                duracion = sc.nextDouble();

                                System.out.println("Introduzca actores hasta que pulse '0'");
                                String actor;

                                do {
                                    actor = sc.next();
                                    sc.nextLine();

                                    System.out.println("Añadido");
                                    actores.add(actor);

                                } while (!actor.equals("0"));

                                ElementoMultimedia pelicula = new Pelicula(pais, duracion, titulo, autor, year, codigo, actores);
                                lista.agregarElemento(pelicula);

                                try {
                                    oos = new ObjectOutputStream(new FileOutputStream(fO));
                                    oos.writeObject(pelicula);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                    // el archivo ha provocado el fallo
                                } finally {
                                    try {
                                        oos.close();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        // el cerrado ha provocado el fallo
                                    }
                                }
                                System.out.println("Agregado");

                            } else {
                                System.out.println("El codigo ya esta en uso");
                            }
                            break;

                    }
                    break;
                case 2:
                    System.out.println("Eliga el codigo del elemento que quiere eliminar");
                    int codigox = sc.nextInt();

                    if (lista.comprobarLista(codigox)) {
                        lista.eliminarElemento(codigox);
                    } else {
                        System.out.println("El codigo no existe");
                    }
                    break;
                case 3:
                    if (lista.comprobarVacio()) {
                        System.out.println("La lista esta vacia");

                    } else {
                        System.out.println("Listando...");
                        lista.listarElementos();
                        break;
                    }
            }

        } while (opcion != 4);
        System.out.println("No consigo añadir los fichheros 😓");
    }
}
