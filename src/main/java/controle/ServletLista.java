package controle;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/listaItem")
public class ServletLista extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuffer sb = new StringBuffer();
		String linha = null;
		try {
			BufferedReader reader = req.getReader();
			while((linha = reader.readLine())!=null) {
				sb.append(linha);
			}
		} catch (Exception e) {

		}
		System.out.print(sb.toString());
	}
	
}
