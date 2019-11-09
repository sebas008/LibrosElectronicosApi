package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.ClFacturaCompra;

public interface InterfaceFacturaCompra {
	
	public int registrar(ClFacturaCompra u);

	public int actualizar(ClFacturaCompra u);

	public int eliminar(ClFacturaCompra u);
	
	public int eliminar(String codigo, String serie, String numero);

	// Listar Facturas de Venta (Sólo lo campos importantes)
	public ArrayList<ClFacturaCompra> listado();

	// ConsultarFactura
	public ClFacturaCompra consulta(String cliente, String num, String serie);
	
	public ArrayList<ClFacturaCompra> reporteCompras(String periodo, String codpro, String tipodoc, String moneda);
	
	public ClFacturaCompra obtener(String cliente, String num, String serie);
	
}
