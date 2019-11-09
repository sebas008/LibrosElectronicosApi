package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.TblTipoDoc;
import edu.cibertec.interfaces.InterfaceTblTipoDoc;
import edu.cibertec.utils.MySQLConexion;

public class MySqlTblTipoDocDAO implements InterfaceTblTipoDoc {

	@Override
	public ArrayList<TblTipoDoc> listado() {
		ArrayList<TblTipoDoc> lista = new ArrayList<TblTipoDoc>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from tipoDocumento;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TblTipoDoc d = new TblTipoDoc();
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
				System.out.println("Error al cerrar: " + e2.getMessage());
			}
		}

		return lista;
	}

	@Override
	public int registrar(TblTipoDoc d) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tipoDocumento values (?,?);";
			pst = con.prepareStatement(sql);

			pst.setString(1, d.getCodigo());
			pst.setString(2, d.getDescripcion());

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
	public TblTipoDoc buscarCodigo(String descripcion) {
		TblTipoDoc x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_busca_tipo_doc (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, descripcion);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoDoc();
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
	public TblTipoDoc buscarDes(String codigo) {
		TblTipoDoc x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscaDes_tipo_doc (?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);
			
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoDoc();
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
	public int actualizar(TblTipoDoc d) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_tipoDoc(?, ?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, d.getCodigo());
			pst.setString(2, d.getDescripcion());

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
	public int eliminar(TblTipoDoc d) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_tipoDoc(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, d.getCodigo());
			
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
			String sql = "{call usp_eliminar_tipoDoc(?)}";
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
	public TblTipoDoc obtener(String codigo) {
		TblTipoDoc x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_tipoDoc (?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);
			
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoDoc();
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
