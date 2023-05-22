package br.com.vita.academy.gerenciador.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Acao{

    public String executa(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        //session.removeAttribute("usuarioLogado"); remove o atributo da sessão
        session.invalidate(); //invalida a sessão excluindo ela

        return "redirect:entrada?acao=LoginForm";
    }
}
