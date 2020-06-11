package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Produto;

public class ProdutoDao {
	public List<Produto> listar(){
		List<Produto> ls = new ArrayList<Produto>();
		 

		//df.format(1234.36); 
		try {
			Connection con = Conexao.getConectar();
			PreparedStatement sql = con.prepareStatement("select * from produto");
			ResultSet resultado = sql.executeQuery();
			while(resultado.next()) {
				Produto p = new Produto();
				p.setId(resultado.getInt("id_produto"));
				p.setCategoria(resultado.getInt("id_categoria_fk"));
				p.setNome(resultado.getString("nm_produto"));
				p.setValor(resultado.getFloat("vl_produto"));
				ls.add(p);
			}
		} catch (Exception e) {

		}
		return ls;
	}
}
