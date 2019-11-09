package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.ClFacturaVenta;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceFacturaVenta;

public class GestionFacturaVentas implements InterfaceFacturaVenta{

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	InterfaceFacturaVenta dao = fabrica.getInterfaceFacturaVentaDAO();
	
	@Override
	public int registrar(ClFacturaVenta u) {
		// TODO Auto-generated method stub
		return dao.registrar(u);
	}

	@Override
	public int actualizar(ClFacturaVenta u) {
		// TODO Auto-generated method stub
		return dao.actualizar(u);
	}

	@Override
	public int eliminar(ClFacturaVenta u) {
		// TODO Auto-generated method stub
		return dao.eliminar(u);
	}

	@Override
	public ArrayList<ClFacturaVenta> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public ClFacturaVenta consulta(String cliente, String num, String serie) {
		// TODO Auto-generated method stub
		return dao.consulta(cliente, num, serie);
	}

	@Override
	public ArrayList<ClFacturaVenta> reporteVentas(String periodo, String cliente, String tipoD, String moneda) {
		// TODO Auto-generated method stub
		return dao.reporteVentas(periodo, cliente, tipoD, moneda);
	}

	@Override
	public int eliminar(String codigo, String serie, String numero) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo, serie, numero);
	}

	@Override
	public ClFacturaVenta obtener(String cliente, String serie, String numero) {
		// TODO Auto-generated method stub
		return dao.obtener(cliente, serie, numero);
	}

}
