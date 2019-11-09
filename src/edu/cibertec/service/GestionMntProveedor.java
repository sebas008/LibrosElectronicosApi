package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.MntProveedor;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceMntProveedor;

public class GestionMntProveedor implements InterfaceMntProveedor{

	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	InterfaceMntProveedor dao = fabrica.getInterfaceMntProveedorDAO();
	
	@Override
	public ArrayList<MntProveedor> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public ArrayList<MntProveedor> listado2(String descripcion) {
		// TODO Auto-generated method stub
		return dao.listado2(descripcion);
	}

	@Override
	public int Registrar(MntProveedor e) {
		// TODO Auto-generated method stub
		return dao.Registrar(e);
	}

	@Override
	public MntProveedor buscar(String descripcion) {
		// TODO Auto-generated method stub
		return dao.buscar(descripcion);
	}

	@Override
	public MntProveedor buscarDes(String codigo) {
		// TODO Auto-generated method stub
		return dao.buscarDes(codigo);
	}

	@Override
	public int actualizar(MntProveedor p) {
		// TODO Auto-generated method stub
		return dao.actualizar(p);
	}

	@Override
	public int eliminar(MntProveedor p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}

	@Override
	public MntProveedor obtener(String codigo) {
		// TODO Auto-generated method stub
		return dao.obtener(codigo);
	}

}
