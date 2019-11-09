package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.MntCliente;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceMntCliente;

public class GestionMntCliente implements InterfaceMntCliente{

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	InterfaceMntCliente dao = fabrica.getInterfaceMntClienteDAO();
	
	@Override
	public ArrayList<MntCliente> listado() {
		// TODO Auto-generated method stub
		return dao.listado();
	}

	@Override
	public int Registrar(MntCliente e) {
		// TODO Auto-generated method stub
		return dao.Registrar(e);
	}

	@Override
	public int actualizar(MntCliente c) {
		// TODO Auto-generated method stub
		return dao.actualizar(c);
	}

	@Override
	public int eliminar(MntCliente c) {
		// TODO Auto-generated method stub
		return dao.eliminar(c);
	}

	@Override
	public MntCliente buscarCliente(String c) {
		// TODO Auto-generated method stub
		return dao.buscarCliente(c);
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}

	@Override
	public MntCliente obtener(String codigo) {
		// TODO Auto-generated method stub
		return dao.obtener(codigo);
	}

}
