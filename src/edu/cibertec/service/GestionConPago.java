package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.TblCondPago;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceCondPago;

public class GestionConPago implements InterfaceCondPago {
	
	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	InterfaceCondPago dao = fabrica.getInterfaceCondPagoDAO();

	@Override
	public ArrayList<TblCondPago> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public int registrar(TblCondPago c) {
		// TODO Auto-generated method stub
		return dao.registrar(c);
	}

	@Override
	public TblCondPago buscarCodigo(String descripcion) {
		// TODO Auto-generated method stub
		return dao.buscarCodigo(descripcion);
	}

	@Override
	public TblCondPago buscarDes(String codigo) {
		// TODO Auto-generated method stub
		return dao.buscarDes(codigo);
	}

	@Override
	public int actualizar(TblCondPago c) {
		// TODO Auto-generated method stub
		return dao.actualizar(c);
	}

	@Override
	public int eliminar(TblCondPago c) {
		// TODO Auto-generated method stub
		return dao.eliminar(c);
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}

	@Override
	public TblCondPago obtener(String codigo) {
		// TODO Auto-generated method stub
		return dao.obtener(codigo);
	}

}
