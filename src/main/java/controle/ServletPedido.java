package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDao;
import modelo.Cliente;

@WebServlet(urlPatterns = "/ServletPedido")
public class ServletPedido extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1 - gravar cliente no BD
		ClienteDao daoCliente = new ClienteDao();
		
		HttpSession sessao = req.getSession();
		Cliente cliente = (Cliente) sessao.getAttribute("ObjCliente");
		
		daoCliente.incluir(cliente);
	}

}
