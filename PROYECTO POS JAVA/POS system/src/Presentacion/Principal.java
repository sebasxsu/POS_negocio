package Presentacion;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

import Logica.Ingrediente;
import Logica.Combo;
import Logica.Factura;
import Logica.Producto;

public class Principal {
    public static void main(String[] args) {
        // Leer los productos de los archivos de texto
        List<Logica.Producto> productos = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("Productos.dat"));
            while (sc.hasNextLine()) {
                String[] partes = sc.nextLine().split(";");
                productos.add(new Logica.Producto(Integer.parseInt(partes[0]), partes[1],
                        Double.parseDouble(partes[2])));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ArrayList<String> lineas = archivo.leerArchivo("Ingredientes.dat");
        ArrayList<Ingrediente> ingredientes = new ArrayList<>();
        for (String linea : lineas) {
            String[] partes = linea.split(";");
            ingredientes.add(new Ingrediente(Integer.parseInt(partes[0]), partes[1], Double.parseDouble(partes[2])));
        }
        List<Combo> combos = new ArrayList<>();
        try {
            Scanner sc = new Scanner(new File("Combos.dat"));
            while (sc.hasNextLine()) {
                String[] partes = sc.nextLine().split(";");
                int idCombo = Integer.parseInt(partes[0]);
                String nombreCombo = partes[1];
                double precioCombo = Double.parseDouble(partes[2]);
                List<Producto> productosCombo = new ArrayList<>();
                String[] idsProductos = partes[3].split(",");
                for (String idProducto : idsProductos) {
                    int id = Integer.parseInt(idProducto);
                    for (Producto producto : productos) {
                        if (producto.getId() == id) {
                            productosCombo.add(producto);
                            break;
                        }
                    }
                }
                combos.add(new Combo(idCombo, nombreCombo, precioCombo, productosCombo));
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        HashMap<Integer, List<Ingrediente>> productosIngredientes = new HashMap<>();
        try {
            Scanner sc = new Scanner(new File("Productos_Ingredientes.dat"));
            while (sc.hasNextLine()) {
                String[] partes = sc.nextLine().split(";");
                int idProducto = Integer.parseInt(partes[0]);
                List<Ingrediente> inredientes = new ArrayList<>();
                for (int i = 1; i < partes.length; i++) {
                    int idIngrediente = Integer.parseInt(partes[i]);
                    inredientes.add(ingredientes.get(idIngrediente - 100));
                }
                productosIngredientes.put(idProducto, inredientes);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scUserInput = new Scanner(System.in);
        int opcion = 0;
        List<Logica.Producto> canasta = new ArrayList<>();
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
                    for (Logica.Producto producto : canasta) {
                        System.out.println(producto.getNombre() + ": " + producto.getPrecio());
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
                    for (Logica.Producto producto : productos) {
                        System.out.println(producto.getId() + ": " + producto.getNombre());
                    }
                    System.out.println("Ingrese el ID del producto que desea añadir a la canasta:");
                    int id = Integer.parseInt(scUserInput.next());
                    for (Logica.Producto producto : productos) {
                        if (producto.getId() == id) {
                            // Crear una lista de ingredientes para el producto
                            List<Ingrediente> ingredientesProducto = new ArrayList<>();
                            // Agregar los ingredientes correspondientes al producto a la lista ingredientesProducto
                            for (Ingrediente ingrediente : productosIngredientes.get(producto.getId())) {
                                ingredientesProducto.add(ingrediente);
                            }
                            // Crear la instancia de Producto pasando la lista de ingredientes
                            canasta.add(new Logica.Producto(producto.getId(), producto.getNombre(), producto.getPrecio(), ingredientesProducto));
                            System.out.println("Producto añadido a la canasta!");
                            // submenú para modificar ingredientes
                            System.out.println("1: Regresar al menú principal\n"
                                    + "2: Agregar ingredientes\n"
                                    + "3: Quitar ingredientes\n");
                            System.out.println("Seleccione una opcion: \n");
                            int opcionIngredientes = scUserInput.nextInt();
                            if (opcionIngredientes == 2) {
                                // agregar ingredientes
                                System.out.println("Ingredientes disponibles:");
                                for (Ingrediente ingrediente : ingredientes) {
                                    System.out.println(ingrediente.getId() + ": " + ingrediente.getNombre());
                                }
                                System.out.println("Ingrese el ID del ingrediente que desea agregar:");
                                int idIngrediente = Integer.parseInt(scUserInput.next());
                                for (Ingrediente ingrediente : ingredientes) {
                                    if (ingrediente.getId() == idIngrediente) {
                                        producto.agregarIngrediente(ingrediente);
                                        System.out.println("Ingrediente agregado al producto!");
                                        break;
                                    }
                                }
                            } else if (opcionIngredientes == 3) {
                                // quitar ingredientes
                                System.out.println("Ingredientes disponibles:");
                                for (Ingrediente ingrediente : ingredientes) {
                                    System.out.println(ingrediente.getId() + ": " + ingrediente.getNombre());
                                }
                                System.out.println("Ingrese el ID del ingrediente que desea quitar:");
                                int idIngrediente = Integer.parseInt(scUserInput.next());
                                for (Ingrediente ingrediente : ingredientes) {
                                    if (ingrediente.getId() == idIngrediente) {
                                        producto.quitarIngrediente(ingrediente);
                                        System.out.println("Ingrediente quitado del producto!");
                                        break;
                                    }
                                }
                            }
                            break;
                        }
                    }
                }
            }
            else if (opcion == 2) {
                // generar factura
                Factura factura = new Factura(canasta);
                factura.imprimirFactura();
            }
        }
    }
}

                