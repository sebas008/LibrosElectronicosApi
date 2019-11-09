package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.TblTipoPro;

public interface InterfaceTblTipoPro {

	ArrayList<TblTipoPro> listado();

	public int registrar(TblTipoPro p);

	public TblTipoPro buscarCodigo(String descripcion);

	public TblTipoPro buscarDes(String codigo);
	
	public TblTipoPro obtener(String codigo);

	public int actualizar(TblTipoPro p);

	public int eliminar(TblTipoPro p);
	
	public int eliminar(String codigo);

}
