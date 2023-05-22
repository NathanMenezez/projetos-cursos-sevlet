package br.com.vita.academy.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//O filtro serve para centralizar as requisições
@WebFilter(urlPatterns = "/entrada")
public class AutorizacaoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest requestServlet, ServletResponse responseServlet, FilterChain chain) throws IOException, ServletException {
        System.out.println("AutorizacaoFIlter");

        HttpServletRequest request = (HttpServletRequest)requestServlet;
        HttpServletResponse response = (HttpServletResponse) responseServlet;

        String paramAcao = request.getParameter("acao");
        HttpSession session = request.getSession();
        boolean usuarioNaoEstaLogado = (session.getAttribute("usuarioLogado") == null);
        boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

        if(ehUmaAcaoProtegida && usuarioNaoEstaLogado){
            response.sendRedirect("entrada?acao=LoginForm");
            return;
        }

        chain.doFilter(request, response);
    }
}
