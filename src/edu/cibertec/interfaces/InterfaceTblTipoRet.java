package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.TblTipoRet;

public interface InterfaceTblTipoRet {

	ArrayList<TblTipoRet> listado();

	public int registrar(TblTipoRet r);

	public TblTipoRet consultar(String r);
	
	public TblTipoRet obtener(String codigo);

	public int actualizar(TblTipoRet r);

	public int eliminar(TblTipoRet r);
	
	public int eliminar(String codigo);
}
