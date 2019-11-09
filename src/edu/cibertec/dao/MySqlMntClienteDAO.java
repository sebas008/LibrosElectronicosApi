package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.MntCliente;
import edu.cibertec.interfaces.InterfaceMntCliente;
import edu.cibertec.utils.MySQLConexion;

public class MySqlMntClienteDAO implements InterfaceMntCliente {

	@Override
	public ArrayList<MntCliente> listado() {
		ArrayList<MntCliente> lista = new ArrayList<MntCliente>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "Select * from cliente;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				MntCliente c = new MntCliente();
				c.setTipoPer(rs.getString(1));
				c.setCodigo(rs.getString(2));
				c.setDescripcion(rs.getString(3));
				c.setDireccion(rs.getString(4));
				c.setTipoCli(rs.getString(5));
				c.setContacto(rs.getString(6));
				c.setTelefono(rs.getString(7));
				c.setCondPago(rs.getString(8));
				c.setCorreo(rs.getString(9));

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
				System.out.println("Error al Cerrar: " + e.getMessage());
			}
		}

		return lista;
	}

	@Override
	public int Registrar(MntCliente e) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into cliente values (?,?,?,?,?,?,?,?,?);";
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
	public int actualizar(MntCliente c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_cliente (?,?,?,?,?,?,?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, c.getTipoPer());
			pst.setString(2, c.getCodigo());
			pst.setString(3, c.getDescripcion());
			pst.setString(4, c.getDireccion());
			pst.setString(5, c.getTipoCli());
			pst.setString(6, c.getContacto());
			pst.setString(7, c.getTelefono());
			pst.setString(8, c.getCondPago());
			pst.setString(9, c.getCorreo());

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
	public int eliminar(MntCliente c) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_cliente(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, c.getCodigo());

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
	public MntCliente buscarCliente(String c) {
		MntCliente x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscar_cliente(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, c);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new MntCliente();
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
	public int eliminar(String codigo) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_cliente(?)}";
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
	public MntCliente obtener(String codigo) {
		MntCliente x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_cliente(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new MntCliente();
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
