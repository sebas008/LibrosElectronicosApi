package edu.cibertec.service;

import edu.cibertec.beans.UsuarioDTO;
import edu.cibertec.dao.DAOFactory;
import edu.cibertec.interfaces.UsuarioDAO;

public class GestionUsuario {

	DAOFactory fabrica=DAOFactory.getDAOFactory(1);
	UsuarioDAO objUsuarioDAO=fabrica.getUsuarioDAO();
	
	public UsuarioDTO validarLogueo(String cod_usu, String clave_usu){
		return objUsuarioDAO.validarLogueo(cod_usu, clave_usu);
	}
}
