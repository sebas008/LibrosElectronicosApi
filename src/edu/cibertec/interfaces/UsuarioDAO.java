package edu.cibertec.interfaces;

import edu.cibertec.beans.UsuarioDTO;

public interface UsuarioDAO {
	
	public UsuarioDTO validarLogueo(String cod_usu, String clave_usu);
	
	public int registrar(UsuarioDTO u);
}
