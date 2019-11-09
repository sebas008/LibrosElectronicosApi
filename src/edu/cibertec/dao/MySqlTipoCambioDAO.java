package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.MntTipoCambio;
import edu.cibertec.beans.TblTipoPro;
import edu.cibertec.interfaces.InterfaceMntTipoCambio;
import edu.cibertec.utils.MySQLConexion;

public class MySqlTipoCambioDAO implements InterfaceMntTipoCambio {

	@Override
	public ArrayList<MntTipoCambio> listado() {
		ArrayList<MntTipoCambio> lista = new ArrayList<MntTipoCambio>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tipoCambio;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				MntTipoCambio c = new MntTipoCambio();
				c.setFecha(rs.getString(1));
				c.setCompra(rs.getDouble(2));
				c.setVenta(rs.getDouble(3));

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
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return lista;
	}

	@Override
	public int registrar(MntTipoCambio c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tipoCambio values (?,?,?);";
			pst = con.prepareStatement(sql);

			pst.setString(1, c.getFecha());
			pst.setDouble(2, c.getCompra());
			pst.setDouble(3, c.getVenta());

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
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int actualizar(MntTipoCambio e) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_tipoCambio(?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, e.getFecha());
			pst.setDouble(2, e.getCompra());
			pst.setDouble(3, e.getVenta());

			rs = pst.executeUpdate();

		} catch (Exception e1) {
			System.out.println("Se suscito la siguiente Excepcion: " + e1.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int eliminar(MntTipoCambio e) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_tipoCambio(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, e.getFecha());

			rs = pst.executeUpdate();

		} catch (Exception e1) {
			System.out.println("Se suscito la siguiente Excepcion: " + e1.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
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
			String sql = "{call usp_eliminar_tipoCambio(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);

			rs = pst.executeUpdate();

		} catch (Exception e1) {
			System.out.println("Se suscito la siguiente Excepcion: " + e1.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public MntTipoCambio obtener(String codigo) {
		MntTipoCambio x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_tipoCambio (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new MntTipoCambio();
				x.setFecha(rs.getString(1));
				x.setCompra(rs.getDouble(2));
				x.setVenta(rs.getDouble(3));

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
