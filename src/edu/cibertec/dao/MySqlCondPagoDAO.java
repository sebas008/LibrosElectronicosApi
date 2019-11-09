package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.TblCondPago;
import edu.cibertec.interfaces.InterfaceCondPago;
import edu.cibertec.utils.MySQLConexion;

public class MySqlCondPagoDAO implements InterfaceCondPago {

	@Override
	public ArrayList<TblCondPago> listado() {
		ArrayList<TblCondPago> lista = new ArrayList<TblCondPago>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from condicionPago;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TblCondPago c = new TblCondPago();
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
			} catch (Exception e2) {
				System.out.println("error al cerrar: " + e2.getMessage());
			}
		}

		return lista;
	}

	@Override
	public int registrar(TblCondPago c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into condicionPago values (?,?);";
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
			} catch (Exception e2) {
				System.out.println("error al cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public TblCondPago buscarCodigo(String descripcion) {
		TblCondPago x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_busca_tipo_condPago (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, descripcion);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblCondPago();
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
				System.out.println("error al cerrar: " + e.getMessage());
			}
		}
		return x;
	}

	@Override
	public TblCondPago buscarDes(String codigo) {
		TblCondPago x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscaDes_tipo_condPago (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblCondPago();
				x.setDescripcion(rs.getString(1));

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
				System.out.println("error al cerrar: " + e.getMessage());
			}
		}
		return x;
	}

	@Override
	public int actualizar(TblCondPago c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_condPago(?, ?)}";
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
			} catch (Exception e2) {
				System.out.println("error al cerrar: " + e2.getMessage());
			}
		}
		return rs;
	}

	@Override
	public int eliminar(TblCondPago c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_condPago(?)}";
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
			} catch (Exception e2) {
				System.out.println("error al cerrar: " + e2.getMessage());
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
			String sql = "{call usp_eliminar_condPago(?)}";
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
			} catch (Exception e2) {
				System.out.println("error al cerrar: " + e2.getMessage());
			}
		}
		return rs;
	}

	@Override
	public TblCondPago obtener(String codigo) {
		TblCondPago x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_condPago (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblCondPago();
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
				System.out.println("error al cerrar: " + e.getMessage());
			}
		}
		return x;
	}

}
