package servicio.get;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import beans.TblCondPago;

@Path("/tipoget")
public class ServiciosGet {

	//http://localhost:8080/librosElectronicosApi/tipoget/condPago
	@GET
	@Path("/condPago")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TblCondPago> listarCondPago() {
		System.out.println("inicio servicio listarCondPago()");
		
		//ini:simulando acceso a Base de datos
		List<TblCondPago> lstCond = new ArrayList<TblCondPago>();
		TblCondPago condPago = new TblCondPago("A","Grupo A");
		
		lstCond.add(condPago);

		// fin
		
		
		return lstCond;
	}	
	
	
	
}
