package br.com.vita.academy.gerenciador.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//O filtro serve para centralizar as requisições
@WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("MonitoramentoFIlter");
        long antes = System.currentTimeMillis();

        String acao = request.getParameter("acao");
        chain.doFilter(request, response);

        long depois = System.currentTimeMillis();

        System.out.println("Tempo de Execução da ação " + acao + " foi de: " + (depois - antes));
    }
}
