package Presentacion;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.List;
import logica.Factura;
import logica.Producto;
import java.io.FileNotFoundException;
import java.io.File;

public class Principal {
    public static void main(String[] args) {
        // Leer los productos de los archivos de texto
        List<Producto> productos = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("Productos.dat"));
            while (sc.hasNextLine()) {
                String[] partes = sc.nextLine().split(";");
                productos.add(new Producto(Integer.parseInt(partes[0]), Integer.parseInt(partes[1]), partes[2],
                        Double.parseDouble(partes[3]), Double.parseDouble(partes[4]), Integer.parseInt(partes[5])));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scUserInput = new Scanner(System.in);
        int opcion = 0;
        List<Producto> canasta = new ArrayList<>();
        while (opcion != 3) {
            // mostrar el menú
            System.out.println("=============MENU============\n"
                    + "1: Ver canasta\n"
                    + "2: Generar factura\n"
                    + "3: Salida\n");
            System.out.println("Seleccione una opcion: \n");
            opcion = scUserInput.nextInt();

            if (opcion == 1) {
                // mostrar la canasta
                System.out.println("=============CANASTA============");
                if (canasta.isEmpty()) {
                    System.out.println("No tienes productos dentro de tu canasta!");
                } else {
                    System.out.println("Tu canasta:");
                    for (Producto producto : canasta) {
                        System.out.println(producto.getNombre() + ": " + producto.getPrecioVenta());
                    }
                }
                // submenú en "Ver canasta"
                System.out.println("1: Regresar al menú principal\n"
                        + "2: Añadir a la canasta\n");
                System.out.println("Seleccione una opcion: \n");
                int opcionSubMenu = scUserInput.nextInt();
                if (opcionSubMenu == 2) {
                    // añadir a la canasta
                    System.out.println("Productos disponibles:");
                    for (Producto producto : productos) {
                        System.out.println(producto.getId() + ": " + producto.getNombre());
                    }
                    System.out.println("Ingrese el ID del producto que desea añadir a la canasta:");
                    int id = Integer.parseInt(scUserInput.next());
                    for (Producto producto : productos) {
                        if (producto.getId() == id) {
                            canasta.add(producto);
                            System.out.println("Producto añadido a la canasta!");
                            break;
                        }
                    }
                }
            } else if (opcion == 2) {
                // generar factura
                double total = 0;
                System.out.println("Factura:");
                for (Producto producto : canasta) {
                    System.out.println(producto.getNombre() + ": " + producto.getPrecioVenta());
                    total += producto.getPrecioVenta();
                }
                System.out.println("Total: " + total);
            } else if (opcion == 3) {
                return;
            }
        }
        scUserInput.close();
    }
}