package edu.cibertec.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cibertec.beans.ClFacturaCompra;
import edu.cibertec.beans.ClFacturaVenta;
import edu.cibertec.beans.MntCliente;
import edu.cibertec.beans.MntProveedor;
import edu.cibertec.beans.MntTipoCambio;
import edu.cibertec.beans.TblCondPago;
import edu.cibertec.beans.TblEstadoDoc;
import edu.cibertec.beans.TblMoneda;
import edu.cibertec.beans.TblPeriodoContable;
import edu.cibertec.beans.TblTipoCli;
import edu.cibertec.beans.TblTipoCom;
import edu.cibertec.beans.TblTipoDoc;
import edu.cibertec.beans.TblTipoPer;
import edu.cibertec.beans.TblTipoPro;
import edu.cibertec.beans.TblTipoRet;
import edu.cibertec.service.GestionConPago;
import edu.cibertec.service.GestionFacturaCompra;
import edu.cibertec.service.GestionFacturaVentas;
import edu.cibertec.service.GestionMntCliente;
import edu.cibertec.service.GestionMntProveedor;
import edu.cibertec.service.GestionMntTipoCambio;
import edu.cibertec.service.GestionTblEstadoDoc;
import edu.cibertec.service.GestionTblMoneda;
import edu.cibertec.service.GestionTblPeriodoContable;
import edu.cibertec.service.GestionTblTipoCli;
import edu.cibertec.service.GestionTblTipoCom;
import edu.cibertec.service.GestionTblTipoDoc;
import edu.cibertec.service.GestionTblTipoPer;
import edu.cibertec.service.GestionTblTipoPro;
import edu.cibertec.service.GestionTblTipoRet;

