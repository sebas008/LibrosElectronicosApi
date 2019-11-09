package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.ClFacturaCompra;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceFacturaCompra;

public class GestionFacturaCompra implements InterfaceFacturaCompra {

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	InterfaceFacturaCompra dao = fabrica.getInterfaceFacturaCompraDAO();
	
	@Override
	public int registrar(ClFacturaCompra u) {
		// TODO Auto-generated method stub
		return dao.registrar(u);
	}

	@Override
	public int actualizar(ClFacturaCompra u) {
		// TODO Auto-generated method stub
		return dao.actualizar(u);
	}

	@Override
	public int eliminar(ClFacturaCompra u) {
		// TODO Auto-generated method stub
		return dao.eliminar(u);
	}

	@Override
	public ArrayList<ClFacturaCompra> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public ClFacturaCompra consulta(String cliente, String num, String serie) {
		// TODO Auto-generated method stub
		return dao.consulta(cliente, num, serie);
	}

	@Override
	public ArrayList<ClFacturaCompra> reporteCompras(String periodo, String codpro, String tipodoc, String moneda) {
		// TODO Auto-generated method stub
		return dao.reporteCompras(periodo, codpro, tipodoc, moneda);
	}

	@Override
	public int eliminar(String codigo, String serie, String numero) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo, serie, numero);
	}

	@Override
	public ClFacturaCompra obtener(String cliente, String num, String serie) {
		// TODO Auto-generated method stub
		return dao.obtener(cliente, num, serie);
	}

}
