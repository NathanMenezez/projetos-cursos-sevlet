package br.com.vita.academy.gerenciador.acao;

import br.com.vita.academy.gerenciador.modelo.Banco;
import br.com.vita.academy.gerenciador.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class NovaEmpresa implements Acao{
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("Cadastrando nova empresa");

        String nome = request.getParameter("nome");
        String data = request.getParameter("data");

        Empresa empresa = new Empresa();
        empresa.setNome(nome);

        try {
            empresa.setDataAbertura(simpleDateFormat.parse(data));
        } catch (ParseException e) {

        }

        Banco banco = new Banco();
        empresa.setId(banco.getEmpresas().size());
        banco.adiciona(empresa);

        request.setAttribute("empresa", empresa.getNome());

        return "redirect:entrada?acao=ListaEmpresas";
    }
}
