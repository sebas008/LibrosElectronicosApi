package edu.cibertec.servicioGet;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.cibertec.beans.ClFacturaCompra;
import edu.cibertec.beans.ClFacturaVenta;
import edu.cibertec.beans.FacturaVentaDTO;
import edu.cibertec.beans.MntCliente;
import edu.cibertec.beans.MntProveedor;
import edu.cibertec.beans.MntTipoCambio;
import edu.cibertec.beans.ReporteVentaPorPeriodo;
import edu.cibertec.beans.TblCondPago;
import edu.cibertec.beans.TblEstadoDoc;
import edu.cibertec.beans.TblMoneda;
import edu.cibertec.beans.TblTipoCli;
import edu.cibertec.beans.TblTipoCom;
import edu.cibertec.beans.TblTipoDoc;
import edu.cibertec.beans.TblTipoPer;
import edu.cibertec.beans.TblTipoPro;
import edu.cibertec.beans.TblTipoRet;
import edu.cibertec.service.GestionConPago;
import edu.cibertec.service.GestionFacturaCompra;
import edu.cibertec.service.GestionFacturaVentaDTO;
import edu.cibertec.service.GestionFacturaVentas;
import edu.cibertec.service.GestionMntCliente;
import edu.cibertec.service.GestionMntProveedor;
import edu.cibertec.service.GestionMntTipoCambio;
import edu.cibertec.service.GestionTblEstadoDoc;
import edu.cibertec.service.GestionTblMoneda;
import edu.cibertec.service.GestionTblTipoCli;
import edu.cibertec.service.GestionTblTipoCom;
import edu.cibertec.service.GestionTblTipoDoc;
import edu.cibertec.service.GestionTblTipoPer;
import edu.cibertec.service.GestionTblTipoPro;
import edu.cibertec.service.GestionTblTipoRet;

@Path("/tipoget")
public class RestGet {

