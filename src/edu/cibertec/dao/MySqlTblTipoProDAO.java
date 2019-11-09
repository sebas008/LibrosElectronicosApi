package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.TblTipoPro;
import edu.cibertec.interfaces.InterfaceTblTipoPro;
import edu.cibertec.utils.MySQLConexion;

public class MySqlTblTipoProDAO implements InterfaceTblTipoPro {

	@Override
	public ArrayList<TblTipoPro> listado() {
		ArrayList<TblTipoPro> lista = new ArrayList<TblTipoPro>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select*from tipoProveedor";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TblTipoPro p = new TblTipoPro();
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
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}
		return lista;
	}

	@Override
	public int registrar(TblTipoPro p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into tipoProveedor values (?,?);";
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
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}

		return rs;
	}

	@Override
	public TblTipoPro buscarCodigo(String descripcion) {
		TblTipoPro x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_busca_tipo_proveedor (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, descripcion);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoPro();
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
	public TblTipoPro buscarDes(String codigo) {
		TblTipoPro x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscaDes_tipo_proveedor (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoPro();
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
	public int actualizar(TblTipoPro p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_tipoPro(?, ?)}";
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
			} catch (SQLException e) {
				System.out.println("Error al cerrar: " + e.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int eliminar(TblTipoPro p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_tipoPro(?)}";
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
			String sql = "{call usp_eliminar_tipoPro(?)}";
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
	public TblTipoPro obtener(String codigo) {
		TblTipoPro x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_tipo_proveedor (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, codigo);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblTipoPro();
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