/**
 * Servlet implementation class Periodo
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String opcion = request.getParameter("opcion");
		if (opcion.equals("listaPeriodo")) {
			listarPeriodo(request, response);
		} else if (opcion.equals("listaTipoCliente")) {
			listarTipoCliente(request, response);
		} else if (opcion.equals("listaTipoProveedor")) {
			listarTipoProveedor(request, response);
		} else if (opcion.equals("listaTipoPersona")) {
			listarTipoPersona(request, response);
		} else if (opcion.equals("listaTipoRetencion")) {
			listarTipoRetencion(request, response);
		} else if (opcion.equals("listaTipoCompra")) {
			listarTipoCompra(request, response);
		} else if (opcion.equals("listaTipoDocumento")) {
			listarTipoDocumento(request, response);
		} else if (opcion.equals("listaCondicionPago")) {
			listarCondicionPago(request, response);
		} else if (opcion.equals("listaEstadoDoc")) {
			listarEstadoDoc(request, response);
		} else if (opcion.equals("listaMoneda")) {
			listarMoneda(request, response);
		} else if (opcion.equals("listaTipoCambio")) {
			listarTipoCambio(request, response);
		} else if (opcion.equals("listaClientes")) {
			listarClientes(request, response);
		} else if (opcion.equals("listaProveedores")) {
			listarProveedores(request, response);
		} else if (opcion.equals("listaFacturasCompras")) {
			listarFacturasCompra(request, response);
		} else if (opcion.equals("listaFacturasVentas")) {
			listarFacturasVenta(request, response);
		} else if (opcion.equals("ReporteFacturasCompras")) {
			ReporteFacturasCompra(request, response);
		} else if (opcion.equals("ReporteFacturasVentas")) {
			ReporteFacturasVenta(request, response);
		} else if (opcion.equals("ObtenerPeriodoContable")) {
			ObtenerPeriodoContable(request, response);
		} else if (opcion.equals("ModificarPeriodoContable")) {
			ModificarPeriodoContable(request, response);
		} else if (opcion.equals("EliminarPeriodoContable")) {
			EliminarPeriodoContable(request, response);
		} else if (opcion.equals("RegistrarPeriodoContable")) {
			RegistrarPeriodoContable(request, response);
		} else if (opcion.equals("ObtenerTipoCliente")) {
			ObtenerTipoCliente(request, response);
		} else if (opcion.equals("ModificarTipoCliente")) {
			ModificarTipoCliente(request, response);
		} else if (opcion.equals("EliminarTipoCliente")) {
			EliminarTipoCliente(request, response);
		} else if (opcion.equals("RegistrarTipoCliente")) {
			RegistrarTipoCliente(request, response);
		} else if (opcion.equals("ObtenerTipoProveedor")) {
			ObtenerTipoProveedor(request, response);
		} else if (opcion.equals("ModificarTipoProveedor")) {
			ModificarTipoProveedor(request, response);
		} else if (opcion.equals("EliminarTipoProveedor")) {
			EliminarTipoProveedor(request, response);
		} else if (opcion.equals("RegistrarTipoProveedor")) {
			RegistrarTipoProveedor(request, response);
		} else if (opcion.equals("ObtenerTipoPersona")) {
			ObtenerTipoPersona(request, response);
		} else if (opcion.equals("ModificarTipoPersona")) {
			ModificarTipoPersona(request, response);
		} else if (opcion.equals("EliminarTipoPersona")) {
			EliminarTipoPersona(request, response);
		} else if (opcion.equals("RegistrarTipoPersona")) {
			RegistrarTipoPersona(request, response);
		} else if (opcion.equals("ObtenerTipoRetencion")) {
			ObtenerTipoRetencion(request, response);
		} else if (opcion.equals("ModificarTipoRetencion")) {
			ModificarTipoRetencion(request, response);
		} else if (opcion.equals("EliminarTipoRetencion")) {
			EliminarTipoRetencion(request, response);
		} else if (opcion.equals("RegistrarTipoRetencion")) {
			RegistrarTipoRetencion(request, response);
		} else if (opcion.equals("ObtenerTipoCompra")) {
			ObtenerTipoCompra(request, response);
		} else if (opcion.equals("ModificarTipoCompra")) {
			ModificarTipoCompra(request, response);
		} else if (opcion.equals("EliminarTipoCompra")) {
			EliminarTipoCompra(request, response);
		} else if (opcion.equals("RegistrarTipoCompra")) {
			RegistrarTipoCompra(request, response);
		} else if (opcion.equals("ObtenerTipoDocumento")) {
			ObtenerTipoDocumento(request, response);
		} else if (opcion.equals("ModificarTipoDocumento")) {
			ModificarTipoDocumento(request, response);
		} else if (opcion.equals("EliminarTipoDocumento")) {
			EliminarTipoDocumento(request, response);
		} else if (opcion.equals("RegistrarTipoDocumento")) {
			RegistrarTipoDocumento(request, response);
		} else if (opcion.equals("ObtenerCondicionPago")) {
			ObtenerCondicionPago(request, response);
		} else if (opcion.equals("ModificarCondicionPago")) {
			ModificarCondicionPago(request, response);
		} else if (opcion.equals("EliminarCondicionPago")) {
			EliminarCondicionPago(request, response);
		} else if (opcion.equals("RegistrarCondicionPago")) {
			RegistrarCondicionPago(request, response);
		} else if (opcion.equals("ObtenerEstadoDoc")) {
			ObtenerEstadoDoc(request, response);
		} else if (opcion.equals("ModificarEstadoDoc")) {
			ModificarEstadoDoc(request, response);
		} else if (opcion.equals("EliminarEstadoDoc")) {
			EliminarEstadoDoc(request, response);
		} else if (opcion.equals("RegistrarEstadoDoc")) {
			RegistrarEstadoDoc(request, response);
		} else if (opcion.equals("ObtenerMoneda")) {
			ObtenerMoneda(request, response);
		} else if (opcion.equals("ModificarMoneda")) {
			ModificarMoneda(request, response);
		} else if (opcion.equals("EliminarMoneda")) {
			EliminarMoneda(request, response);
		} else if (opcion.equals("RegistrarMoneda")) {
			RegistrarMoneda(request, response);
		} else if (opcion.equals("ObtenerTipoCambio")) {
			ObtenerTipoCambio(request, response);
		} else if (opcion.equals("ModificarTipoCambio")) {
			ModificarTipoCambio(request, response);
		} else if (opcion.equals("EliminarTipoCambio")) {
			EliminarTipoCambio(request, response);
		} else if (opcion.equals("RegistrarTipoCambio")) {
			RegistrarTipoCambio(request, response);
		} else if (opcion.equals("ObtenerCliente")) {
			ObtenerCliente(request, response);
		} else if (opcion.equals("ModificarCliente")) {
			ModificarCliente(request, response);
		} else if (opcion.equals("EliminarCliente")) {
			EliminarCliente(request, response);
		} else if (opcion.equals("RegistrarCliente")) {
			RegistrarCliente(request, response);
		} else if (opcion.equals("ObtenerProveedor")) {
			ObtenerProveedor(request, response);
		} else if (opcion.equals("ModificarProveedor")) {
			ModificarProveedor(request, response);
		} else if (opcion.equals("EliminarProveedor")) {
			EliminarProveedor(request, response);
		} else if (opcion.equals("RegistrarProveedor")) {
			RegistrarProveedor(request, response);
		} else if (opcion.equals("ObtenerFacturaCompra")) {
			ObtenerFacturaCompra(request, response);
		} else if (opcion.equals("ModificarFacturaCompra")) {
			ModificarFacturaCompra(request, response);
		} else if (opcion.equals("EliminarFacturaCompra")) {
			EliminarFacturaCompra(request, response);
		} else if (opcion.equals("RegistrarFacturaCompra")) {
			RegistrarFacturaCompra(request, response);
		} else if (opcion.equals("ObtenerFacturaVenta")) {
			ObtenerFacturaVenta(request, response);
		} else if (opcion.equals("ModificarFacturaVenta")) {
			ModificarFacturaVenta(request, response);
		} else if (opcion.equals("EliminarFacturaVenta")) {
			EliminarFacturaVenta(request, response);
		} else if (opcion.equals("RegistrarFacturaVenta")) {
			RegistrarFacturaVenta(request, response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

	// PERIODO CONTABLE:
	// **********************************************************************************************************
	void listarPeriodo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionTblPeriodoContable objPeriodo = new GestionTblPeriodoContable();
		ArrayList<TblPeriodoContable> lista = objPeriodo.lista();
		HttpSession sesion = request.getSession();

		sesion.setAttribute("listadoPeriodo", lista);
		request.getRequestDispatcher("/SUNAT_Periodo_Contable.jsp").forward(request, response);
	}

	void ObtenerPeriodoContable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblPeriodoContable gp = new GestionTblPeriodoContable();
		TblPeriodoContable objPeriodo = gp.consultaPeriodo(codigo);

		request.setAttribute("objPeriodo", objPeriodo);
		request.getRequestDispatcher("/Modificar_PeriodoContable.jsp").forward(request, response);

	}

	void ModificarPeriodoContable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TblPeriodoContable p = new TblPeriodoContable();
		int cantidad = 0;
		GestionTblPeriodoContable gp = new GestionTblPeriodoContable();
		p.setCodPerdiodo(request.getParameter("txtCodigo"));
		p.setDesPeriodo(request.getParameter("txtNombre"));
		cantidad = gp.actualizar(p);
		ArrayList<TblPeriodoContable> listap = gp.lista();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoPeriodo", listap);
		request.getRequestDispatcher("/SUNAT_Periodo_Contable.jsp").forward(request, response);
	}

	void EliminarPeriodoContable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblPeriodoContable gp = new GestionTblPeriodoContable();
		gp.eliminar(codigo);
		ArrayList<TblPeriodoContable> listap = gp.lista();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoPeriodo", listap);
		request.getRequestDispatcher("/SUNAT_Periodo_Contable.jsp").forward(request, response);
	}

	void RegistrarPeriodoContable(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		TblPeriodoContable p= new TblPeriodoContable();
		int cantidad=0;
		GestionTblPeriodoContable gp= new GestionTblPeriodoContable();
		
		p.setCodPerdiodo(request.getParameter("txtCodigo"));
		p.setDesPeriodo(request.getParameter("txtDescripcion"));
		
		cantidad=gp.registrar(p);
		if(cantidad>0){
			request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{
			request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_PeriodoContable.jsp").forward(request,response);
		
	}

	// TIPO CLIENTE:
	// **********************************************************************************************************
	void listarTipoCliente(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		GestionTblTipoCli objCli = new GestionTblTipoCli();
		ArrayList<TblTipoCli> lista = objCli.listado();
		HttpSession sesion = request.getSession();

		sesion.setAttribute("listadoTipoCliente", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Cliente.jsp").forward(request, response);
	}

	void ObtenerTipoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoCli gp = new GestionTblTipoCli();
		TblTipoCli objeto = gp.buscarDes(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_TipoCliente.jsp").forward(request, response);

	}

	void ModificarTipoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblTipoCli p = new TblTipoCli();
		int cantidad = 0;
		GestionTblTipoCli gp = new GestionTblTipoCli();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtNombre"));
		cantidad = gp.actualizar(p);
		ArrayList<TblTipoCli> listap = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoCliente", listap);
		request.getRequestDispatcher("/SUNAT_Tipo_Cliente.jsp").forward(request, response);
	}

	void EliminarTipoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoCli gp = new GestionTblTipoCli();
		gp.eliminar(codigo);
		ArrayList<TblTipoCli> listap = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoCliente", listap);
		request.getRequestDispatcher("/SUNAT_Tipo_Cliente.jsp").forward(request, response);
	}

	void RegistrarTipoCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TblTipoCli p= new TblTipoCli();
		int cantidad=0;
		GestionTblTipoCli gp= new GestionTblTipoCli();
		
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		
		cantidad=gp.registrar(p);
		if(cantidad>0){
			request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{
			request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_TipoCliente.jsp").forward(request,response);
		
	}

	
	// TIPO PROVEEDOR:
	// **********************************************************************************************************
	void listarTipoProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionTblTipoPro objeto = new GestionTblTipoPro();
		ArrayList<TblTipoPro> lista = objeto.listado();
		HttpSession sesion = request.getSession();

		sesion.setAttribute("listadoTipoProveedor", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Proveedor.jsp").forward(request, response);
	}

	void ObtenerTipoProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoPro gp = new GestionTblTipoPro();
		TblTipoPro objeto = gp.obtener(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_TipoProveedor.jsp").forward(request, response);

	}

	void ModificarTipoProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblTipoPro p = new TblTipoPro();
		int cantidad = 0;
		GestionTblTipoPro gp = new GestionTblTipoPro();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtNombre"));
		cantidad = gp.actualizar(p);
		ArrayList<TblTipoPro> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoProveedor", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Proveedor.jsp").forward(request, response);
	}

	void EliminarTipoProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoPro gp = new GestionTblTipoPro();
		gp.eliminar(codigo);
		ArrayList<TblTipoPro> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoProveedor", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Proveedor.jsp").forward(request, response);
	}

	void RegistrarTipoProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TblTipoPro p= new TblTipoPro();
		int cantidad=0;
		GestionTblTipoPro gp = new GestionTblTipoPro();
		
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		
		cantidad=gp.registrar(p);
		if(cantidad>0){
			request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{
			request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/NuevoTipoProveedor.jsp").forward(request,response);
		
	}

	// TIPO PERSONA:
	// **********************************************************************************************************
	void listarTipoPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionTblTipoPer objeto = new GestionTblTipoPer();
		ArrayList<TblTipoPer> lista = objeto.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoPersona", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Persona.jsp").forward(request, response);
	}
	
	void ObtenerTipoPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoPer gp = new GestionTblTipoPer();
		TblTipoPer objeto = gp.obtener(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_TipoPersona.jsp").forward(request, response);
	}

	void ModificarTipoPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblTipoPer p = new TblTipoPer();
		int cantidad = 0;
		GestionTblTipoPer gp = new GestionTblTipoPer();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtNombre"));
		cantidad = gp.actualizar(p);
		ArrayList<TblTipoPer> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoPersona", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Persona.jsp").forward(request, response);
	}

	void EliminarTipoPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoPer gp = new GestionTblTipoPer();
		gp.eliminar(codigo);
		ArrayList<TblTipoPer> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoPersona", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Persona.jsp").forward(request, response);
	}

	void RegistrarTipoPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblTipoPer p= new TblTipoPer();
		int cantidad=0;
		GestionTblTipoPer gp = new GestionTblTipoPer();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		cantidad=gp.registrar(p);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_TipoPersona.jsp").forward(request,response);
		
	}
	

	// TIPO RETENCION:
	// **********************************************************************************************************
	void listarTipoRetencion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionTblTipoRet objeto = new GestionTblTipoRet();
		ArrayList<TblTipoRet> lista = objeto.listado();
		HttpSession sesion = request.getSession();

		sesion.setAttribute("listadoTipoRetencion", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Retencion.jsp").forward(request, response);
	}
	
	void ObtenerTipoRetencion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoRet gp = new GestionTblTipoRet();
		TblTipoRet objeto = gp.obtener(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_TipoRetencion.jsp").forward(request, response);
	}

	void ModificarTipoRetencion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblTipoRet p = new TblTipoRet();
		int cantidad = 0;
		int tasa = Integer.parseInt(request.getParameter("txtTasa"));
		double valor = Double.parseDouble(request.getParameter("txtValor"));
		GestionTblTipoRet gp = new GestionTblTipoRet();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtNombre"));
		p.setTasa(tasa);
		p.setValor(valor);
		cantidad = gp.actualizar(p);
		ArrayList<TblTipoRet> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoRetencion", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Retencion.jsp").forward(request, response);
	}

	void EliminarTipoRetencion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoRet gp = new GestionTblTipoRet();
		gp.eliminar(codigo);
		ArrayList<TblTipoRet> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoRetencion", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Retencion.jsp").forward(request, response);
	}

	void RegistrarTipoRetencion(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblTipoRet p= new TblTipoRet();
		int cantidad=0;
		int tasa = Integer.parseInt(request.getParameter("txtTasa"));
		double valor = Double.parseDouble(request.getParameter("txtValor"));
		GestionTblTipoRet gp = new GestionTblTipoRet();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		p.setTasa(tasa);
		p.setValor(valor);
		cantidad=gp.registrar(p);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_TipoRetencion.jsp").forward(request,response);
		
	}

	// TIPO COMPRA:
	// **********************************************************************************************************
	void listarTipoCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionTblTipoCom objeto = new GestionTblTipoCom();
		ArrayList<TblTipoCom> lista = objeto.listado();
		HttpSession sesion = request.getSession();

		sesion.setAttribute("listadoTipoCompra", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Compra.jsp").forward(request, response);
	}
	
	void ObtenerTipoCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoCom gp = new GestionTblTipoCom();
		TblTipoCom objeto = gp.obtener(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_TipoCompra.jsp").forward(request, response);
	}

	void ModificarTipoCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblTipoCom p = new TblTipoCom();
		int cantidad = 0;
		GestionTblTipoCom gp = new GestionTblTipoCom();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtNombre"));
		cantidad = gp.actualizar(p);
		ArrayList<TblTipoCom> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoCompra", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Compra.jsp").forward(request, response);
	}

	void EliminarTipoCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoCom gp = new GestionTblTipoCom();
		gp.eliminar(codigo);
		ArrayList<TblTipoCom> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoCompra", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Compra.jsp").forward(request, response);
	}

	void RegistrarTipoCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblTipoCom p= new TblTipoCom();
		int cantidad=0;
		GestionTblTipoCom gp = new GestionTblTipoCom();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		cantidad=gp.registrar(p);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_TipoCompra.jsp").forward(request,response);
		
	}


	// TIPO DOCUMENTO:
	// **********************************************************************************************************
	void listarTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionTblTipoDoc objeto = new GestionTblTipoDoc();
		ArrayList<TblTipoDoc> lista = objeto.listado();
		HttpSession sesion = request.getSession();

		sesion.setAttribute("listadoTipoDocumento", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Documento.jsp").forward(request, response);
	}

	void ObtenerTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoDoc gp = new GestionTblTipoDoc();
		TblTipoDoc objeto = gp.obtener(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_TipoDocumento.jsp").forward(request, response);
	}

	void ModificarTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblTipoDoc p = new TblTipoDoc();
		int cantidad = 0;
		GestionTblTipoDoc gp = new GestionTblTipoDoc();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtNombre"));
		cantidad = gp.actualizar(p);
		ArrayList<TblTipoDoc> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoDocumento", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Documento.jsp").forward(request, response);
	}

	void EliminarTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblTipoDoc gp = new GestionTblTipoDoc();
		gp.eliminar(codigo);
		ArrayList<TblTipoDoc> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoDocumento", lista);
		request.getRequestDispatcher("/SUNAT_Tipo_Documento.jsp").forward(request, response);
	}

	void RegistrarTipoDocumento(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblTipoDoc p= new TblTipoDoc();
		int cantidad=0;
		GestionTblTipoDoc gp = new GestionTblTipoDoc();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		cantidad=gp.registrar(p);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_TipoDocumento.jsp").forward(request,response);
		
	}
	
	// CONDICION DE PAGO:
	// **********************************************************************************************************
	void listarCondicionPago(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionConPago objeto = new GestionConPago();
		ArrayList<TblCondPago> lista = objeto.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoCondicionPago", lista);
		request.getRequestDispatcher("/SUNAT_Condicion_Pago.jsp").forward(request, response);
	}
	
	void ObtenerCondicionPago(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionConPago gp = new GestionConPago();
		TblCondPago objeto = gp.obtener(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_CondicionPago.jsp").forward(request, response);
	}

	void ModificarCondicionPago(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblCondPago p = new TblCondPago();
		int cantidad = 0;
		GestionConPago gp = new GestionConPago();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtNombre"));
		cantidad = gp.actualizar(p);
		ArrayList<TblCondPago> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoCondicionPago", lista);
		request.getRequestDispatcher("/SUNAT_Condicion_Pago.jsp").forward(request, response);
	}

	void EliminarCondicionPago(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionConPago gp = new GestionConPago();
		gp.eliminar(codigo);
		ArrayList<TblCondPago> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoCondicionPago", lista);
		request.getRequestDispatcher("/SUNAT_Condicion_Pago.jsp").forward(request, response);
	}

	void RegistrarCondicionPago(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblCondPago p= new TblCondPago();
		int cantidad=0;
		GestionConPago gp = new GestionConPago();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		cantidad=gp.registrar(p);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_CondicionPago.jsp").forward(request,response);
		
	}
	
	// ESTADO DOCUMENTO:
	// **********************************************************************************************************
	void listarEstadoDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionTblEstadoDoc objeto = new GestionTblEstadoDoc();
		ArrayList<TblEstadoDoc> lista = objeto.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoEstadoDoc", lista);
		request.getRequestDispatcher("/SUNAT_Estado_Documento.jsp").forward(request, response);
	}
	
	void ObtenerEstadoDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		GestionTblEstadoDoc gp = new GestionTblEstadoDoc();
		TblEstadoDoc objeto = gp.obtener(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_EstadoDocumento.jsp").forward(request, response);
	}

	void ModificarEstadoDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblEstadoDoc p = new TblEstadoDoc();
		int cantidad = 0;
		int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
		GestionTblEstadoDoc gp = new GestionTblEstadoDoc();
		p.setCodigo(codigo);
		p.setDescripcion(request.getParameter("txtNombre"));
		cantidad = gp.actualizar(p);
		ArrayList<TblEstadoDoc> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoEstadoDoc", lista);
		request.getRequestDispatcher("/SUNAT_Estado_Documento.jsp").forward(request, response);
	}

	void EliminarEstadoDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));
		GestionTblEstadoDoc gp = new GestionTblEstadoDoc();
		gp.eliminar(codigo);
		ArrayList<TblEstadoDoc> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoEstadoDoc", lista);
		request.getRequestDispatcher("/SUNAT_Estado_Documento.jsp").forward(request, response);
	}

	void RegistrarEstadoDoc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblEstadoDoc p= new TblEstadoDoc();
		int cantidad=0;
		int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
		GestionTblEstadoDoc gp = new GestionTblEstadoDoc();
		p.setCodigo(codigo);
		p.setDescripcion(request.getParameter("txtDescripcion"));
		cantidad=gp.registrar(p);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_EstadoDocumento.jsp").forward(request,response);
		
	}

	
	// MONEDA:
	// **********************************************************************************************************
	void listarMoneda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionTblMoneda objeto = new GestionTblMoneda();
		ArrayList<TblMoneda> lista = objeto.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoMoneda", lista);
		request.getRequestDispatcher("/SUNAT_Moneda.jsp").forward(request, response);
	}
	
	void ObtenerMoneda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblMoneda gp = new GestionTblMoneda();
		TblMoneda objeto = gp.obtener(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_Moneda.jsp").forward(request, response);
	}

	void ModificarMoneda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblMoneda p = new TblMoneda();
		int cantidad = 0;
		GestionTblMoneda gp = new GestionTblMoneda();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtNombre"));
		cantidad = gp.actualizar(p);
		ArrayList<TblMoneda> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoMoneda", lista);
		request.getRequestDispatcher("/SUNAT_Moneda.jsp").forward(request, response);
	}

	void EliminarMoneda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionTblMoneda gp = new GestionTblMoneda();
		gp.eliminar(codigo);
		ArrayList<TblMoneda> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoMoneda", lista);
		request.getRequestDispatcher("/SUNAT_Moneda.jsp").forward(request, response);
	}

	void RegistrarMoneda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TblMoneda p= new TblMoneda();
		int cantidad=0;
		GestionTblMoneda gp = new GestionTblMoneda();
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		cantidad=gp.registrar(p);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_Moneda.jsp").forward(request,response);
		
	}
	
	
	// TIPO CAMBIO:
	// **********************************************************************************************************
	void listarTipoCambio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionMntTipoCambio objeto = new GestionMntTipoCambio();
		ArrayList<MntTipoCambio> lista = objeto.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoCambio", lista);
		request.getRequestDispatcher("/SUNAT_Mntm_Tipo_Cambio.jsp").forward(request, response);
	}
	
	void ObtenerTipoCambio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionMntTipoCambio gp = new GestionMntTipoCambio();
		MntTipoCambio objeto = gp.obtener(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_TipoCambio.jsp").forward(request, response);
	}

	void ModificarTipoCambio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MntTipoCambio p = new MntTipoCambio();
		int cantidad = 0;
		double compra = Double.parseDouble(request.getParameter("txtCompra"));
		double venta = Double.parseDouble(request.getParameter("txtVenta"));
		GestionMntTipoCambio gp = new GestionMntTipoCambio();
		p.setFecha(request.getParameter("txtCodigo"));
		p.setCompra(compra);
		p.setVenta(venta);
		cantidad = gp.actualizar(p);
		ArrayList<MntTipoCambio> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoCambio", lista);
		request.getRequestDispatcher("/SUNAT_Mntm_Tipo_Cambio.jsp").forward(request, response);
	}

	void EliminarTipoCambio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionMntTipoCambio gp = new GestionMntTipoCambio();
		gp.eliminar(codigo);
		ArrayList<MntTipoCambio> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoTipoCambio", lista);
		request.getRequestDispatcher("/SUNAT_Mntm_Tipo_Cambio.jsp").forward(request, response);
	}

	void RegistrarTipoCambio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MntTipoCambio p= new MntTipoCambio();
		int cantidad=0;
		double compra = Double.parseDouble(request.getParameter("txtCompra"));
		double venta = Double.parseDouble(request.getParameter("txtVenta"));
		GestionMntTipoCambio gp = new GestionMntTipoCambio();
		p.setFecha(request.getParameter("txtCodigo"));
		p.setCompra(compra);
		p.setVenta(venta);
		cantidad=gp.registrar(p);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_TipoCambio.jsp").forward(request,response);
		
	}
	
	// CLIENTE:
	// **********************************************************************************************************
	void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionMntCliente objeto = new GestionMntCliente();
		ArrayList<MntCliente> lista = objeto.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoCliente", lista);
		request.getRequestDispatcher("/SUNAT_Mntm_Cliente.jsp").forward(request, response);
	}

	void ObtenerCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionMntCliente gp = new GestionMntCliente();
		MntCliente objeto = gp.obtener(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_Cliente.jsp").forward(request, response);
	}

	void ModificarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MntCliente p = new MntCliente();
		int cantidad = 0;
		GestionMntCliente gp = new GestionMntCliente();
		p.setTipoPer(request.getParameter("txtTipoPer"));
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		p.setDireccion(request.getParameter("txtDireccion"));
		p.setTipoCli(request.getParameter("txtTipoCli"));
		p.setContacto(request.getParameter("txtContacto"));
		p.setTelefono(request.getParameter("txtTelefono"));
		p.setCondPago(request.getParameter("txtCondPago"));
		p.setCorreo(request.getParameter("txtCorreo"));
		cantidad = gp.actualizar(p);
		ArrayList<MntCliente> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoCliente", lista);
		request.getRequestDispatcher("/SUNAT_Mntm_Cliente.jsp").forward(request, response);
	}

	void EliminarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionMntCliente gp = new GestionMntCliente();
		gp.eliminar(codigo);
		ArrayList<MntCliente> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoCliente", lista);
		request.getRequestDispatcher("/SUNAT_Mntm_Cliente.jsp").forward(request, response);
	}

	void RegistrarCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MntCliente p= new MntCliente();
		int cantidad=0;
		GestionMntCliente gp = new GestionMntCliente();
		p.setTipoPer(request.getParameter("txtTipoPer"));
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		p.setDireccion(request.getParameter("txtDireccion"));
		p.setTipoCli(request.getParameter("txtTipoCli"));
		p.setContacto(request.getParameter("txtContacto"));
		p.setTelefono(request.getParameter("txtTelefono"));
		p.setCondPago(request.getParameter("txtCondPago"));
		p.setCorreo(request.getParameter("txtCorreo"));
		cantidad=gp.Registrar(p);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_Cliente.jsp").forward(request,response);
		
	}
	
	// PROVEEDOR:
	// **********************************************************************************************************
	void listarProveedores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionMntProveedor objeto = new GestionMntProveedor();
		ArrayList<MntProveedor> lista = objeto.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoProveedor", lista);
		request.getRequestDispatcher("/SUNAT_Mntm_Proveedores.jsp").forward(request, response);
	}
	
	void ObtenerProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionMntProveedor gp = new GestionMntProveedor();
		MntProveedor objeto = gp.obtener(codigo);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_Proveedor.jsp").forward(request, response);
	}

	void ModificarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MntProveedor p = new MntProveedor();
		int cantidad = 0;
		GestionMntProveedor gp = new GestionMntProveedor();
		p.setTipoPer(request.getParameter("txtTipoPer"));
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		p.setDireccion(request.getParameter("txtDireccion"));
		p.setTipoCli(request.getParameter("txtTipoCli"));
		p.setContacto(request.getParameter("txtContacto"));
		p.setTelefono(request.getParameter("txtTelefono"));
		p.setCondPago(request.getParameter("txtCondPago"));
		p.setCorreo(request.getParameter("txtCorreo"));
		cantidad = gp.actualizar(p);
		ArrayList<MntProveedor> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoProveedor", lista);
		request.getRequestDispatcher("/SUNAT_Mntm_Proveedores.jsp").forward(request, response);
	}

	void EliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		GestionMntProveedor gp = new GestionMntProveedor();
		gp.eliminar(codigo);
		ArrayList<MntProveedor> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoProveedor", lista);
		request.getRequestDispatcher("/SUNAT_Mntm_Proveedores.jsp").forward(request, response);
	}

	void RegistrarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MntProveedor p= new MntProveedor();
		int cantidad=0;
		GestionMntProveedor gp = new GestionMntProveedor();
		p.setTipoPer(request.getParameter("txtTipoPer"));
		p.setCodigo(request.getParameter("txtCodigo"));
		p.setDescripcion(request.getParameter("txtDescripcion"));
		p.setDireccion(request.getParameter("txtDireccion"));
		p.setTipoCli(request.getParameter("txtTipoCli"));
		p.setContacto(request.getParameter("txtContacto"));
		p.setTelefono(request.getParameter("txtTelefono"));
		p.setCondPago(request.getParameter("txtCondPago"));
		p.setCorreo(request.getParameter("txtCorreo"));
		cantidad=gp.Registrar(p);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nuevo_Proveedor.jsp").forward(request,response);
		
	}

	// FACTURAS COMPRAS
	// **********************************************************************************************************
	void listarFacturasCompra(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		GestionFacturaCompra objeto = new GestionFacturaCompra();
		ArrayList<ClFacturaCompra> lista = objeto.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoFacturaCompra", lista);
		request.getRequestDispatcher("/SUNAT_Registro_Compras.jsp").forward(request, response);
	}
	
	void ObtenerFacturaCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String serie = request.getParameter("serie");
		String numero = request.getParameter("numero");
		GestionFacturaCompra gp = new GestionFacturaCompra();
		ClFacturaCompra objeto = gp.obtener(codigo, serie, numero);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_FacturaCompra.jsp").forward(request, response);
	}

	void ModificarFacturaCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClFacturaCompra f = new ClFacturaCompra();
		int cantidad = 0;
		double tipocambio = Double.parseDouble(request.getParameter("txtTipoCambio"));
		double valorventa = Double.parseDouble(request.getParameter("txtValorVenta"));
		double inafecto = Double.parseDouble(request.getParameter("txtInafecto"));
		double igv = Double.parseDouble(request.getParameter("txtIgv"));
		double total = Double.parseDouble(request.getParameter("txtTotal"));
		int tasa = Integer.parseInt(request.getParameter("txtTasa"));
		double montoret = Double.parseDouble(request.getParameter("txtMontoRet"));
		
		GestionFacturaCompra gp = new GestionFacturaCompra();
		f.setPeriodo(request.getParameter("txtPeriodo"));
		f.setMoneda(request.getParameter("txtMoneda"));
		f.setFecha(request.getParameter("txtFecha"));
		f.setTipoCambio(tipocambio);
		f.setTipoDoc(request.getParameter("txtTipoDoc"));
		f.setSerieDoc(request.getParameter("txtSerie"));
		f.setNumDoc(request.getParameter("txtNumero"));
		f.setCod_Pro(request.getParameter("txtCodigo"));
		f.setRazonS_Pro(request.getParameter("txtDescripcion"));
		f.setValorVenta(valorventa);
		f.setValorInafecto(inafecto);
		f.setIgv(igv);
		f.setTotal(total);
		f.setCod_Re(request.getParameter("txtCodRet"));
		f.setDes_Re(request.getParameter("txtDesRet"));
		f.setTasa_re(tasa);
		f.setFechaRet(request.getParameter("txtFechaRet"));
		f.setNroRet(request.getParameter("txtNroRet"));
		f.setMontoRet(montoret);
		f.setGlosa_Compra(request.getParameter("txtGlosa"));
		f.setCodcom(request.getParameter("txtCodCom"));
		f.setCod_estado(request.getParameter("txtEstado"));
		cantidad = gp.actualizar(f);
		ArrayList<ClFacturaCompra> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoFacturaCompra", lista);
		request.getRequestDispatcher("/SUNAT_Registro_Compras.jsp").forward(request, response);
	}

	void EliminarFacturaCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String serie = request.getParameter("serie");
		String numero = request.getParameter("numero");
		GestionFacturaCompra gp = new GestionFacturaCompra();
		gp.eliminar(codigo, serie, numero);
		ArrayList<ClFacturaCompra> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoFacturaCompra", lista);
		request.getRequestDispatcher("/SUNAT_Registro_Compras.jsp").forward(request, response);
	}

	void RegistrarFacturaCompra(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClFacturaCompra f= new ClFacturaCompra();
		int cantidad=0;
		double tipocambio = Double.parseDouble(request.getParameter("txtTipoCambio"));
		double valorventa = Double.parseDouble(request.getParameter("txtValorVenta"));
		double inafecto = Double.parseDouble(request.getParameter("txtInafecto"));
		double igv = Double.parseDouble(request.getParameter("txtIgv"));
		double total = Double.parseDouble(request.getParameter("txtTotal"));
		int tasa = Integer.parseInt(request.getParameter("txtTasa"));
		double montoret = Double.parseDouble(request.getParameter("txtMontoRet"));
		GestionFacturaCompra gp = new GestionFacturaCompra();
		f.setPeriodo(request.getParameter("txtPeriodo"));
		f.setMoneda(request.getParameter("txtMoneda"));
		f.setFecha(request.getParameter("txtFecha"));
		f.setTipoCambio(tipocambio);
		f.setTipoDoc(request.getParameter("txtTipoDoc"));
		f.setSerieDoc(request.getParameter("txtSerie"));
		f.setNumDoc(request.getParameter("txtNumero"));
		f.setCod_Pro(request.getParameter("txtCodigo"));
		f.setRazonS_Pro(request.getParameter("txtDescripcion"));
		f.setValorVenta(valorventa);
		f.setValorInafecto(inafecto);
		f.setIgv(igv);
		f.setTotal(total);
		f.setCod_Re(request.getParameter("txtCodRet"));
		f.setDes_Re(request.getParameter("txtDesRet"));
		f.setTasa_re(tasa);
		f.setFechaRet(request.getParameter("txtFechaRet"));
		f.setNroRet(request.getParameter("txtNroRet"));
		f.setMontoRet(montoret);
		f.setGlosa_Compra(request.getParameter("txtGlosa"));
		f.setCodcom(request.getParameter("txtCodCom"));
		f.setCod_estado(request.getParameter("txtEstado"));
		cantidad=gp.registrar(f);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nueva_FacturaCompra.jsp").forward(request,response);
		
	}

	void ReporteFacturasCompra(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String periodo = request.getParameter("Periodo");
		String codpro = request.getParameter("cpdProveedor");
		String tipodoc = request.getParameter("tipoDoc");
		String moneda = request.getParameter("moneda");

		// si es igual a vacio, se convierte a null.
		// se usa if/else, por que sólo quiero que evalue cuando el valor no es null
		// si omito eso, arroja error, ya que el .isEmpty() no puede comparar un null
		if (periodo == null) {
		} else if (periodo.isEmpty()) {
			periodo = null;
		}
		if (codpro == null) {
		} else if (codpro.isEmpty()) {
			codpro = null;
		}
		if (tipodoc == null) {
		} else if (tipodoc.isEmpty()) {
			tipodoc = null;
		}
		if (moneda == null) {
		} else if (moneda.isEmpty()) {
			moneda = null;
		}

		GestionFacturaCompra objeto = new GestionFacturaCompra();
		ArrayList<ClFacturaCompra> lista = objeto.reporteCompras(periodo, codpro, tipodoc, moneda);
		sesion.setAttribute("ReporteCompras", lista);
		request.getRequestDispatcher("/SUNAT_Reporte_Compras.jsp").forward(request, response);
	}

	
	// FACTURAS VENTA:
	// **********************************************************************************************************
	void listarFacturasVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GestionFacturaVentas objeto = new GestionFacturaVentas();
		ArrayList<ClFacturaVenta> lista = objeto.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoFacturaVenta", lista);
		request.getRequestDispatcher("/SUNAT_Registro_Ventas.jsp").forward(request, response);
	}


	void ObtenerFacturaVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String serie = request.getParameter("serie");
		String numero = request.getParameter("numero");
		GestionFacturaVentas gp = new GestionFacturaVentas();
		ClFacturaVenta objeto = gp.obtener(codigo, serie, numero);
		request.setAttribute("objeto", objeto);
		request.getRequestDispatcher("/Modificar_FacturaVenta.jsp").forward(request, response);
	}

	void ModificarFacturaVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClFacturaVenta f = new ClFacturaVenta();
		int cantidad = 0;
		double tipocambio = Double.parseDouble(request.getParameter("txtTipoCambio"));
		double valorventa = Double.parseDouble(request.getParameter("txtValorVenta"));
		double inafecto = Double.parseDouble(request.getParameter("txtInafecto"));
		double igv = Double.parseDouble(request.getParameter("txtIgv"));
		double total = Double.parseDouble(request.getParameter("txtTotal"));
		int tasa = Integer.parseInt(request.getParameter("txtTasa"));
		
		GestionFacturaVentas gp = new GestionFacturaVentas();
		f.setPeriodo(request.getParameter("txtPeriodo"));
		f.setMoneda(request.getParameter("txtMoneda"));
		f.setFecha(request.getParameter("txtFecha"));
		f.setTipoCambio(tipocambio);
		f.setTipoDoc(request.getParameter("txtTipoDoc"));
		f.setSerieDoc(request.getParameter("txtSerie"));
		f.setNumDoc(request.getParameter("txtNumero"));
		f.setCod_Cli(request.getParameter("txtCodigo"));
		f.setRazonS_Cli(request.getParameter("txtDescripcion"));
		f.setValorVenta(valorventa);
		f.setValorInafecto(inafecto);
		f.setIgv(igv);
		f.setTotal(total);
		f.setCod_Re(request.getParameter("txtCodRet"));
		f.setDes_Re(request.getParameter("txtDesRet"));
		f.setTasa_re(tasa);
		f.setGlosa_venta(request.getParameter("txtGlosa"));
		f.setCod_estado(request.getParameter("txtEstado"));
		cantidad = gp.actualizar(f);
		ArrayList<ClFacturaVenta> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoFacturaVenta", lista);
		request.getRequestDispatcher("/SUNAT_Registro_Ventas.jsp").forward(request, response);
	}

	void EliminarFacturaVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codigo = request.getParameter("codigo");
		String serie = request.getParameter("serie");
		String numero = request.getParameter("numero");
		GestionFacturaVentas gp = new GestionFacturaVentas();
		gp.eliminar(codigo, serie, numero);
		ArrayList<ClFacturaVenta> lista = gp.listado();
		HttpSession sesion = request.getSession();
		sesion.setAttribute("listadoFacturaVenta", lista);
		request.getRequestDispatcher("/SUNAT_Registro_Ventas.jsp").forward(request, response);
	}

	void RegistrarFacturaVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClFacturaVenta f= new ClFacturaVenta();
		int cantidad=0;
		double tipocambio = Double.parseDouble(request.getParameter("txtTipoCambio"));
		double valorventa = Double.parseDouble(request.getParameter("txtValorVenta"));
		double inafecto = Double.parseDouble(request.getParameter("txtInafecto"));
		double igv = Double.parseDouble(request.getParameter("txtIgv"));
		double total = Double.parseDouble(request.getParameter("txtTotal"));
		int tasa = Integer.parseInt(request.getParameter("txtTasa"));
		GestionFacturaVentas gp = new GestionFacturaVentas();
		f.setPeriodo(request.getParameter("txtPeriodo"));
		f.setMoneda(request.getParameter("txtMoneda"));
		f.setFecha(request.getParameter("txtFecha"));
		f.setTipoCambio(tipocambio);
		f.setTipoDoc(request.getParameter("txtTipoDoc"));
		f.setSerieDoc(request.getParameter("txtSerie"));
		f.setNumDoc(request.getParameter("txtNumero"));
		f.setCod_Cli(request.getParameter("txtCodigo"));
		f.setRazonS_Cli(request.getParameter("txtDescripcion"));
		f.setValorVenta(valorventa);
		f.setValorInafecto(inafecto);
		f.setIgv(igv);
		f.setTotal(total);
		f.setCod_Re(request.getParameter("txtCodRet"));
		f.setDes_Re(request.getParameter("txtDesRet"));
		f.setTasa_re(tasa);
		f.setGlosa_venta(request.getParameter("txtGlosa"));
		f.setCod_estado(request.getParameter("txtEstado"));
		cantidad=gp.registrar(f);
		if(cantidad>0){request.setAttribute("mensaje", "Se ingresaron los datos correctamente");
		}
		else{request.setAttribute("mensaje", "No se pudieron ingresar los datos");
		}
		request.getRequestDispatcher("/Nueva_FacturaVenta.jsp").forward(request,response);
		
	}
	
	void ReporteFacturasVenta(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sesion = request.getSession();

		String periodo = request.getParameter("Periodo");
		String codcli = request.getParameter("codCliente");
		String tipodoc = request.getParameter("tipoDoc");
		String moneda = request.getParameter("moneda");

		// si es igual a vacio, se convierte a null.
		// se usa if/else, por que sólo quiero que evalue cuando el valor no es null
		// si omito eso, arroja error, ya que el .isEmpty() no puede comparar un null
		if (periodo == null) {
		} else if (periodo.isEmpty()) {
			periodo = null;
		}
		if (codcli == null) {
		} else if (codcli.isEmpty()) {
			codcli = null;
		}
		if (tipodoc == null) {
		} else if (tipodoc.isEmpty()) {
			tipodoc = null;
		}
		if (moneda == null) {
		} else if (moneda.isEmpty()) {
			moneda = null;
		}

		GestionFacturaVentas objeto = new GestionFacturaVentas();
		ArrayList<ClFacturaVenta> lista = objeto.reporteVentas(periodo, codcli, tipodoc, moneda);
		sesion.setAttribute("ReporteVentas", lista);
		request.getRequestDispatcher("/SUNAT_Reporte_Ventas.jsp").forward(request, response);
	}


}
