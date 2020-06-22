package controle;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
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
		//2 - gravar pedido no BD		
		Pedido pedido = (Pedido) sessao.getAttribute("objPedido");
		pedido.setCliente(cliente);
		pedido.setDataPedido(LocalDate.now());
		
		PedidoDao daoPedido = new PedidoDao();
		daoPedido.incluir(pedido);
		
		//3 - gravar lista de produtos do pedido no BD
		ListaProduto[] lsProduto = (ListaProduto[]) sessao.getAttribute("lsProduto");
		ListaProdutoDao daoListaP = new ListaProdutoDao();
		String lsItem = "";
		for(ListaProduto item: lsProduto) {
			item.setIdPedido(pedido.getId());
			daoListaP.incluir(item);
			lsItem += "\n"+item.getProduto().getNome()+"|"+item.getQuantidade()+"|"+item.getTotal();
		}
		String fone = "5561985529838";
		String msg = "O cliente "+cliente.getNome()+"\nFez um pedido de número: "+ pedido.getId()+"\nProduto|Qtd |Total "+lsItem+"\nPara ser entregue em "+cliente.getEndereco();
		
		msg = URLEncoder.encode(msg, StandardCharsets.UTF_8.toString());
		resp.sendRedirect("https://api.whatsapp.com/send?phone="+fone+"&text="+msg);
	}

}
