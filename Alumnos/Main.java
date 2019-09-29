/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alumnos;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Usuario DAM 2
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = true;
        Hashtable<String, Alumno> listaHash = new Hashtable();
        int opcion;

        do {
            ArrayList<Integer> matriculas = new ArrayList();
            System.out.println("1.-Agregar alumno\n"
                    + "2.-Buscar alumno\n"
                    + "3.-Borrar alumno\n"
                    + "4.-Listar alumnos\n"
                    + "5.-Listar dni\n"
                    + "6.-Salir");

            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    Integer matricula;
                    System.out.println("Introduce el DNI:");
                    String dni = sc.next();
                    if (!listaHash.containsKey(dni)) {

                        System.out.println("Introduce el nombre:");
                        String nombre = sc.next();
                        System.out.println("Introduce el apellido:");
                        String apellido = sc.next();
                        do {
                            matricula = (int) (Math.random() * 100);

                        } while (matriculas.contains(matricula));

                        System.out.println("Matricula " + matricula);

                        Alumno alumno = new Alumno(nombre, apellido, dni, matricula);
                        listaHash.put(alumno.getDni(), alumno);

                    } else {
                        System.out.println("El alumno ya está registrado");
                    }
                    break;

                case 2:
                    System.out.println("Introduce DNI para buscar: ");
                    String dnibuscado = sc.next();
                    if (listaHash.containsKey(dnibuscado)) {
                        Alumno encontrado = listaHash.get(dnibuscado);
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    ;
                    break;
                case 3:
                    System.out.println("Introduce el DNI para eliminar: ");
                    dnibuscado = sc.next();
                    if (listaHash.containsKey(dnibuscado)) {
                        Alumno encontrado = listaHash.get(dnibuscado);
                        listaHash.remove(encontrado.getDni());
                        System.out.println("Eliminado");
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    ;
                    break;
                case 4:
                    Enumeration<Alumno> elementos = listaHash.elements();
                    while (elementos.hasMoreElements()) {
                        Alumno alumno1 = elementos.nextElement();
                        System.out.println(alumno1.toString());
                    }
                    break;
                case 5:
                    Enumeration<String> claves = listaHash.keys();
                    while (claves.hasMoreElements()) {
                        String clave = claves.nextElement();
                        Alumno encontradoKey = listaHash.get(clave);
                        System.out.println(encontradoKey.getDni());

                    }
                    break;
                case 6:
                    salir = false;
                    break;
            }

        } while (opcion != 6);
    }

}
