package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.TblMoneda;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceTblMoneda;

public class GestionTblMoneda implements InterfaceTblMoneda {

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	InterfaceTblMoneda dao = fabrica.getInterfaceTblMonedaDAO();

	@Override
	public ArrayList<TblMoneda> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public int registrar(TblMoneda m) {
		// TODO Auto-generated method stub
		return dao.registrar(m);
	}

	@Override
	public int actualizar(TblMoneda m) {
		// TODO Auto-generated method stub
		return dao.actualizar(m);
	}

	@Override
	public int eliminar(TblMoneda m) {
		// TODO Auto-generated method stub
		return dao.eliminar(m);
	}

	@Override
	public TblMoneda buscarDes(String codigo) {
		// TODO Auto-generated method stub
		return dao.buscarDes(codigo);
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}

	@Override
	public TblMoneda obtener(String codigo) {
		// TODO Auto-generated method stub
		return dao.obtener(codigo);
	}

}
