package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.TblTipoPer;
import edu.cibertec.interfaces.InterfaceTblTipoPer;
import edu.cibertec.utils.MySQLConexion;

public class MySqlTblTipoPerDAO implements InterfaceTblTipoPer {

	@Override
	public ArrayList<TblTipoPer> listado() {
		ArrayList<TblTipoPer> lista = new ArrayList<TblTipoPer>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select*from tipoPersona;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TblTipoPer p = new TblTipoPer();
				p.setCodigo(rs.getString(1));
				p.setDescripcion(rs.getString(2));

				lista.add(p);
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
	public int registrar(TblTipoPer p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tipoPersona values (?,?);";
			pst = con.prepareStatement(sql);

			pst.setString(1, p.getCodigo());
			pst.setString(2, p.getDescripcion());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public TblTipoPer buscarCodigo(String descripcion) {
		TblTipoPer x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_busca_tipo_persona (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, descripcion);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoPer();
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
	public TblTipoPer buscarDescrip(String codigo) {
		TblTipoPer x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscaDes_tipo_persona (?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoPer();
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
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return x;
	}

	@Override
	public int actualizar(TblTipoPer p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_tipoPer(?, ?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, p.getCodigo());
			pst.setString(2, p.getDescripcion());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int eliminar(TblTipoPer p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_tipoPer(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, p.getCodigo());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e2) {
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
			String sql = "{call usp_eliminar_tipoPer(?)}";
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
			} catch (SQLException e2) {
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public TblTipoPer obtener(String codigo) {
		TblTipoPer x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_tipo_persona (?)}";
			pst = con.prepareStatement(sql);
			
			pst.setString(1, codigo);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoPer();
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
