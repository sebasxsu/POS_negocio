package logica;

import java.util.ArrayList;
import java.util.Date;

import Presentacion.archivo;

public class burger {

	private ArrayList<Producto> Productos;
	private ArrayList<Factura> facturas;

	public burger() {
		this.Producto = new ArrayList<Producto>();
		this.facturas = new ArrayList<Factura>();

	}

	public void ingresarTipoProducto(int id, String nombre) {
		Producto tipoProducto = new Producto(id, nombre);
		this.Producto.add(tipoProducto);
	}

	public void ingresarProducto(int idTipoProducto, int codigo, String nombre, int precioCompra, int precioVenta,
			int cantidad) {
		Producto tipoProducto = this.buscarTipoProducto(idTipoProducto);
		if (tipoProducto != null) {
			tipoProducto.ingresarProducto(codigo, nombre, precioCompra, precioVenta, cantidad);
		}

	}

	private Producto buscarTipoProducto(int idProducto) {
		for (Producto tipoProducto : this.Productos) {
			if (tipoProducto.getId() == idProducto) {
				return tipoProducto;
			}
		}
		return null;
	}

	public void imprimirProductos() {
		for (TipoProducto tipoProducto : this.tipoProductos) {
			for (Producto producto : tipoProducto.getProductos()) {
				System.out.println("Tipo: " + tipoProducto.getNombre());
				System.out.println("Codigo Producto: " + producto.getCodigo());
				System.out.println("Nombre: " + producto.getNombre());
				System.out.println("Precio Compra: " + producto.getPrecioCompra());
				System.out.println("Precio Venta: " + producto.getPrecioVenta());
				System.out.println("Cantidad: " + producto.getCantidad());
				System.out.println("-----------");
			}
		}

	}

	public void leerArchivos() {
		ArrayList<String> lineas;
		lineas = archivo.leerArchivo("tipoProducto.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarTipoProducto(Integer.parseInt(datos[0]), datos[1]);
		}
		lineas = archivo.leerArchivo("producto.dat");
		for(String linea : lineas) {
			String datos[] = linea.split(";");
			this.ingresarProducto(Integer.parseInt(datos[0]), Integer.parseInt(datos[1]), datos[2], Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), Integer.parseInt(datos[5]));
		}

public void ingresarFactura(int idCajero, int idCliente, Date fecha, ArrayList<int[]> productosComprados) {
