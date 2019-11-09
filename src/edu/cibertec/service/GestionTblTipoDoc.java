package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.TblTipoDoc;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceTblTipoDoc;

public class GestionTblTipoDoc implements InterfaceTblTipoDoc{

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	InterfaceTblTipoDoc dao = fabrica.getIntefaceTblTipoDocDAO();
	
	@Override
	public ArrayList<TblTipoDoc> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public int registrar(TblTipoDoc d) {
		// TODO Auto-generated method stub
		return dao.registrar(d);
	}

	@Override
	public TblTipoDoc buscarCodigo(String descripcion) {
		// TODO Auto-generated method stub
		return dao.buscarCodigo(descripcion);
	}

	@Override
	public TblTipoDoc buscarDes(String codigo) {
		// TODO Auto-generated method stub
		return dao.buscarDes(codigo);
	}

	@Override
	public int actualizar(TblTipoDoc d) {
		// TODO Auto-generated method stub
		return dao.actualizar(d);
	}

	@Override
	public int eliminar(TblTipoDoc d) {
		// TODO Auto-generated method stub
		return dao.eliminar(d);
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}

	@Override
	public TblTipoDoc obtener(String codigo) {
		// TODO Auto-generated method stub
		return dao.obtener(codigo);
	}

}
