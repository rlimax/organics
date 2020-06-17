package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Cliente;


@WebServlet(urlPatterns = "/servletCliente")
public class servletCliente extends HttpServlet{

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Cliente cliente = new Cliente();
		cliente.setNome(req.getParameter("nome"));
		cliente.setTelefone(req.getParameter("telefone"));
		cliente.setEndereco(req.getParameter("endereco")+" - "+req.getParameter("cidade"));
		System.out.print(cliente.toString());
	}
}
