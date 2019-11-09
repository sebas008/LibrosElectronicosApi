package edu.cibertec.servlets;

import java.io.IOException;
import java.io.PrintWriter;




import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.cibertec.beans.UsuarioDTO;
import edu.cibertec.service.GestionUsuario;


/**
 * 
 * Servlet implementation class Demo
 */
@WebServlet("/Logueo")
public class Logueo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logueo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
		// System.out.println("Vengo del Get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		procesar(request, response);
		// System.out.println("Vengo del Post");
	}

	private void procesar(HttpServletRequest request, HttpServletResponse response) {
		// Captura los datos del formulario logueo
		String cod_usu = request.getParameter("txtUsuario");//Se recepciona lo ingresado en el input type txtUsuario de la página index.html
		String clave_usu = request.getParameter("txtClave");//Se recepciona lo ingresado en el input type txtClave de la página index.html
		GestionUsuario gu=new GestionUsuario();//SE crea un objeto Gestión usuario para invocar a la BD
		UsuarioDTO objUsuario=gu.validarLogueo(cod_usu, clave_usu);// se invoca al método que interactúa con la tabla tb_Usuarios
		request.setAttribute("cod_usu", objUsuario);
		HttpSession sesion=request.getSession();
		sesion.setAttribute("cod_usu", objUsuario);
		if (objUsuario!=null) { // si existe el usuario, abrimos la pág. principal
			//RequestDispatcher rd = request.getRequestDispatcher("/SUNAT_Principal.jsp");
			
			System.out.println("Id Session :" + request.getSession().getId());
			//System.out.println("Tiempo.... :" + request.getSession().getMaxInactiveInterval());
			
			//enviar el atributo a la pagina principal
			request.getSession().setAttribute("usu", objUsuario);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/Principal.jsp");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		} else {  // si es incorrecto, realiza una salida en el navegador
			PrintWriter out = null;
			try {
				out = response.getWriter();
				// -- genera una pàgina web
				out.println("<html>");
				out.println("<head><title>Error</title></head>");
				out.println("<body>");
				out.println("<h1>¡Hacker!!!</h1>");
				out.println("<img alt=\"\" src=\"./img/error.png\"><br>");
				out.println("<a href=\"index.html\">reintentar</a><br>");
				out.println("</body></html>");
			} catch (IOException e) {
				System.out.println("Error al escribir!!");
			} finally {
				out.close();
			}
		}
	}
}
