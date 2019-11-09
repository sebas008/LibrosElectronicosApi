package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.TblTipoCli;

public interface InterfaceTblTipoCli {

	ArrayList<TblTipoCli> listado();

	public int registrar(TblTipoCli c);

	public TblTipoCli buscarCodigo(String descripcion);
	
	public TblTipoCli buscarDes(String codigo);
	
	public int actualizar(TblTipoCli c);
	
	public int eliminar(TblTipoCli c);
	
	public int eliminar(String codigo);
	
	
}
