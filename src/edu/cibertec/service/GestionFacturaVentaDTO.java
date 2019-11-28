package edu.cibertec.service;

import java.util.ArrayList;

import edu.cibertec.beans.FacturaVentaDTO;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.InterfaceFacturaVentaDto;

public class GestionFacturaVentaDTO implements InterfaceFacturaVentaDto{

	DAOFactory fabrica = DAOFactory.getDAOFactory(1);
	InterfaceFacturaVentaDto dao = fabrica.getInterfaceFacturaVentaDtoDAO();
	
	
	@Override
	public ArrayList<FacturaVentaDTO> periodoxTotal(String periodo, String total) {
		// TODO Auto-generated method stub
		return dao.periodoxTotal(periodo, total);
	}

}
