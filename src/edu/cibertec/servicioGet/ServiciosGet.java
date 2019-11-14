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
import edu.cibertec.beans.MntProveedor;
import edu.cibertec.beans.MntTipoCambio;
import edu.cibertec.beans.TblCondPago;
import edu.cibertec.beans.TblMoneda;
import edu.cibertec.beans.TblTipoCli;
import edu.cibertec.beans.TblTipoCom;
import edu.cibertec.beans.TblTipoPer;
import edu.cibertec.service.GestionConPago;
import edu.cibertec.service.GestionFacturaCompra;
import edu.cibertec.service.GestionFacturaVentas;
import edu.cibertec.service.GestionMntProveedor;
import edu.cibertec.service.GestionMntTipoCambio;
import edu.cibertec.service.GestionTblMoneda;
import edu.cibertec.service.GestionTblTipoCli;
import edu.cibertec.service.GestionTblTipoCom;
import edu.cibertec.service.GestionTblTipoPer;

@Path("/tipoget")
public class ServiciosGet {

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

	// http://localhost:8081/librosElectronicosApi/tipoget/facturaCompra/20171000/10181439373/01/SOL
	@GET
	@Path("/facturaCompra/{periodo}/{codpro}/{tipodoc}/{moneda}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ClFacturaCompra> facturCompra(@PathParam("periodo") String periodo,
			@PathParam("codpro") String codpro, @PathParam("tipodoc") String tipodoc,
			@PathParam("moneda") String moneda) {
		try {
			ArrayList<ClFacturaCompra> facCom = new GestionFacturaCompra().reporteCompras(periodo, codpro, tipodoc,
					moneda);
			return facCom;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
/*
	// http://localhost:8081/librosElectronicosApi/tipoget/usuario
	@GET
	@Path("/usuario")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> obtenerUsuario() {
		try {
			ArrayList<UsuarioDTO> usu = new GestionUsuario().validarLogueo(cod_usu, clave_usu);
			return usu;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;

	}*/


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
	
	// http://localhost:8081/librosElectronicosApi/tipoget/facturaVenta/20171000/20514917001/01/SOL
	@GET
	@Path("/facturaVenta/{periodo}/{codpro}/{tipodoc}/{moneda}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<ClFacturaVenta> facturVenta(@PathParam("periodo") String periodo,
			@PathParam("cliente") String cliente, @PathParam("tipoD") String tipoD,
			@PathParam("moneda") String moneda) {
		try {
			ArrayList<ClFacturaVenta> facCom = new GestionFacturaVentas().reporteVentas(periodo, cliente, tipoD, moneda);
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
	
	
	
}
