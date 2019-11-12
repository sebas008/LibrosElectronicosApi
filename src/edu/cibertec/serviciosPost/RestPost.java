package edu.cibertec.serviciosPost;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.cibertec.beans.ClFacturaCompra;
import edu.cibertec.beans.ClFacturaVenta;
import edu.cibertec.beans.MntProveedor;
import edu.cibertec.beans.MntTipoCambio;
import edu.cibertec.beans.TblCondPago;
import edu.cibertec.beans.TblMoneda;
import edu.cibertec.beans.TblTipoCom;
import edu.cibertec.beans.TblTipoPer;
import edu.cibertec.service.GestionConPago;
import edu.cibertec.service.GestionFacturaCompra;
import edu.cibertec.service.GestionFacturaVentas;
import edu.cibertec.service.GestionMntProveedor;
import edu.cibertec.service.GestionMntTipoCambio;
import edu.cibertec.service.GestionTblMoneda;
import edu.cibertec.service.GestionTblTipoCom;
import edu.cibertec.service.GestionTblTipoPer;

@Path("/tipopost")
public class RestPost {

	// http://localhost:8081/librosElectronicosApi/tipopost/registrarMoneda
	@POST
	@Path("/registrarMoneda")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registrarMoneda(TblMoneda m) {
		System.out.println("Entrando al servicio Post-registrarMoneda()");
		try {
			new GestionTblMoneda().registrar(m);

			System.out.println("Codigo: " + m.getCodigo());
			System.out.println("Descripcion: " + m.getDescripcion());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "Registro de moneda correctamente";

	}

	// http://localhost:8081/librosElectronicosApi/tipopost/registrarCondPago
	@POST
	@Path("/registrarCondPago")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registrarCondPago(TblCondPago cp) {
		System.out.println("Entrando al servicio Post-registrarCondPago()");
		try {
			new GestionConPago().registrar(cp);

			System.out.println("Codigo: " + cp.getCodigo());
			System.out.println("Descripcion: " + cp.getDescripcion());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "Registro de condicion pago correctamente";

	}

	// http://localhost:8081/librosElectronicosApi/tipopost/registrarProveedor
	@POST
	@Path("/registrarProveedor")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registrarProveedor(MntProveedor pv) {
		System.out.println("Entrando al servicio Post-registrarProveedor()");
		try {
			new GestionMntProveedor().Registrar(pv);

			System.out.println("Codigo: " + pv.getCodigo());
			System.out.println("Descripcion: " + pv.getDescripcion());
			System.out.println("Tipo Persona: " + pv.getTipoPer());
			System.out.println("Tipo Cliente: " + pv.getTipoCli());
			System.out.println("Direccion: " + pv.getDireccion());
			System.out.println("Contacto: " + pv.getContacto());
			System.out.println("Telefono: " + pv.getTelefono());
			System.out.println("Condicion Pago: " + pv.getCondPago());
			System.out.println("Correo: " + pv.getCorreo());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "Registro de proveedor correctamente";

	}
	
	// http://localhost:8081/librosElectronicosApi/tipopost/registrarFacturaCompra
	@POST
	@Path("/registrarFacturaCompra")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registrarFacturaCompra(ClFacturaCompra fc) {
		System.out.println("Entrando al servicio Post-registrarFacturaCompra()");
		try {
			new GestionFacturaCompra().registrar(fc);

			System.out.println("Fecha Retencion: " + fc.getFechaRet());
			System.out.println("Descripcion Cond Compa: " + fc.getDesCodcom());
			System.out.println("Numero Retencion: " + fc.getNroRet());
			System.out.println("Codigo Compra: " + fc.getCodcom());
			System.out.println("Monto retencion: " + fc.getMontoRet());
			System.out.println("Periodo: " + fc.getPeriodo());
			System.out.println("Descripcion Estado: " + fc.getDes_estado());
			System.out.println("Moneda: " + fc.getMoneda());
			System.out.println("Fecha: " + fc.getFecha());
			System.out.println("Tipo Documento: " + fc.getTipoDoc());
			System.out.println("Serie Documento: " + fc.getSerieDoc());
			System.out.println("Numero Documento: " + fc.getNumDoc());
			System.out.println("Codigo Producto: " + fc.getCod_Pro());
			System.out.println("Razon Social: " + fc.getRazonS_Pro());
			System.out.println("Codigo Retencion: " + fc.getCod_Re());
			System.out.println("Descripcion Retencion: " + fc.getDes_Re());
			System.out.println("Glosario Compra: " + fc.getGlosa_Compra());
			System.out.println("Codigo Estado: " + fc.getCod_estado());
			System.out.println("Tipo Cambio: " + fc.getTipoCambio());
			System.out.println("Valor de Venta: " + fc.getValorVenta());
			System.out.println("Igv: " + fc.getIgv());
			System.out.println("Total: " + fc.getTotal());
			System.out.println("Tasa de Retencion: " + fc.getTasa_re());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "Registro de factura compra correctamente";

	}

	
	// http://localhost:8081/librosElectronicosApi/tipopost/registrarTipoPer
	@POST
	@Path("/registrarTipoPer")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registrarTipoPer(TblTipoPer tp) {
		System.out.println("Entrando al servicio Post-registrarTipoPer()");
		try {
			new GestionTblTipoPer().registrar(tp);

			System.out.println("Codigo: " + tp.getCodigo());
			System.out.println("Descripcion: " + tp.getDescripcion());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "Registro de tipo persona correctamente";

	}
	
	// http://localhost:8081/librosElectronicosApi/tipopost/registrarTipoCom
	@POST
	@Path("/registrarTipoCom")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registrarTipoCom(TblTipoCom tc) {
		System.out.println("Entrando al servicio Post-registrarTipoCom()");
		try {
			new GestionTblTipoCom().registrar(tc);

			System.out.println("Codigo: " + tc.getCodigo());
			System.out.println("Descripcion: " + tc.getDescripcion());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "Registro de tipo compra correctamente";

	}
		
	// http://localhost:8081/librosElectronicosApi/tipopost/registrarTipoCamb
	@POST
	@Path("/registrarTipoCamb")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registrarTipoCamb(MntTipoCambio ta) {
		System.out.println("Entrando al servicio Post-registrarTipoCamb()");
		try {
			new GestionMntTipoCambio().registrar(ta);

			System.out.println("Fecha: " + ta.getFecha());
			System.out.println("Venta: " + ta.getVenta());
			System.out.println("Compra: " + ta.getCompra());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "Registro de tipo cambio correctamente";

	}
	
	// http://localhost:8081/librosElectronicosApi/tipopost/registrarFacturaVenta
	@POST
	@Path("/registrarFacturaVenta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registrarFacturaVenta(ClFacturaVenta fv) {
		System.out.println("Entrando al servicio Post-registrarFacturaVenta()");
		try {
			new GestionFacturaVentas().registrar(fv);

			System.out.println("Periodo: " + fv.getPeriodo());
			System.out.println("Descripcion Estado: " + fv.getDes_estado());
			System.out.println("Moneda: " + fv.getMoneda());
			System.out.println("Fecha: " + fv.getFecha());
			System.out.println("Tipo Documento: " + fv.getTipoDoc());
			System.out.println("Serie Documento: " + fv.getSerieDoc());
			System.out.println("Numero Documento: " + fv.getNumDoc());
			System.out.println("Codigo Cliente: " + fv.getCod_Cli());
			System.out.println("Razon social Cliente: " + fv.getRazonS_Cli());
			System.out.println("Codigo Retencion: " + fv.getCod_Re());
			System.out.println("Descripcion Retencion: " + fv.getDes_Re());
			System.out.println("Glosario Venta: " + fv.getGlosa_venta());
			System.out.println("Codigo Estado: " + fv.getCod_estado());
			System.out.println("Tipo Cambio: " + fv.getTipoCambio());
			System.out.println("Valor Venta: " + fv.getValorVenta());
			System.out.println("Valor Inafecto: " + fv.getValorInafecto());
			System.out.println("Igv: " + fv.getIgv());
			System.out.println("Total: " + fv.getTotal());
			System.out.println("Tasa de Retencion: " + fv.getTasa_re());

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return "Registro de factura venta correctamente";

	}
		
}
