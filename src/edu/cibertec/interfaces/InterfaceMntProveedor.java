package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.MntProveedor;

public interface InterfaceMntProveedor {

	ArrayList<MntProveedor> listado();

	ArrayList<MntProveedor> listado2(String descripcion);

	int Registrar(MntProveedor e);

	public MntProveedor buscar(String descripcion);
	
	public MntProveedor buscarDes(String codigo);

	public MntProveedor obtener(String codigo);
	
	public int actualizar(MntProveedor p);

	public int eliminar(MntProveedor p);
	
	public int eliminar(String codigo);

}
