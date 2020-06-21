package controle;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ClienteDao;
import dao.ListaProdutoDao;
import dao.PedidoDao;
import modelo.Cliente;
import modelo.ListaProduto;
import modelo.Pedido;

@WebServlet(urlPatterns = "/ServletPedido")
public class ServletPedido extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1 - gravar cliente no BD
		ClienteDao daoCliente = new ClienteDao();
		
		HttpSession sessao = req.getSession();
		Cliente cliente = (Cliente) sessao.getAttribute("objCliente");
		daoCliente.incluir(cliente);
		
		Pedido pedido = (Pedido) sessao.getAttribute("objPedido");
		pedido.setCliente(cliente);
		pedido.setDataPedido(LocalDate.now());
		
		PedidoDao daoPedido = new PedidoDao();
		daoPedido.incluir(pedido);
		
		ListaProduto[] lsProduto = (ListaProduto[]) sessao.getAttribute("lsProduto");
		ListaProdutoDao daoListaP = new ListaProdutoDao();
		for(ListaProduto item: lsProduto) {
			item.setIdPedido(pedido.getId());
			daoListaP.incluir(item);
		}
	}

}
