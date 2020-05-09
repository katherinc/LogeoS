package com.katerin.controlador;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.katerin.dao.HistorialDao;
import com.katerin.dao.Usuariodao;
import com.katerin.model.TbHistorial;
import com.katerin.model.TbUsuariop;

/**
 * Servlet implementation class ServeleteUser
 */
public class ServeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServeleteUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String usu= request.getParameter("usuario");
		String contra= request.getParameter("contra");
		String cerrarSec = request.getParameter("btncerrar");
		
		if(cerrarSec!=null) {
			if(cerrarSec.equals("CERRAR")) {
		    HttpSession cerrarS =(HttpSession)request.getSession();
		    cerrarS.invalidate();
		    
		    response.sendRedirect("index.jsp");
			
			}
		
		}
		else	
		{
		
		TbUsuariop usuario = new TbUsuariop();
		Usuariodao usudao = new Usuariodao();
		
		usuario.setUsuario(usu);
		usuario.setContrasenia(contra);
		
		
		int validar = usudao.ingresoUsuario(usuario).size();
	   if (validar==1) {
		   TbHistorial histo = new TbHistorial();
		   HistorialDao histodao = new HistorialDao();
		   
		   
		   Date fecha = new Date();
		   
		   
		    histo.setFecha(fecha);
		    usuario.setIdUsuarios(usuario.getIdUsuarios());
		    histo.setTbUsuariop(usuario);
		    histodao.agregarDatosHistorial(histo);
		   
		  HttpSession seccion = request.getSession(true);//para observar quien inicia secion
		 seccion.setAttribute("usuario", usu);
		   response.sendRedirect("Principal.jsp");
	   }else {
		   System.out.println("ERROR1");
	   }
	}

	}
}
