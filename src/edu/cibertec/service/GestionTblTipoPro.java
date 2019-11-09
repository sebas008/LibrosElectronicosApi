package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.TblTipoPro;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceTblTipoPro;

public class GestionTblTipoPro implements InterfaceTblTipoPro{

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	InterfaceTblTipoPro dao = fabrica.getInterfaceTblTipoProDAO();
	
	@Override
	public ArrayList<TblTipoPro> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public int registrar(TblTipoPro p) {
		// TODO Auto-generated method stub
		return dao.registrar(p);
	}

	@Override
	public TblTipoPro buscarCodigo(String descripcion) {
		// TODO Auto-generated method stub
		return dao.buscarCodigo(descripcion);
	}

	@Override
	public TblTipoPro buscarDes(String codigo) {
		// TODO Auto-generated method stub
		return dao.buscarDes(codigo);
	}

	@Override
	public int actualizar(TblTipoPro p) {
		// TODO Auto-generated method stub
		return dao.actualizar(p);
	}

	@Override
	public int eliminar(TblTipoPro p) {
		// TODO Auto-generated method stub
		return dao.eliminar(p);
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}

	@Override
	public TblTipoPro obtener(String codigo) {
		// TODO Auto-generated method stub
		return dao.obtener(codigo);
	}

}
