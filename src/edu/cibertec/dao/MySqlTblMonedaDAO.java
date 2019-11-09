package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.cibertec.beans.TblMoneda;
import edu.cibertec.interfaces.InterfaceTblMoneda;
import edu.cibertec.utils.MySQLConexion;

public class MySqlTblMonedaDAO implements InterfaceTblMoneda {

	@Override
	public ArrayList<TblMoneda> listado() {
		ArrayList<TblMoneda> lista = new ArrayList<TblMoneda>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from moneda;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TblMoneda d = new TblMoneda();
				d.setCodigo(rs.getString(1));
				d.setDescripcion(rs.getString(2));

				lista.add(d);
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
				System.out.println("Error al Cerrar: " + e2.getMessage());
			}
		}

		return lista;
	}

	@Override
	public int registrar(TblMoneda m) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into moneda values (?,?);";
			pst = con.prepareStatement(sql);

			pst.setString(1, m.getCodigo());
			pst.setString(2, m.getDescripcion());

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
				System.out.println("Error al Cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int actualizar(TblMoneda m) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_moneda(?, ?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, m.getCodigo());
			pst.setString(2, m.getDescripcion());

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
				System.out.println("Error al Cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int eliminar(TblMoneda m) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_moneda(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, m.getCodigo());

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
				System.out.println("Error al Cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public TblMoneda buscarDes(String codigo) {
		TblMoneda x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscaDes_moneda (?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblMoneda();
				x.setCodigo(rs.getString(1));

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
				System.out.println("Error al Cerrar: " + e2.getMessage());
			}
		}

		return x;

	}

	@Override
	public int eliminar(String codigo) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_moneda(?)}";
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
				System.out.println("Error al Cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public TblMoneda obtener(String codigo) {
		TblMoneda x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_moneda (?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblMoneda();
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
			} catch (Exception e2) {
				System.out.println("Error al Cerrar: " + e2.getMessage());
			}
		}

		return x;

	}

}
