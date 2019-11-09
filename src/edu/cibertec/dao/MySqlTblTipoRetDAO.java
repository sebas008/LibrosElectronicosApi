package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.TblTipoRet;
import edu.cibertec.interfaces.InterfaceTblTipoRet;
import edu.cibertec.utils.MySQLConexion;

public class MySqlTblTipoRetDAO implements InterfaceTblTipoRet {

	@Override
	public ArrayList<TblTipoRet> listado() {
		ArrayList<TblTipoRet> lista = new ArrayList<TblTipoRet>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tipoRetencion;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TblTipoRet r = new TblTipoRet();
				r.setCodigo(rs.getString(1));
				r.setDescripcion(rs.getString(2));
				r.setTasa(rs.getInt(3));
				r.setValor(rs.getDouble(4));

				lista.add(r);
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
	public int registrar(TblTipoRet r) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tipoRetencion values(?,?,?,?);";
			pst = con.prepareStatement(sql);

			pst.setString(1, r.getCodigo());
			pst.setString(2, r.getDescripcion());
			pst.setInt(3, r.getTasa());
			pst.setDouble(4, r.getValor());

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
	public TblTipoRet consultar(String r) {
		TblTipoRet x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscar_retencion(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, r);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoRet();
				x.setDescripcion(rs.getString(1));
				x.setTasa(rs.getInt(2));

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
	public int actualizar(TblTipoRet r) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_tipoRet(?,?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, r.getCodigo());
			pst.setString(2, r.getDescripcion());
			pst.setInt(3, r.getTasa());
			pst.setDouble(4, r.getValor());

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
	public int eliminar(TblTipoRet r) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_tipoRet(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, r.getCodigo());

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
			String sql = "{call usp_eliminar_tipoRet(?)}";
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
	public TblTipoRet obtener(String codigo) {
		TblTipoRet x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_retencion(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoRet();
				x.setCodigo(rs.getString(1));
				x.setDescripcion(rs.getString(2));
				x.setTasa(rs.getInt(3));
				x.setValor(rs.getDouble(4));

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
