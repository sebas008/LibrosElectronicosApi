package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.MntCliente;

public interface InterfaceMntCliente {

	ArrayList<MntCliente> listado();
	
	public int Registrar (MntCliente e);
	
	public int actualizar (MntCliente c);
	
	public int eliminar (MntCliente c);
	
	public int eliminar (String codigo);
	
	public MntCliente buscarCliente(String c);
	
	public MntCliente obtener(String codigo);
}
