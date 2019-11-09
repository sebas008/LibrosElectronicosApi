package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.TblTipoCom;

public interface InterfaceTblTipoCom {

	ArrayList<TblTipoCom> listado();
	
	public int registrar (TblTipoCom c);
	
	public int actualizar (TblTipoCom c);
	
	public int eliminar (TblTipoCom c);
	
	public int eliminar (String codigo);
	
	public TblTipoCom obtener(String codigo);
}
