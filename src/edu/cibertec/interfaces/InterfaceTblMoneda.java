package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.TblMoneda;

public interface InterfaceTblMoneda {
	
	ArrayList<TblMoneda> listado();
	
	public int registrar(TblMoneda m);
	
	public int actualizar(TblMoneda m);
	
	public int eliminar(TblMoneda m);
	
	public int eliminar(String codigo);
	
	public TblMoneda buscarDes(String codigo);
	
	public TblMoneda obtener(String codigo);
	
	
}
