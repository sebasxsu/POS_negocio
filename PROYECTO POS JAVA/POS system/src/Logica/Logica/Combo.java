package Logica;

import java.util.List;

public class Combo extends Producto {
    private List<Producto> productos;

    public Combo(int id, String nombre, double precio, List<Producto> productos) {
        super(id, nombre, precio);
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Combo: ").append(getNombre()).append("\n");
        sb.append("Productos incluidos:\n");
        for (Producto producto : productos) {
            sb.append("- ").append(producto.getNombre()).append("\n");
        }
        sb.append("Precio: ").append(getPrecio()).append("\n");
        return sb.toString();
    }
}