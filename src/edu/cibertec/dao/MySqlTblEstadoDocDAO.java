package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import edu.cibertec.beans.TblEstadoDoc;
import edu.cibertec.interfaces.InterfaceTblEstadoDoc;
import edu.cibertec.utils.MySQLConexion;

public class MySqlTblEstadoDocDAO implements InterfaceTblEstadoDoc {

	@Override
	public ArrayList<TblEstadoDoc> listado() {
		ArrayList<TblEstadoDoc> lista = new ArrayList<TblEstadoDoc>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from estadoDoc;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TblEstadoDoc d = new TblEstadoDoc();
				d.setCodigo(rs.getInt(1));
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
	public int registrar(TblEstadoDoc e) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into estadoDoc values (?,?);";
			pst = con.prepareStatement(sql);

			pst.setInt(1, e.getCodigo());
			pst.setString(2, e.getDescripcion());

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
				System.out.println("Error al Cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public TblEstadoDoc consultar(int e) {
		TblEstadoDoc x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscar_estado(?)}";
			pst = con.prepareStatement(sql);

			pst.setInt(1, e);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblEstadoDoc();
				x.setDescripcion(rs.getString(1));
			}

		} catch (Exception e1) {
			System.out.println("Se suscito la siguiente Excepcion: " + e1.getMessage());
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
	public int actualizar(TblEstadoDoc e) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_estadoDoc(?, ?)}";
			pst = con.prepareStatement(sql);

			pst.setInt(1, e.getCodigo());
			pst.setString(2, e.getDescripcion());

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
				System.out.println("Error al Cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int eliminar(TblEstadoDoc e) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_estadoDoc(?)}";
			pst = con.prepareStatement(sql);

			pst.setInt(1, e.getCodigo());

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
				System.out.println("Error al Cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int eliminar(int codigo) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_estadoDoc(?)}";
			pst = con.prepareStatement(sql);

			pst.setInt(1, codigo);

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
				System.out.println("Error al Cerrar: " + e2.getMessage());
			}
		}

		return rs;
	}

	@Override
	public TblEstadoDoc obtener(int codigo) {
		TblEstadoDoc x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_estado(?)}";
			pst = con.prepareStatement(sql);

			pst.setInt(1, codigo);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblEstadoDoc();
				x.setCodigo(rs.getInt(1));
				x.setDescripcion(rs.getString(2));
			}

		} catch (Exception e1) {
			System.out.println("Se suscito la siguiente Excepcion: " + e1.getMessage());
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
