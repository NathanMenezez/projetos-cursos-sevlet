package br.com.vita.academy.gerenciador2;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//oi
@WebServlet(urlPatterns = "/oi")
public class HelloWorldServlet extends HttpServlet{
	//Servlet é uma classe Java usada para estender as funcionalidades de um servidor.
	//req - requisisão resp - resposta
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<h1>Olá Mundo</h1>");
		out.println("</html>");
		out.println("</body>");
		System.out.println("o servlet OiMundoServlet foi chamado");
	}
}
