package br.com.vita.academy.gerenciador2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String nome = request.getParameter("nome");
		String data = request.getParameter("data");
		
		Empresa empresa = new Empresa();
		empresa.setNome(nome);
		
		try {
			empresa.setDataAbertura(simpleDateFormat.parse(data));
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Banco banco = new Banco();
		empresa.setId(banco.getEmpresas().size());
		banco.adiciona(empresa);
		
		request.setAttribute("empresa", empresa.getNome());
		response.sendRedirect("listaEmpresas");
		
		//chamar jsp
//		
//	 	request.getRequestDispatcher("/listaEmpresas").forward(request, response); //dispachador de requisão
	}

}
