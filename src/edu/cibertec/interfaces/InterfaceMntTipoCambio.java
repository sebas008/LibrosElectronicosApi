package edu.cibertec.interfaces;

import java.util.ArrayList;

import edu.cibertec.beans.MntTipoCambio;


public interface InterfaceMntTipoCambio {
 
	ArrayList<MntTipoCambio> listado();
	
	int registrar (MntTipoCambio e);
	
	int actualizar(MntTipoCambio e);
	
	int eliminar(MntTipoCambio e);
	
	int eliminar(String codigo);
	
	public MntTipoCambio obtener(String codigo);
}
