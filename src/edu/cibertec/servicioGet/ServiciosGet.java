package edu.cibertec.servicioGet;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.cibertec.beans.TblCondPago;
import edu.cibertec.service.GestionConPago;

@Path("/tipoget")
public class ServiciosGet {

	//http://localhost:8081/librosElectronicosApi/tipoget/condPago
	@GET
	@Path("/condPago")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TblCondPago> obtenerCondPago() {
		System.out.println("entro condPago");
		
		List<TblCondPago> lst= new ArrayList<>();
		TblCondPago condPagoA= new TblCondPago("F030","Factura a 30 dias");
		TblCondPago condPagoB= new TblCondPago("F015","Factura a 15 dias");
		TblCondPago condPagoC= new TblCondPago("F007","Factura a 07 dias");
		lst.add(condPagoA);
		lst.add(condPagoB);
		lst.add(condPagoC);
		
	return lst;

	}	
}
