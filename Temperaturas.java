package temperaturas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Temperaturas {

    public static boolean isNumeric(String strNum) {
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException | NullPointerException nfe) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList temperaturas = new ArrayList<Double>();
        int opcion = 1;

        while (opcion == 1 || opcion == 2 || opcion == 3 || opcion == 4 || opcion == 5) {
            System.out.println("1.-Introducir temperaturas\n2.-Mostrar temperaturas\n3.-Ordenar temperaturas\n4.-Mostrar extremos\n5.-Mostrar media\n6.-Salir");
            opcion = sc.nextInt();
            boolean x = true;
            switch (opcion) {
                //Introducir temperaturas
                case 1:
                    String temp;
                    System.out.println("Introduce temperaturas, introduzca un valor no numérico para parar de introducir temperaturas");
                    while (x) {

                        double d;
                        temp = sc.next();
                        sc.nextLine();
                        if (isNumeric(temp)) {

                            d = Double.parseDouble(temp);

                            temperaturas.add(d);
                        } else {

                            System.out.println("Ha introducido un valor no numérico");
                            x = false;
                        }
                    }

                    break;
                //Mostrar temperaturas

                case 2:
                    if (!temperaturas.isEmpty()) {
                        System.out.println("Temperaturas: ");
                        for (int i = 0; i < temperaturas.size(); i++) {
                            System.out.println(temperaturas.get(i));
                        }
                        break;
                    } else {
                        System.out.println("No se han registrado temperaturas");
                        break;
                    }
                //Ordenar temperaturas
                case 3:
                    if (!temperaturas.isEmpty()) {
                        System.out.println("Ordenando temperaturas....");
                        Collections.sort(temperaturas);
                        for (int i = 0; i < temperaturas.size(); i++) {
                            System.out.println(temperaturas.get(i));
                        }
                        System.out.println("Listo");
                        break;
                    } else {
                        System.out.println("No se han registrado temperaturas");
                        break;
                    }
                //Mostrar extremos
                case 4:

                    
                        try {
                            System.out.println("Mínimo: " + Collections.min(temperaturas) + "\nMáximo: " + Collections.max(temperaturas));
                            break;
                        } catch (NoSuchElementException e) {
                            System.out.println("No hay temperaturas registradas");
                            break;
                        }
                    
                //Calcular la media
                case 5:
                    if (!temperaturas.isEmpty()) {
                        double media = 0;
                        for (int i = 0; i < temperaturas.size(); i++) {
                            media += (double) temperaturas.get(i);
                        }
                        System.out.println("Media: " + media / temperaturas.size());
                    } else {
                        System.out.println("No se han registrado temperaturas");
                        break;
                    }
                case 6: 
                    System.out.println("Saliendo....");
                    break;
            }
        }
    }
}
