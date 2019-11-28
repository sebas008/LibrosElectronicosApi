package edu.cibertec.dao;

import edu.cibertec.interfaces.InterfaceCondPago;
import edu.cibertec.interfaces.InterfaceFacturaCompra;
import edu.cibertec.interfaces.InterfaceFacturaVenta;
import edu.cibertec.interfaces.InterfaceFacturaVentaDto;
import edu.cibertec.interfaces.InterfaceMntCliente;
import edu.cibertec.interfaces.InterfaceMntProveedor;
import edu.cibertec.interfaces.InterfaceMntTipoCambio;
import edu.cibertec.interfaces.InterfaceTblEstadoDoc;
import edu.cibertec.interfaces.InterfaceTblMoneda;
import edu.cibertec.interfaces.InterfaceTblPeriodoCon;
import edu.cibertec.interfaces.InterfaceTblTipoCli;
import edu.cibertec.interfaces.InterfaceTblTipoCom;
import edu.cibertec.interfaces.InterfaceTblTipoDoc;
import edu.cibertec.interfaces.InterfaceTblTipoPer;
import edu.cibertec.interfaces.InterfaceTblTipoPro;
import edu.cibertec.interfaces.InterfaceTblTipoRet;
import edu.cibertec.interfaces.UsuarioDAO;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		// TODO Auto-generated method stub
		return new MySqlUsuarioDAO();
	}

	@Override
	public InterfaceTblPeriodoCon getInterfaceTblPeriodoConDAO() {
		// TODO Auto-generated method stub
		return new MySqlTblPeriodoConDAO();
	}

	@Override
	public InterfaceCondPago getInterfaceCondPagoDAO() {
		// TODO Auto-generated method stub
		return new MySqlCondPagoDAO();
	}

	@Override
	public InterfaceTblEstadoDoc getInterfaceTblEstadoDocDAO() {
		// TODO Auto-generated method stub
		return new MySqlTblEstadoDocDAO();
	}

	@Override
	public InterfaceTblMoneda getInterfaceTblMonedaDAO() {
		// TODO Auto-generated method stub
		return new MySqlTblMonedaDAO();
	}

	@Override
	public InterfaceTblTipoCli getInterfaceTblTipoCliDAO() {
		// TODO Auto-generated method stub
		return new MySqlTblTipoCliDAO();
	}

	@Override
	public InterfaceTblTipoCom getInterfaceTblTipoComDAO() {
		// TODO Auto-generated method stub
		return new MySqlTblTipoComDAO();
	}

	@Override
	public InterfaceTblTipoDoc getIntefaceTblTipoDocDAO() {
		// TODO Auto-generated method stub
		return new MySqlTblTipoDocDAO();
	}

	@Override
	public InterfaceTblTipoPer getInterfaceTblTipoPerDAO() {
		// TODO Auto-generated method stub
		return new MySqlTblTipoPerDAO();
	}

	@Override
	public InterfaceTblTipoPro getInterfaceTblTipoProDAO() {
		// TODO Auto-generated method stub
		return new MySqlTblTipoProDAO();
	}

	@Override
	public InterfaceTblTipoRet getInterfaceTblTipoRetDAO() {
		// TODO Auto-generated method stub
		return new MySqlTblTipoRetDAO();
	}

	@Override
	public InterfaceMntTipoCambio getInterfaceMntTipoCambioDAO() {
		// TODO Auto-generated method stub
		return new MySqlTipoCambioDAO();
	}

	@Override
	public InterfaceMntCliente getInterfaceMntClienteDAO() {
		// TODO Auto-generated method stub
		return new MySqlMntClienteDAO();
	}

	@Override
	public InterfaceMntProveedor getInterfaceMntProveedorDAO() {
		// TODO Auto-generated method stub
		return new MySqlMntProveedorDAO();
	}

	@Override
	public InterfaceFacturaCompra getInterfaceFacturaCompraDAO() {
		// TODO Auto-generated method stub
		return new MySqlFacturaCompraDAO();
	}

	@Override
	public InterfaceFacturaVenta getInterfaceFacturaVentaDAO() {
		// TODO Auto-generated method stub
		return new MySqlFacturaVentaDAO();
	}

	@Override
	public InterfaceFacturaVentaDto getInterfaceFacturaVentaDtoDAO() {
		// TODO Auto-generated method stub
		return new MySqlFacturaVentaDtoDAO();
	}

}
