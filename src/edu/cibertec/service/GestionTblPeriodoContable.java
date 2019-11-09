package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.TblPeriodoContable;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceTblPeriodoCon;

public class GestionTblPeriodoContable  implements InterfaceTblPeriodoCon{

	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	InterfaceTblPeriodoCon dao = fabrica.getInterfaceTblPeriodoConDAO();
	
	@Override
	public ArrayList<TblPeriodoContable> lista() {
		// TODO Auto-generated method stub
		return dao.lista();
	}

	@Override
	public int registrar(TblPeriodoContable p) {
		// TODO Auto-generated method stub
		return dao.registrar(p);
	}

	@Override
	public TblPeriodoContable consultaPeriodo(String p) {
		// TODO Auto-generated method stub
		return dao.consultaPeriodo(p);
	}

	@Override
	public int actualizar(TblPeriodoContable p) {
		// TODO Auto-generated method stub
		return dao.actualizar(p);
	}

	@Override
	public int eliminar(TblPeriodoContable p) {
		// TODO Auto-generated method stub
		return dao.eliminar(p);
	}

	@Override
	public int eliminar(String codigo) {
		// TODO Auto-generated method stub
		return dao.eliminar(codigo);
	}
	
}
	
	

