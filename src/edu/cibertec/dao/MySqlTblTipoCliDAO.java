package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.TblTipoCli;
import edu.cibertec.interfaces.InterfaceTblTipoCli;
import edu.cibertec.utils.MySQLConexion;

public class MySqlTblTipoCliDAO implements InterfaceTblTipoCli {

	@Override
	public ArrayList<TblTipoCli> listado() {
		ArrayList<TblTipoCli> lista = new ArrayList<TblTipoCli>();
		ResultSet rs = null;
		PreparedStatement pst = null;
		Connection con = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select  * from tipoCliente;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TblTipoCli c = new TblTipoCli();
				c.setCodigo(rs.getString(1));
				c.setDescripcion(rs.getString(2));

				lista.add(c);
			}

		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}

		}

		return lista;
	}

	@Override
	public int registrar(TblTipoCli c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tipoCliente values (?,?);";
			pst = con.prepareStatement(sql);

			pst.setString(1, c.getCodigo());
			pst.setString(2, c.getDescripcion());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public TblTipoCli buscarCodigo(String descripcion) {
		TblTipoCli x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_busca_tipo_cliente (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, descripcion);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoCli();
				x.setCodigo(rs.getString(1));
				// x.setDescripcion(rs.getString(2));

			}
		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return x;
	}

	@Override
	public TblTipoCli buscarDes(String codigo) {
		TblTipoCli x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscaDes_tipo_cliente (?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);
			
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoCli();
				x.setCodigo(rs.getString(1));
				x.setDescripcion(rs.getString(2));

			}
		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return x;
	}

	@Override
	public int actualizar(TblTipoCli c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_tipoCli(?, ?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, c.getCodigo());
			pst.setString(2, c.getDescripcion());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public int eliminar(TblTipoCli c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_tipoCli(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, c.getCodigo());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return rs;
	}

	@Override
	public int eliminar(String codigo) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_tipoCli(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);
			
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return rs;
	}

}
