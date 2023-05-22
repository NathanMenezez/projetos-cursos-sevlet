package br.com.vita.academy.gerenciador.acao;

import br.com.vita.academy.gerenciador.modelo.Banco;
import br.com.vita.academy.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RemoveEmpresa implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Removendo Empresa");
        Integer id = Integer.valueOf(request.getParameter("id"));

        Banco banco = new Banco();
        banco.removeEmpresa(id);

        return "redirect:entrada?acao=ListaEmpresas";
    }
}
