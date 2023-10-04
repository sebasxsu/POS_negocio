package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Factura {

    private int numero;
    private Date fecha;
    private int iva;
    private int valorTotal;

    private List<Producto> productos;
    private List<Combo> combos;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getIva() {
        return iva;
    }

    public void setIva(int iva) {
        this.iva = iva;
    }

    public int getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(int valorTotal) {
        this.valorTotal = valorTotal;
    }

    public ArrayList<Producto> getProductos() {
        return new ArrayList<>(productos);
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = new ArrayList<>(productos);
    }

    public ArrayList<Combo> getCombos() {
        return new ArrayList<>(combos);
    }

    public void setCombos(ArrayList<Combo> combos) {
        this.combos = new ArrayList<>(combos);
    }

    public Factura(int numero, Date fecha, int iva, int valorTotal) {
        super();
        this.numero = numero;
        this.fecha = fecha;
        this.iva = iva;
        this.valorTotal = valorTotal;
        this.productos = new ArrayList<Producto>();
        this.combos = new ArrayList<Combo>();
    }
}