package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.TblTipoCom;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceTblTipoCom;

public class GestionTblTipoCom implements InterfaceTblTipoCom {

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	InterfaceTblTipoCom dao = fabrica.getInterfaceTblTipoComDAO();
	
	@Override
	public ArrayList<TblTipoCom> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public int registrar(TblTipoCom c) {
		// TODO Auto-generated method stub
		return dao.registrar(c);
	}

	@Override
	public int actualizar(TblTipoCom c) {
		// TODO Auto-generated method stub
		return dao.actualizar(c);
	}

	@Override
	public int eliminar(TblTipoCom c) {
		// TODO Auto-generated method stub
		return dao.eliminar(c);
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}

	@Override
	public TblTipoCom obtener(String codigo) {
		// TODO Auto-generated method stub
		return dao.obtener(codigo);
	}

}
