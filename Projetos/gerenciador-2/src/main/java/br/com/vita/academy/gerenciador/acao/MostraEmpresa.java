package br.com.vita.academy.gerenciador.acao;

import br.com.vita.academy.gerenciador.modelo.Banco;
import br.com.vita.academy.gerenciador.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostraEmpresa implements Acao{
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        Integer id = Integer.valueOf(request.getParameter("id"));

        Banco banco = new Banco();

        Empresa empresa = banco.buscaEmpresaId(id);

        request.setAttribute("empresa", empresa);
        return "foward:formAlterarEmpresa.jsp";
    }
}
