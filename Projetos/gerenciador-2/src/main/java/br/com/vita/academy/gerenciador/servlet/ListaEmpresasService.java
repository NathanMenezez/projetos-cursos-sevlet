package br.com.vita.academy.gerenciador.servlet;

import br.com.vita.academy.gerenciador.modelo.Banco;
import br.com.vita.academy.gerenciador.modelo.Empresa;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/empresas")
public class ListaEmpresasService extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Banco banco = new Banco();
        List<Empresa> empresas = banco.getEmpresas();
        String valor = req.getHeader("Accept");

        if(valor.contains("xml")){
            resp.setContentType("application/xml");
            XStream xstream = new XStream();
            xstream.alias("empresa", Empresa.class);
            String xml = xstream.toXML(empresas);
            resp.getWriter().print(xml);
        }else if(valor.contains("json")){
            Gson gson = new Gson();
            resp.setContentType("application/json");
            resp.getWriter().print(gson.toJson(empresas));
        }else {
            resp.setContentType("application/json");
            resp.getWriter().println("{message: 'no content'}");
        }





    }
}
