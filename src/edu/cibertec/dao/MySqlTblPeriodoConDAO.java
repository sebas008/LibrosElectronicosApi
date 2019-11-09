package edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.cibertec.beans.TblPeriodoContable;
import edu.cibertec.interfaces.InterfaceTblPeriodoCon;
import edu.cibertec.utils.MySQLConexion;

public class MySqlTblPeriodoConDAO implements InterfaceTblPeriodoCon {

	@Override
	public ArrayList<TblPeriodoContable> lista() {


		ArrayList<TblPeriodoContable> lista = new ArrayList<TblPeriodoContable>();
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "select * from periodoContable;";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				TblPeriodoContable p = new TblPeriodoContable();
				p.setCodPerdiodo(rs.getString(1));
				p.setDesPeriodo(rs.getString(2));

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
				System.out.println("error al cerrar: " + e.getMessage());
			}

		}

		return lista;
	}

	@Override
	public int registrar(TblPeriodoContable p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "insert into periodocontable values (?,?);";
			pst = con.prepareStatement(sql);

			pst.setString(1, p.getCodPerdiodo());
			pst.setString(2, p.getDesPeriodo());

			rs = pst.executeUpdate();

		} catch (SQLException e) {
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
	public TblPeriodoContable consultaPeriodo(String p) {
		TblPeriodoContable x = null;
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_obtener_periodo(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, p);

			rs = pst.executeQuery();

			while (rs.next()) {
				x = new TblPeriodoContable();
				x.setCodPerdiodo(rs.getString(1));
				x.setDesPeriodo(rs.getString(2));

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
				System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
			}

		}

		return x;

	}

	@Override
	public int actualizar(TblPeriodoContable p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_actualizar_periodoCon(?, ?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, p.getCodPerdiodo());
			pst.setString(2, p.getDesPeriodo());

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
				System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
			}

		}

		return rs;

	}

	@Override
	public int eliminar(TblPeriodoContable p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "{call usp_eliminar_periodoCon(?)}";
			pst = con.prepareStatement(sql);

			pst.setString(1, p.getCodPerdiodo());
			
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
				System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
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
			String sql = "{call usp_eliminar_periodoCon(?)}";
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
				System.out.println("Se suscito la siguiente Excepcion: " + e.getMessage());
			}
		}
		return rs;
	}

}
