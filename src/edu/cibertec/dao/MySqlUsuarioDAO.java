package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.cibertec.beans.UsuarioDTO;
import edu.cibertec.interfaces.UsuarioDAO;
import edu.cibertec.utils.MySQLConexion;

public class MySqlUsuarioDAO implements UsuarioDAO {

	@Override
	public UsuarioDTO validarLogueo(String cod_usu, String clave_usu) {
		   UsuarioDTO objUsuario=null;//valor por defecto del objeto UsuarioDTO
		
		Connection cnx=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			cnx=MySQLConexion.getConexion();// obtiene la conexión de tipo MySql
			String sql="Select * from usuarios where cod_usu=? and clave_usu=?";//Sentencia con dos parametros
			pstmt=cnx.prepareStatement(sql);//creacion de la setencia
			//asignación de los parametros
			pstmt.setString(1, cod_usu);//primer signo de interrogacion del String  sql
			pstmt.setString(2, clave_usu);// segundo signo de interrogacion del String  sql
			rs=pstmt.executeQuery();//ejecución de la sentencia
			if(rs.next()){
				objUsuario=new UsuarioDTO();
				objUsuario.setCod_usu(rs.getString("cod_usu"));// se obtiene el campo nombre de la tabla tb_usuarios de la BD
				objUsuario.setClave_usu(rs.getString("clave_usu"));// se obtiene el campo apellido de la tabla tb_usuarios de la BD
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		}
		MySQLConexion.closeConexion(cnx);
		MySQLConexion.closeStatement(pstmt);
		return objUsuario;
	}
}
