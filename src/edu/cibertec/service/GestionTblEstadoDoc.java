package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.TblEstadoDoc;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceTblEstadoDoc;

public class GestionTblEstadoDoc implements InterfaceTblEstadoDoc {

	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	InterfaceTblEstadoDoc dao = fabrica.getInterfaceTblEstadoDocDAO();
	
	@Override
	public ArrayList<TblEstadoDoc> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public int registrar(TblEstadoDoc e) {
		// TODO Auto-generated method stub
		return dao.registrar(e);
	}

	@Override
	public TblEstadoDoc consultar(int e) {
		// TODO Auto-generated method stub
		return dao.consultar(e);
	}

	@Override
	public int actualizar(TblEstadoDoc e) {
		// TODO Auto-generated method stub
		return dao.actualizar(e);
	}

	@Override
	public int eliminar(TblEstadoDoc e) {
		// TODO Auto-generated method stub
		return dao.eliminar(e);
	}

	@Override
	public int eliminar(int codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}

	@Override
	public TblEstadoDoc obtener(int codigo) {
		// TODO Auto-generated method stub
		return dao.obtener(codigo);
	}

}
