package br.com.vita.academy.gerenciador2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Servlet implementation class MostrarEmpresaServlet
 */
@WebServlet("/mostrarEmpresa")
public class MostrarEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer id = Integer.valueOf(request.getParameter("id"));
		
		Banco banco = new Banco();
		
		Empresa empresa = banco.buscaEmpresaId(id);
		
		request.setAttribute("empresa", empresa);
		RequestDispatcher rd = request.getRequestDispatcher("/formAlterarEmpresa.jsp");
		
		rd.forward(request, response);
	}


}
