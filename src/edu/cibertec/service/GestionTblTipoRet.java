package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.TblTipoRet;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceTblTipoRet;

public class GestionTblTipoRet implements InterfaceTblTipoRet{

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	InterfaceTblTipoRet dao = fabrica.getInterfaceTblTipoRetDAO();
	
	@Override
	public ArrayList<TblTipoRet> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public int registrar(TblTipoRet r) {
		// TODO Auto-generated method stub
		return dao.registrar(r);
	}

	@Override
	public TblTipoRet consultar(String r) {
		// TODO Auto-generated method stub
		return dao.consultar(r);
	}

	@Override
	public int actualizar(TblTipoRet r) {
		// TODO Auto-generated method stub
		return dao.actualizar(r);
	}

	@Override
	public int eliminar(TblTipoRet r) {
		// TODO Auto-generated method stub
		return dao.eliminar(r);
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}

	@Override
	public TblTipoRet obtener(String codigo) {
		// TODO Auto-generated method stub
		return dao.obtener(codigo);
	}

}
