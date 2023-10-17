package Logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Factura {
    private LocalDate fecha;
    private List<Producto> productos;

    public Factura(List<Producto> productos) {
        this.fecha = LocalDate.now();
        this.productos = productos;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }

    public List<Producto> getProductos() {
        return this.productos;
    }

    public double getTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public void imprimirFactura() {
        System.out.println("========================");
        System.out.println("Factura");
        System.out.println("Fecha: " + this.fecha);
        System.out.println("========================");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + ": " + producto.getPrecio());
            for (Ingrediente ingrediente : producto.getIngredientes()) {
                System.out.println("- " + ingrediente.getNombre() + ": " + ingrediente.getCostoAdicional());
            }
        }
        System.out.println("========================");
        System.out.println("Total: " + this.getTotal());
        System.out.println("========================");
    }
}


