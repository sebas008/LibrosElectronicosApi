package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.TblTipoDoc;

public interface InterfaceTblTipoDoc {
	
	ArrayList<TblTipoDoc> listado();
	
	public int registrar(TblTipoDoc d);
	
	public TblTipoDoc buscarCodigo(String descripcion);
	
	public TblTipoDoc buscarDes(String codigo);
	
	public TblTipoDoc obtener(String codigo);
	
	public int actualizar(TblTipoDoc d);
	
	public int eliminar(TblTipoDoc d);
	
	public int eliminar(String codigo);

}