	// http://localhost:8081/librosElectronicosApi/tipoget/condPago
	@GET
	@Path("/condPago")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TblCondPago> obtenerCondPago() {
		try {
			ArrayList<TblCondPago> condPago = new GestionConPago().listado();
			return condPago;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	// http://localhost:8081/librosElectronicosApi/tipoget/prove
	@GET
	@Path("/prove")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MntProveedor> obtenerProveedor() {
		try {
			ArrayList<MntProveedor> provee = new GestionMntProveedor().listado();
			return provee;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	// http://localhost:8081/librosElectronicosApi/tipoget/facturaCom
	@GET
	@Path("/facturaCom")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ClFacturaCompra> obtenerFacturaCompras() {
		try {
			ArrayList<ClFacturaCompra> facc = new GestionFacturaCompra().listado();
			return facc;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	// http://localhost:8081/librosElectronicosApi/tipoget/facturaCompra
	@GET
	@Path("/facturaCompra")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ClFacturaCompra> facturCompra(/*@PathParam("periodo") String periodo,
			@PathParam("codpro") String codpro, @PathParam("tipodoc") String tipodoc,
			@PathParam("moneda") String moneda*/) {
		try {
			ArrayList<ClFacturaCompra> facCom = new GestionFacturaCompra().listado();
			return facCom;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}


	// http://localhost:8081/librosElectronicosApi/tipoget/tipoPer
	@GET
	@Path("/tipoPer")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TblTipoPer> obtenerTipoPer() {
		try {
			ArrayList<TblTipoPer> tipop = new GestionTblTipoPer().listado();
			return tipop;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}	

	// http://localhost:8081/librosElectronicosApi/tipoget/tipoCom
	@GET
	@Path("/tipoCom")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TblTipoCom> obtenerTipoCom() {
		try {
			ArrayList<TblTipoCom> tipocom = new GestionTblTipoCom().listado();
			return tipocom;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	// http://localhost:8081/librosElectronicosApi/tipoget/moneda
	@GET
	@Path("/moneda")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TblMoneda> obtenerMoneda() {
		try {
			ArrayList<TblMoneda> mone = new GestionTblMoneda().listado();
			return mone;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}

	// http://localhost:8081/librosElectronicosApi/tipoget/tipCam
	@GET
	@Path("/tipCam")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MntTipoCambio> obtenerTipoCambio() {
		try {
			ArrayList<MntTipoCambio> tipoCam = new GestionMntTipoCambio().listado();
			return tipoCam;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}
	
	// http://localhost:8081/librosElectronicosApi/tipoget/facturaVenta
	@GET
	@Path("/facturaVenta")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ClFacturaVenta> facturVenta(/*@PathParam("periodo") String periodo,
			@PathParam("cliente") String cliente, @PathParam("tipoD") String tipoD,
			@PathParam("moneda") String moneda*/ ) {
		try {
			ArrayList<ClFacturaVenta> facCom = new GestionFacturaVentas().listado();
			return facCom;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	// http://localhost:8081/librosElectronicosApi/tipoget/tipCli
	@GET
	@Path("/tipCli")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TblTipoCli> obtenerTipoCliente() {
		try {
			ArrayList<TblTipoCli> tipoCli = new GestionTblTipoCli().listado();
			return tipoCli;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}
	
	// http://localhost:8081/librosElectronicosApi/tipoget/MntCli

	@GET
	@Path("/MntCli")
	@Produces(MediaType.APPLICATION_JSON)

	public List<MntCliente> obtenerMntCle() {
		try {
			ArrayList<MntCliente> mntCliente = new GestionMntCliente().listado();
			return mntCliente;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return null;
	}

	// http://localhost:8081/librosElectronicosApi/tipoget/TipoPro
	@GET
	@Path("/TipoPro")
	@Produces(MediaType.APPLICATION_JSON)

	public List<TblTipoPro> obtenerTblTipoPro() {
		try {
			ArrayList<TblTipoPro> tipoPro = new GestionTblTipoPro().listado();
			return tipoPro;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return null;
	}

	// http://localhost:8081/librosElectronicosApi/tipoget/TipoRet

	@GET
	@Path("/TipoRet")
	@Produces(MediaType.APPLICATION_JSON)

	public List<TblTipoRet> obtenerTblTipoRet() {

		try {
			ArrayList<TblTipoRet> tipoRet= new GestionTblTipoRet().listado();
			return tipoRet;

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return null;

	}
	
	// http://localhost:8081/librosElectronicosApi/tipoget/TipoDoc
	
	@GET
	@Path("/TipoDoc")
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<TblTipoDoc> obtenerTblTipoDoc(){
		
		
		try {
			
			ArrayList<TblTipoDoc> tblTipoDoc = new GestionTblTipoDoc().listado();
			return tblTipoDoc;
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		return null;
		
	}
	
	// http://localhost:8081/librosElectronicosApi/tipoget/EstadoDoc
	
	
	@GET
	@Path("/EstadoDoc")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TblEstadoDoc> obtenerTblEstadoDoc(){
		
		try {
			ArrayList<TblEstadoDoc> tblEstadoDoc= new GestionTblEstadoDoc().listado();
			return tblEstadoDoc;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO: handle exception
		}
		
		return null;
	}
	
	
	
	// http://localhost:8081/librosElectronicosApi/tipoget/facturaVenta/20171100/10407147982
	@GET
	@Path("/facturaVenta/{periodo}/{cliente}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ClFacturaVenta> facturVentaxPeriodo(@PathParam("periodo") String periodo, @PathParam("cliente") String cliente)/*@PathParam("periodo") String periodo,
	@PathParam("cliente") String cliente, @PathParam("tipoD") String tipoD,
	@PathParam("moneda") String moneda*/ {
		try {
			ArrayList<ClFacturaVenta> facCom = new GestionFacturaVentas().listado();
			return facCom;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	// http://localhost:8081/librosElectronicosApi/tipoget/sumaVentasPorPeriodo
	@GET
	@Path("/sumaVentasPorPeriodo")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ReporteVentaPorPeriodo> facturVentaxPeriodo() {
		try {
			ArrayList<ReporteVentaPorPeriodo> facCom = new GestionFacturaVentas().periodoxtotal();
			return facCom;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	// http://localhost:8081/librosElectronicosApi/tipoget/facturVentaPeriodoxTotal/20171100/236
	@GET
	@Path("/facturVentaPeriodoxTotal/{periodo}/{total}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<FacturaVentaDTO> facturVentaPeriodoxTotal(@PathParam("periodo") String periodo, @PathParam("total") String total) {
		try {
			ArrayList<FacturaVentaDTO> facCom = new GestionFacturaVentaDTO().periodoxTotal(periodo, total);
			return facCom;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
}
