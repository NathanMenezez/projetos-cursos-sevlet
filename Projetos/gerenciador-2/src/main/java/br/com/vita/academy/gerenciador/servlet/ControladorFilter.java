package br.com.vita.academy.gerenciador.servlet;

import br.com.vita.academy.gerenciador.acao.Acao;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//O filtro serve para centralizar as requisições
@WebFilter(urlPatterns = "/entrada")
public class ControladorFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain) throws IOException, ServletException {
        System.out.println("ControladorFilter");

        HttpServletRequest request = (HttpServletRequest)requestServlet;
        HttpServletResponse response = (HttpServletResponse) responseServlet;

        String paramAcao = request.getParameter("acao");

        String nomeDaClasse = "br.com.vita.academy.gerenciador.acao." + paramAcao;
        String nome = null;
        try {
            Class classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            nome = acao.executa(request,response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new ServletException(e);
        }


        String[] tipoEndereco = nome.split(":");
        if(tipoEndereco[0].equals("foward")){
            request.getRequestDispatcher("WEB-INF/view/"+ tipoEndereco[1]).forward(request, response);
        }else {
            response.sendRedirect(tipoEndereco[1]);
        }

    }
}
