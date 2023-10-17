package Logica;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Ingrediente> ingredientes;
    private List<Producto> productos;

    public Carrito() {
        this.ingredientes = new ArrayList<>();
        this.productos = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void quitarIngrediente(Ingrediente ingrediente) {
        ingredientes.remove(ingrediente);
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    public void quitarProducto(Producto producto) {
        productos.remove(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }
    // Resto de métodos y propiedades de la clase
}
