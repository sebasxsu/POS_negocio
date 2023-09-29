package Presentacion;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import logica.Combo;
import logica.Factura;
import logica.Producto;
import logica.burger;

public class Principal {
    public static void main(String[] args)
    {
            Scanner sc = new Scanner(System.in);
            int opcion = 0;
            
            while (opcion != 3) {
                System.out.println("=============MENU============\n"
                                    + "1: Añadir a la canasta\n"
                                    + "2: Mostrar factura\n"
                                    + "3: Salida\n");
                System.out.println("Seleccione una opcion: \n");
                opcion = sc.nextInt();
                
                if (opcion == 1) {
                } else if (opcion == 2) {
                } else if (opcion == 3) {
                    return;
                }
            }
    }
}