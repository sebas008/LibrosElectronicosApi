package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.ClFacturaVenta;
import edu.cibertec.beans.ReporteVentaPorPeriodo;
import edu.cibertec.interfaces.InterfaceFacturaVenta;
import edu.cibertec.utils.MySQLConexion;

public class MySqlFacturaVentaDAO implements InterfaceFacturaVenta {

	@Override
	public int registrar(ClFacturaVenta u) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "Insert into facturaVenta values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			pst = con.prepareStatement(sql);
			pst.setString(1, u.getPeriodo());
			pst.setString(2, u.getMoneda());
			pst.setString(3, u.getFecha());
			pst.setDouble(4, u.getTipoCambio());
			pst.setString(5, u.getTipoDoc());
			pst.setString(6, u.getSerieDoc());
			pst.setString(7, u.getNumDoc());
			pst.setString(8, u.getCod_Cli());
			pst.setString(9, u.getRazonS_Cli());
			pst.setDouble(10, u.getValorVenta());
			pst.setDouble(11, u.getValorInafecto());
			pst.setDouble(12, u.getIgv());
			pst.setDouble(13, u.getTotal());
			pst.setString(14, u.getCod_Re());
			pst.setString(15, u.getDes_Re());
			pst.setDouble(16, u.getTasa_re());
			pst.setString(17, u.getGlosa_venta());
			pst.setString(18, u.getCod_estado());

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
	public int actualizar(ClFacturaVenta u) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "{call usp_actualiza_FacturaVentas (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			pst = con.prepareStatement(sql);

			pst.setString(1, u.getPeriodo());
			pst.setString(2, u.getMoneda());
			pst.setString(3, u.getFecha());
			pst.setDouble(4, u.getTipoCambio());
			pst.setString(5, u.getTipoDoc());
			pst.setString(6, u.getSerieDoc());
			pst.setString(7, u.getNumDoc());
			pst.setString(8, u.getCod_Cli());
			pst.setString(9, u.getRazonS_Cli());
			pst.setDouble(10, u.getValorVenta());
			pst.setDouble(11, u.getValorInafecto());
			pst.setDouble(12, u.getIgv());
			pst.setDouble(13, u.getTotal());
			pst.setString(14, u.getCod_Re());
			pst.setString(15, u.getDes_Re());
			pst.setDouble(16, u.getTasa_re());
			pst.setString(17, u.getGlosa_venta());
			pst.setString(18, u.getCod_estado());

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
	public int eliminar(ClFacturaVenta u) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();

			String sql = "{call usp_eliminar_FacturaVentas(?,?,?)}";

			pst = con.prepareStatement(sql);

