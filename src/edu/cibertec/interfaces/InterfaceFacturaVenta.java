package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.ClFacturaVenta;

public interface InterfaceFacturaVenta {
	// Registrar Factura
	public int registrar(ClFacturaVenta u);
	
	public int actualizar(ClFacturaVenta u);
	
	public int eliminar(ClFacturaVenta u);
	
	public int eliminar(String codigo, String serie, String numero);
	
	//Listar Facturas de Venta (Sólo lo campos importantes)
	public ArrayList<ClFacturaVenta> listado();
	
	//ConsultarFactura
	public ClFacturaVenta consulta(String cliente, String num, String serie);
	
	//Listato de Facturas de ventas, con filtros
	public ArrayList<ClFacturaVenta> reporteVentas(String periodo, String cliente, String tipoD, String moneda);
	
	public ClFacturaVenta obtener(String cliente, String serie, String numero);
}
