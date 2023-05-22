package br.com.vita.academy.gerenciador.acao;

import br.com.vita.academy.gerenciador.modelo.Banco;
import br.com.vita.academy.gerenciador.modelo.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login implements Acao{
    public String executa(HttpServletRequest request, HttpServletResponse response) {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        System.out.println("Logando: " + login);

        Banco banco = new Banco();

        Usuario usuario = banco.existeUsuario(login, senha);

        if(usuario != null){
            System.out.println("Usuario Existe!");
            HttpSession session = request.getSession();

            session.setAttribute("usuarioLogado", usuario);
            return "redirect:entrada?acao=ListaEmpresas";
        }else{
            return "redirect:entrada?acao=LoginForm";
        }


    }
}