			pst.setString(1, u.getCod_Cli());
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
	public ArrayList<ClFacturaVenta> listado() {
		ArrayList<ClFacturaVenta> lista = new ArrayList<ClFacturaVenta>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_lista_facturas_venta()}";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				ClFacturaVenta f = new ClFacturaVenta();
				f.setPeriodo(rs.getString(1));
				f.setMoneda(rs.getString(2));
				f.setFecha(rs.getString(3));
				f.setTipoCambio(rs.getDouble(4));
				f.setTipoDoc(rs.getString(5));
				f.setSerieDoc(rs.getString(6));
				f.setNumDoc(rs.getString(7));
				f.setCod_Cli(rs.getString(8));
				f.setRazonS_Cli(rs.getString(9));
				f.setValorVenta(rs.getDouble(10));
				f.setValorInafecto(rs.getDouble(11));
				f.setIgv(rs.getDouble(12));
				f.setTotal(rs.getDouble(13));
				f.setCod_Re(rs.getString(14));
				f.setDes_Re(rs.getString(15));
				f.setTasa_re(rs.getInt(16));
				f.setGlosa_venta(rs.getString(17));
				f.setCod_estado(rs.getString(18));
				f.setDes_estado(rs.getString(19));

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
	public ClFacturaVenta consulta(String cliente, String num, String serie) {
		ClFacturaVenta f = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_buscarFacturaVentas (?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, cliente);
			pst.setString(2, num);
			pst.setString(3, serie);

			rs = pst.executeQuery();

			while (rs.next()) {
				f = new ClFacturaVenta();
				f.setPeriodo(rs.getString(1));
				f.setMoneda(rs.getString(2));
				f.setFecha(rs.getString(3));
				f.setTipoCambio(rs.getDouble(4));
				f.setTipoDoc(rs.getString(5));
				f.setSerieDoc(rs.getString(6));
				f.setNumDoc(rs.getString(7));
				f.setCod_Cli(rs.getString(8));
				f.setRazonS_Cli(rs.getString(9));
				f.setValorVenta(rs.getDouble(10));
				f.setValorInafecto(rs.getDouble(11));
				f.setIgv(rs.getDouble(12));
				f.setTotal(rs.getDouble(13));
				f.setCod_Re(rs.getString(14));
				f.setDes_Re(rs.getString(15));
				f.setTasa_re(rs.getInt(16));
				f.setGlosa_venta(rs.getString(17));
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
	public ArrayList<ClFacturaVenta> reporteVentas(String periodo, String cliente, String tipoD, String moneda) {
		ArrayList<ClFacturaVenta> lista = new ArrayList<ClFacturaVenta>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_reporte_registro_ventas(?,?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, periodo);
			pst.setString(2, cliente);
			pst.setString(3, tipoD);
			pst.setString(4, moneda);
			
			rs = pst.executeQuery();

			while (rs.next()) {
				ClFacturaVenta f = new ClFacturaVenta();
				f.setPeriodo(rs.getString(1));
				f.setFecha(rs.getString(2));
				f.setMoneda(rs.getString(3));
				f.setTipoCambio(rs.getDouble(4));
				f.setTipoDoc(rs.getString(5));
				f.setSerieDoc(rs.getString(6));
				f.setNumDoc(rs.getString(7));
				f.setCod_Cli(rs.getString(8));
				f.setRazonS_Cli(rs.getString(9));
				f.setValorVenta(rs.getDouble(10));
				f.setValorInafecto(rs.getDouble(11));
				f.setIgv(rs.getDouble(12));
				f.setTotal(rs.getDouble(13));
				f.setGlosa_venta(rs.getString(14));
				
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

			String sql = "{call usp_eliminar_FacturaVentas(?,?,?)}";

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
	public ClFacturaVenta obtener(String cliente, String serie, String numero) {
		ClFacturaVenta f = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_FacturaVentas (?,?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, cliente);
			pst.setString(2, serie);
			pst.setString(3, numero);

			rs = pst.executeQuery();

			while (rs.next()) {
				f = new ClFacturaVenta();
				f.setPeriodo(rs.getString(1));
				f.setMoneda(rs.getString(2));
				f.setFecha(rs.getString(3));
				f.setTipoCambio(rs.getDouble(4));
				f.setTipoDoc(rs.getString(5));
				f.setSerieDoc(rs.getString(6));
				f.setNumDoc(rs.getString(7));
				f.setCod_Cli(rs.getString(8));
				f.setRazonS_Cli(rs.getString(9));
				f.setValorVenta(rs.getDouble(10));
				f.setValorInafecto(rs.getDouble(11));
				f.setIgv(rs.getDouble(12));
				f.setTotal(rs.getDouble(13));
				f.setCod_Re(rs.getString(14));
				f.setDes_Re(rs.getString(15));
				f.setTasa_re(rs.getInt(16));
				f.setGlosa_venta(rs.getString(17));
				f.setCod_estado(rs.getString(18));
				

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
	public ArrayList<ReporteVentaPorPeriodo> periodoxtotal() {
		ArrayList<ReporteVentaPorPeriodo> lista = new ArrayList<ReporteVentaPorPeriodo>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_total_venta_por_periodo()}";
			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				ReporteVentaPorPeriodo f = new ReporteVentaPorPeriodo();
				f.setPeriodo(rs.getString(1));
				f.setSuma(rs.getDouble(2));


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

	

}
