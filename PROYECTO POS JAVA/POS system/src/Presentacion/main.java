package Presentacion;

import java.util.Arrays;
import java.util.Date;

import logica.Combo;
import logica.Factura;
import logica.Producto;
import logica.burger;

public class main {
    private burger burger;

    public main() {
        this.burger = new burger();
    }

    public static void main(String[] args) {

        // Crear algunos productos
        Producto producto1 = new Producto("Producto1", 100.0, Arrays.asList("Ingrediente1", "Ingrediente2"));
        Producto producto2 = new Producto("Producto2", 200.0, Arrays.asList("Ingrediente3", "Ingrediente4"));

        // Crear un combo con los productos
        // Combo combo = new Combo(Arrays.asList(producto1, producto2), 250.0);

        // Crear una factura con los productos y el combo
        Factura factura = new Factura(1, new Date(), 16, 350);
        // factura.setProductos(Arrays.asList(producto1, producto2));
        // factura.setCombos(Arrays.asList(combo));

        // Imprimir la información de los productos, el combo y la factura
        System.out.println("Productos:");
        for (Producto producto : factura.getProductos()) {
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Ingredientes: " + producto.getIngredientes());
            System.out.println();
        }

        System.out.println("Combos:");
        for (Combo comboFactura : factura.getCombos()) {
            System.out.println("Precio total: " + comboFactura.getPrecioTotal());
            System.out.println("Productos:");
            for (Producto producto : comboFactura.getProductos()) {
                System.out.println("Nombre: " + producto.getNombre());
                System.out.println("Precio: " + producto.getPrecio());
                System.out.println("Ingredientes: " + producto.getIngredientes());
                System.out.println();
            }
        }

        System.out.println("Factura:");
        System.out.println("Número: " + factura.getNumero());
        System.out.println("Fecha: " + factura.getFecha());
        System.out.println("IVA: " + factura.getIva());
        System.out.println("Valor total: " + factura.getValorTotal());
    }
}