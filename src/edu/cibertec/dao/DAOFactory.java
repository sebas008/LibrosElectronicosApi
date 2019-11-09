package edu.cibertec.dao;

import edu.cibertec.interfaces.InterfaceCondPago;
import edu.cibertec.interfaces.InterfaceFacturaCompra;
import edu.cibertec.interfaces.InterfaceFacturaVenta;
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


public abstract class DAOFactory {

	//Constantes que representan las BD
    public static final int MYSQL = 1;
    public static final int ORACLE = 2;
    public static final int DB2 = 3;
    public static final int SQLSERVER = 4;
    public static final int XML = 5;
    
    //Método que implementarán las clase hija
    public abstract UsuarioDAO getUsuarioDAO();
    public abstract InterfaceTblPeriodoCon getInterfaceTblPeriodoConDAO();
    public abstract InterfaceCondPago getInterfaceCondPagoDAO();
    public abstract InterfaceTblEstadoDoc getInterfaceTblEstadoDocDAO();
    public abstract InterfaceTblMoneda getInterfaceTblMonedaDAO(); 
    public abstract InterfaceTblTipoCli getInterfaceTblTipoCliDAO();
    public abstract InterfaceTblTipoCom getInterfaceTblTipoComDAO();
    public abstract InterfaceTblTipoDoc getIntefaceTblTipoDocDAO(); 
    public abstract InterfaceTblTipoPer getInterfaceTblTipoPerDAO();
    public abstract InterfaceTblTipoPro getInterfaceTblTipoProDAO();
    public abstract InterfaceTblTipoRet getInterfaceTblTipoRetDAO();
    public abstract InterfaceMntTipoCambio getInterfaceMntTipoCambioDAO();
    public abstract InterfaceMntCliente getInterfaceMntClienteDAO();
    public abstract InterfaceMntProveedor getInterfaceMntProveedorDAO();
    public abstract InterfaceFacturaCompra getInterfaceFacturaCompraDAO();
    public abstract InterfaceFacturaVenta getInterfaceFacturaVentaDAO();
    
    //Método estático que obtiene la implementación según BD seleccionada 
    public static DAOFactory getDAOFactory(int whichFactory){
       switch(whichFactory){
//       	case SQLSERVER:
//       	    return new SqlDAOFactory();
       	case MYSQL:
       		return new MySqlDAOFactory();
       	/*case DB2:
       	    return new Db2DAOFactory();
       	case SQLSERVER:
       	    return new SqlServerDAOFactory();
       	case XML:
       	    return new XmlDAOFactory();*/
       	default:
       	    return null;
       }
    }
    
    
}
