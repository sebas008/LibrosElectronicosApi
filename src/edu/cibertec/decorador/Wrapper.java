package edu.cibertec.decorador;

import org.displaytag.decorator.TableDecorator;

public class Wrapper extends TableDecorator {

	public String getRadio() {
		return "<input type='radio' name='rdPeridoCon'> ";
	}

	public String getModificar() {
		return "<input type='button'  value='Modificar' name='btnModificar'>";
	}
	
	
	public String getModificarPeriodoContable() {
		
		String vinculo = "<%=request.getContextPath()%>/Servlet?opcion=ObtenerPeriodoContable&codigo=<c:out value=\"${objPeriodo.codPerdiodo}\"  escapeXml=\"true\"/>";
		String imagen ="iconos/Modificar_blue36.png";
		return "<a href='"+vinculo+"'><img alt='' src='"+ imagen +"'></a>";
		//<display:column title="Modificar"><a href="<%=request.getContextPath()%>/Servlet?opcion=ObtenerPeriodoContable&codigo=<c:out value="${objPeriodo.codPerdiodo}"  escapeXml="true"/>">Modificar</a>
		
	}
}
