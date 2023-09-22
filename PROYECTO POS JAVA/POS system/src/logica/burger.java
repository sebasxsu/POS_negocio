package logica;

import java.util.ArrayList;

public class burger {

    private ArrayList<Producto> Productos;
    // private ArrayList<Cajero> cajeros;
    private ArrayList<Factura> facturas;
    // private ArrayList<Cliente> clientes;

    public burger() {
        this.Producto = new ArrayList<Producto>();
        // this.cajeros = new ArrayList<Cajero>();
        this.Facturas = new ArrayList<Factura>();
        // this.clientes = new ArrayList<Cliente>();

    }

    public void ingresarTipoProducto(int id, String nombre) {
        TipoProducto nuevoTipoProducto = new TipoProducto(id, nombre);
        this.tipoProductos.add(nuevoTipoProducto);

    }
}