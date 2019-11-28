package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.ClFacturaVenta;
import edu.cibertec.beans.FacturaVentaDTO;
import edu.cibertec.interfaces.InterfaceFacturaVentaDto;
import edu.cibertec.utils.MySQLConexion;

public class MySqlFacturaVentaDtoDAO implements InterfaceFacturaVentaDto{

	public ArrayList<FacturaVentaDTO> periodoxTotal(String periodo, String total) {
		ArrayList<FacturaVentaDTO> lista = new ArrayList<FacturaVentaDTO>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call sp_periodoxTotal(?,?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, periodo);
			pst.setString(2, total);

			
			rs = pst.executeQuery();

			while (rs.next()) {
				FacturaVentaDTO f = new FacturaVentaDTO();
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
				f.setTotal(rs.getString(13));
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
	
	
}
