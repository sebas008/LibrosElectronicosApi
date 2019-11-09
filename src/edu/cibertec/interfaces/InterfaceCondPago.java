package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.TblCondPago;

public interface InterfaceCondPago {

	ArrayList<TblCondPago> listado();
	
	public int registrar(TblCondPago c);
	
	public TblCondPago buscarCodigo(String descripcion);
	
	public TblCondPago buscarDes(String codigo);
	
	public TblCondPago obtener(String codigo);
	
	public int actualizar (TblCondPago c);
	
	public int eliminar (TblCondPago c);
	
	public int eliminar (String codigo);
}
