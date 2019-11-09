package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.TblTipoPer;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceTblTipoPer;

public class GestionTblTipoPer implements InterfaceTblTipoPer {

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	InterfaceTblTipoPer dao = fabrica.getInterfaceTblTipoPerDAO();
	
	
	@Override
	public ArrayList<TblTipoPer> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public int registrar(TblTipoPer p) {
		// TODO Auto-generated method stub
		return dao.registrar(p);
	}

	@Override
	public TblTipoPer buscarCodigo(String descripcion) {
		// TODO Auto-generated method stub
		return dao.buscarCodigo(descripcion);
	}

	@Override
	public TblTipoPer buscarDescrip(String codigo) {
		// TODO Auto-generated method stub
		return dao.buscarDescrip(codigo);
	}

	@Override
	public int actualizar(TblTipoPer p) {
		// TODO Auto-generated method stub
		return dao.actualizar(p);
	}

	@Override
	public int eliminar(TblTipoPer p) {
		// TODO Auto-generated method stub
		return dao.eliminar(p);
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}

	@Override
	public TblTipoPer obtener(String codigo) {
		// TODO Auto-generated method stub
		return dao.obtener(codigo);
	}

}
