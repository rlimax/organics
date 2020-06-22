package controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.ProdutoDao;
import modelo.ListaProduto;

@WebServlet(urlPatterns = "/listaItem")
public class ServletLista extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		String linha = null;
		PrintWriter out = resp.getWriter();
		try {
			BufferedReader reader = req.getReader();
			while((linha = reader.readLine())!=null) {
				sb.append(linha);
			}

		} catch (Exception e) {
			System.out.print("Erro no tratamento da string de origem Javascript.");
		}
		//System.out.println(sb.toString().replace("null,", "").replace("\"id\"", "\"idProduto\""));
		String sgListaProduto = sb.toString().replace("null,", "").replace("\"id\"", "\"idProduto\"").replace(",null", ""); 
		//System.out.println(sb.toString());
				
		HttpSession sessao = req.getSession();
		sessao.setAttribute("list-item-json", sgListaProduto);
		
		Gson gson = new Gson();
		ListaProduto[] lsProduto;
		lsProduto = gson.fromJson(sgListaProduto, ListaProduto[].class);
		
		ProdutoDao dao = new ProdutoDao();
		for(ListaProduto item : lsProduto) {
			item.setProduto(dao.listarId(item.getIdProduto()));
			//System.out.println(item);
		}
		
		sessao.setAttribute("lsProduto", lsProduto);

		out.print("form-cliente.jsp");
	}
	
}
