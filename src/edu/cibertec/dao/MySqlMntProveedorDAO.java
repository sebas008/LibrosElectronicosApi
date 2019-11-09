package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.MntProveedor;
import edu.cibertec.interfaces.InterfaceMntProveedor;
import edu.cibertec.utils.MySQLConexion;

public class MySqlMntProveedorDAO implements InterfaceMntProveedor {

	@Override
	public ArrayList<MntProveedor> listado() {
		ArrayList<MntProveedor> lista = new ArrayList<MntProveedor>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from proveedor;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				MntProveedor p = new MntProveedor();
				p.setTipoPer(rs.getString(1));
				p.setCodigo(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setDireccion(rs.getString(4));
				p.setTipoCli(rs.getString(5));
				p.setContacto(rs.getString(6));
				p.setTelefono(rs.getString(7));
				p.setCondPago(rs.getString(8));
				p.setCorreo(rs.getString(9));

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
				System.out.println("Error al Cerrar: " + e.getMessage());
			}
		}

		return lista;
	}

	@Override
	public ArrayList<MntProveedor> listado2(String descripcion) {
		ArrayList<MntProveedor> lista = new ArrayList<MntProveedor>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_busca_proveedor (?)}";
			pst = con.prepareStatement(sql);
			pst.setString(1, descripcion);
			rs = pst.executeQuery();

			while (rs.next()) {
				MntProveedor p = new MntProveedor();
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
				System.out.println("Error al Cerrar: " + e.getMessage());
			}
		}

		return lista;
	}

	@Override
	public int Registrar(MntProveedor e) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into proveedor values (?,?,?,?,?,?,?,?,?);";
			pst = con.prepareStatement(sql);

			pst.setString(1, e.getTipoPer());
			pst.setString(2, e.getCodigo());
			pst.setString(3, e.getDescripcion());
			pst.setString(4, e.getDireccion());
			pst.setString(5, e.getTipoCli());
			pst.setString(6, e.getContacto());
			pst.setString(7, e.getTelefono());
			pst.setString(8, e.getCondPago());
			pst.setString(9, e.getCorreo());

			rs = pst.executeUpdate();

		} catch (Exception e2) {
			System.out.println("Se suscito la siguiente Excepcion: " + e2.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e1) {
				System.out.println("Error al Cerrar: " + e1.getMessage());
			}
		}

		return rs;
	}

	@Override
	public MntProveedor buscar(String descripcion) {
		MntProveedor x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_busca_proveedor (?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, descripcion);
			rs = pst.executeQuery();

			while (rs.next()) {
				x = new MntProveedor();
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
				System.out.println("Error al Cerrar: " + e.getMessage());
			}
		}
		return x;
	}

	@Override
	public MntProveedor buscarDes(String codigo) {
		MntProveedor x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscar_proveedor (?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new MntProveedor();
				//x.setCodigo(rs.getString(1));
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
				System.out.println("Error al Cerrar: " + e.getMessage());
			}
		}
		return x;
	}

	@Override
	public int actualizar(MntProveedor p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_proveedor (?,?,?,?,?,?,?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, p.getTipoPer());
			pst.setString(2, p.getCodigo());
			pst.setString(3, p.getDescripcion());
			pst.setString(4, p.getDireccion());
			pst.setString(5, p.getTipoCli());
			pst.setString(6, p.getContacto());
			pst.setString(7, p.getTelefono());
			pst.setString(8, p.getCondPago());
			pst.setString(9, p.getCorreo());

			rs = pst.executeUpdate();

		} catch (Exception e2) {
			System.out.println("Se suscito la siguiente Excepcion: " + e2.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e1) {
				System.out.println("Error al Cerrar: " + e1.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int eliminar(MntProveedor p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_proveedor(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, p.getCodigo());

			rs = pst.executeUpdate();

		} catch (Exception e2) {
			System.out.println("Se suscito la siguiente Excepcion: " + e2.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e1) {
				System.out.println("Error al Cerrar: " + e1.getMessage());
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
			String sql = "{call usp_eliminar_proveedor(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);

			rs = pst.executeUpdate();

		} catch (Exception e2) {
			System.out.println("Se suscito la siguiente Excepcion: " + e2.getMessage());
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					con.close();
			} catch (SQLException e1) {
				System.out.println("Error al Cerrar: " + e1.getMessage());
			}
		}

		return rs;
	}

	@Override
	public MntProveedor obtener(String codigo) {
		MntProveedor x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_proveedor (?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new MntProveedor();
				x.setTipoPer(rs.getString(1));
				x.setCodigo(rs.getString(2));
				x.setDescripcion(rs.getString(3));
				x.setDireccion(rs.getString(4));
				x.setTipoCli(rs.getString(5));
				x.setContacto(rs.getString(6));
				x.setTelefono(rs.getString(7));
				x.setCondPago(rs.getString(8));
				x.setCorreo(rs.getString(9));

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
				System.out.println("Error al Cerrar: " + e.getMessage());
			}
		}
		return x;
	}

}
