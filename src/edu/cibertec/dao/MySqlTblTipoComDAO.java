package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.TblTipoCom;
import edu.cibertec.beans.TblTipoPro;
import edu.cibertec.interfaces.InterfaceTblTipoCom;
import edu.cibertec.utils.MySQLConexion;

public class MySqlTblTipoComDAO implements InterfaceTblTipoCom {

	@Override
	public ArrayList<TblTipoCom> listado() {
		ArrayList<TblTipoCom> lista = new ArrayList<TblTipoCom>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tipoCompra;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TblTipoCom c = new TblTipoCom();
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
	public int registrar(TblTipoCom c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tipoCompra values (?,?);";
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
	public int actualizar(TblTipoCom c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_tipoCom(?, ?)}";
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
	public int eliminar(TblTipoCom c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_tipoCom(?)}";
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
			String sql = "{call usp_eliminar_tipoCom(?)}";
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

	@Override
	public TblTipoCom obtener(String codigo) {
		TblTipoCom x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_tipoCom (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoCom();
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

}
