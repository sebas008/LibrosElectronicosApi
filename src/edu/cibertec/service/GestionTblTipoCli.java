package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.TblTipoCli;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceTblTipoCli;

public class GestionTblTipoCli implements InterfaceTblTipoCli {

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	InterfaceTblTipoCli dao = fabrica.getInterfaceTblTipoCliDAO();
			
	
	@Override
	public ArrayList<TblTipoCli> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public int registrar(TblTipoCli c) {
		// TODO Auto-generated method stub
		return dao.registrar(c);
	}

	@Override
	public TblTipoCli buscarCodigo(String descripcion) {
		// TODO Auto-generated method stub
		return dao.buscarCodigo(descripcion);
	}

	@Override
	public TblTipoCli buscarDes(String codigo) {
		// TODO Auto-generated method stub
		return dao.buscarDes(codigo);
	}

	@Override
	public int actualizar(TblTipoCli c) {
		// TODO Auto-generated method stub
		return dao.actualizar(c);
	}

	@Override
	public int eliminar(TblTipoCli c) {
		// TODO Auto-generated method stub
		return dao.eliminar(c);
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}

}
