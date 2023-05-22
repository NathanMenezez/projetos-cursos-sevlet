package br.com.vita.academy.gerenciador.servlet;

import br.com.vita.academy.gerenciador.acao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String paramAcao = request.getParameter("acao");

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
    */
    }
}
