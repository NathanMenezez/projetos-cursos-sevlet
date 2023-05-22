package br.com.vita.academy.gerenciador.acao;

import br.com.vita.academy.gerenciador.modelo.Banco;
import br.com.vita.academy.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListaEmpresas implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Listando Empresas");
        Banco banco = new Banco();
        List<Empresa> lista = banco.getEmpresas();

        request.setAttribute("empresas", lista);


        return "foward:listaEmpresas.jsp";
    }
}
