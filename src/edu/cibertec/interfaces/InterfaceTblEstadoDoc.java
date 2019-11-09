package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.TblEstadoDoc;

public interface InterfaceTblEstadoDoc {

	ArrayList<TblEstadoDoc> listado();

	int registrar(TblEstadoDoc e);

	public TblEstadoDoc consultar(int e);
	
	public TblEstadoDoc obtener(int codigo);
	
	int actualizar(TblEstadoDoc e);
	
	int eliminar(TblEstadoDoc e);
	
	int eliminar(int codigo);
}
