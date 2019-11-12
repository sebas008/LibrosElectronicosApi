package edu.cibertec.serviciosPost;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.cibertec.beans.ClFacturaCompra;
import edu.cibertec.beans.MntProveedor;
import edu.cibertec.beans.TblCondPago;
import edu.cibertec.beans.TblMoneda;
import edu.cibertec.service.GestionConPago;
import edu.cibertec.service.GestionFacturaCompra;
import edu.cibertec.service.GestionMntProveedor;
import edu.cibertec.service.GestionTblMoneda;

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

			System.out.println("Codigo" + m.getCodigo());
			System.out.println("Descripcion" + m.getDescripcion());

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

			System.out.println("Codigo" + cp.getCodigo());
			System.out.println("Descripcion" + cp.getDescripcion());

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

		return "Registro de proveedor correctamente";

	}

}
