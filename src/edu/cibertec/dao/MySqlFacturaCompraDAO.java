package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.ClFacturaCompra;
import edu.cibertec.interfaces.InterfaceFacturaCompra;
import edu.cibertec.utils.MySQLConexion;

public class MySqlFacturaCompraDAO implements InterfaceFacturaCompra {

		
	@Override
	public int registrar(ClFacturaCompra u) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "Insert into facturaCompra values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, u.getPeriodo());
			pst.setString(2, u.getMoneda());
			pst.setString(3, u.getFecha());
			pst.setDouble(4, u.getTipoCambio());
			pst.setString(5, u.getTipoDoc());
			pst.setString(6, u.getSerieDoc());
			pst.setString(7, u.getNumDoc());
			pst.setString(8, u.getCod_Pro());
			pst.setString(9, u.getRazonS_Pro());
			pst.setDouble(10, u.getValorVenta());
			pst.setDouble(11, u.getValorInafecto());
			pst.setDouble(12, u.getIgv());
			pst.setDouble(13, u.getTotal());
			pst.setString(14, u.getCod_Re());
			pst.setString(15, u.getDes_Re());
			pst.setDouble(16, u.getTasa_re());
			pst.setString(17, u.getFechaRet());
			pst.setString(18, u.getNroRet());
			pst.setDouble(19, u.getMontoRet());
			pst.setString(20, u.getGlosa_Compra());
			pst.setString(21, u.getCodcom());
			pst.setString(22, u.getCod_estado());

			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());

		} finally {
			try {
				if (con != null)
					con.close();
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				System.out.println("Error al Cerrar: " + e.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int actualizar(ClFacturaCompra u) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "{call usp_actualiza_FacturaCompras (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			pst = con.prepareStatement(sql);
			pst.setString(1, u.getPeriodo());
			pst.setString(2, u.getMoneda());
			pst.setString(3, u.getFecha());
			pst.setDouble(4, u.getTipoCambio());
			pst.setString(5, u.getTipoDoc());
			pst.setString(6, u.getSerieDoc());
			pst.setString(7, u.getNumDoc());
			pst.setString(8, u.getCod_Pro());
			pst.setString(9, u.getRazonS_Pro());
			pst.setDouble(10, u.getValorVenta());
			pst.setDouble(11, u.getValorInafecto());
			pst.setDouble(12, u.getIgv());
			pst.setDouble(13, u.getTotal());
			pst.setString(14, u.getCod_Re());
			pst.setString(15, u.getDes_Re());
			pst.setDouble(16, u.getTasa_re());
			pst.setString(17, u.getFechaRet());
			pst.setString(18, u.getNroRet());
			pst.setDouble(19, u.getMontoRet());
			pst.setString(20, u.getGlosa_Compra());
			pst.setString(21, u.getCodcom());
			pst.setString(22, u.getCod_estado());

			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());

		} finally {
			try {
				if (con != null)
					con.close();
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				System.out.println("Error al Cerrar: " + e.getMessage());
			}
		}

		return rs;
	}

	@Override
	public int eliminar(ClFacturaCompra u) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "{call usp_eliminar_FacturaCompras(?,?,?)}";

			pst = con.prepareStatement(sql);

			pst.setString(1, u.getCod_Pro());
			pst.setString(2, u.getSerieDoc());
			pst.setString(3, u.getNumDoc());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());

		} finally {
			try {
				if (con != null)
					con.close();
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				System.out.println("Error al Cerrar: " + e.getMessage());
			}
		}

		return rs;
	}

	@Override
	public ArrayList<ClFacturaCompra> listado() {
		ArrayList<ClFacturaCompra> lista = new ArrayList<ClFacturaCompra>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_lista_facturas_compra()}";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				ClFacturaCompra f = new ClFacturaCompra();
				f.setPeriodo(rs.getString(1));
				f.setMoneda(rs.getString(2));
				f.setFecha(rs.getString(3));
				f.setTipoCambio(rs.getDouble(4));
				f.setTipoDoc(rs.getString(5));
				f.setSerieDoc(rs.getString(6));
				f.setNumDoc(rs.getString(7));
				f.setCod_Pro(rs.getString(8));
				f.setRazonS_Pro(rs.getString(9));
				f.setValorVenta(rs.getDouble(10));
				f.setValorInafecto(rs.getDouble(11));
				f.setIgv(rs.getDouble(12));
				f.setTotal(rs.getDouble(13));
				f.setCod_Re(rs.getString(14));
				f.setDes_Re(rs.getString(15));
				f.setTasa_re(rs.getInt(16));
				f.setFechaRet(rs.getString(17));
				f.setNroRet(rs.getString(18));
				f.setMontoRet(rs.getDouble(19));
				f.setGlosa_Compra(rs.getString(20));
				f.setCodcom(rs.getString(21));
				f.setDesCodcom(rs.getString(22));
				f.setCod_estado(rs.getString(23));
				f.setDes_estado(rs.getString(24));

				lista.add(f);

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
	public ClFacturaCompra consulta(String cliente, String num, String serie) {
		ClFacturaCompra f = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscarFacturaCompras (?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, cliente);
			pst.setString(2, num);
			pst.setString(3, serie);

			rs = pst.executeQuery();

			while (rs.next()) {
				f = new ClFacturaCompra();
				f.setPeriodo(rs.getString(1));
				f.setMoneda(rs.getString(2));
				f.setFecha(rs.getString(3));
				f.setTipoCambio(rs.getDouble(4));
				f.setTipoDoc(rs.getString(5));
				f.setSerieDoc(rs.getString(6));
				f.setNumDoc(rs.getString(7));
				f.setCod_Pro(rs.getString(8));
				f.setRazonS_Pro(rs.getString(9));
				f.setValorVenta(rs.getDouble(10));
				f.setValorInafecto(rs.getDouble(11));
				f.setIgv(rs.getDouble(12));
				f.setTotal(rs.getDouble(13));
				f.setCod_Re(rs.getString(14));
				f.setDes_Re(rs.getString(15));
				f.setTasa_re(rs.getInt(16));
				f.setGlosa_Compra(rs.getString(17));
				f.setCod_estado(rs.getString(18));
				f.setDes_estado(rs.getString(19));

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
		return f;
	}

	@Override
	public ArrayList<ClFacturaCompra> reporteCompras(String periodo, String codpro, String tipodoc, String moneda) {
		ArrayList<ClFacturaCompra> lista = new ArrayList<ClFacturaCompra>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_reporte_registro_compras(?,?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, periodo);
			pst.setString(2, codpro);
			pst.setString(3, tipodoc);
			pst.setString(4, moneda);
			
			rs = pst.executeQuery();

			while (rs.next()) {
				ClFacturaCompra f = new ClFacturaCompra();
				f.setPeriodo(rs.getString(1));
				f.setFecha(rs.getString(2));
				f.setMoneda(rs.getString(3));
				f.setTipoCambio(rs.getDouble(4));
				f.setTipoDoc(rs.getString(5));
				f.setSerieDoc(rs.getString(6));
				f.setNumDoc(rs.getString(7));
				f.setCod_Pro(rs.getString(8));
				f.setRazonS_Pro(rs.getString(9));
				f.setValorVenta(rs.getDouble(10));
				f.setValorInafecto(rs.getDouble(11));
				f.setIgv(rs.getDouble(12));
				f.setTotal(rs.getDouble(13));
				f.setGlosa_Compra(rs.getString(14));
				
				lista.add(f);

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
	public int eliminar(String codigo, String serie, String numero) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "{call usp_eliminar_FacturaCompras(?,?,?)}";

			pst = con.prepareStatement(sql);

			pst.setString(1, codigo);
			pst.setString(2, serie);
			pst.setString(3, numero);

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());

		} finally {
			try {
				if (con != null)
					con.close();
				if (pst != null)
					pst.close();
			} catch (SQLException e) {
				System.out.println("Error al Cerrar: " + e.getMessage());
			}
		}

		return rs;
	}

	@Override
	public ClFacturaCompra obtener(String cliente, String num, String serie) {
		ClFacturaCompra f = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_FacturaCompra (?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, cliente);
			pst.setString(2, serie);
			pst.setString(3, num);

			rs = pst.executeQuery();

			while (rs.next()) {
				f = new ClFacturaCompra();
				f.setPeriodo(rs.getString(1));
				f.setMoneda(rs.getString(2));
				f.setFecha(rs.getString(3));
				f.setTipoCambio(rs.getDouble(4));
				f.setTipoDoc(rs.getString(5));
				f.setSerieDoc(rs.getString(6));
				f.setNumDoc(rs.getString(7));
				f.setCod_Pro(rs.getString(8));
				f.setRazonS_Pro(rs.getString(9));
				f.setValorVenta(rs.getDouble(10));
				f.setValorInafecto(rs.getDouble(11));
				f.setIgv(rs.getDouble(12));
				f.setTotal(rs.getDouble(13));
				f.setCod_Re(rs.getString(14));
				f.setDes_Re(rs.getString(15));
				f.setTasa_re(rs.getInt(16));
				f.setFechaRet(rs.getString(17));
				f.setNroRet(rs.getString(18));
				f.setMontoRet(rs.getDouble(19));
				f.setGlosa_Compra(rs.getString(20));
				f.setCodcom(rs.getString(21));
				f.setCod_estado(rs.getString(22));
				

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
		return f;
	}

}
