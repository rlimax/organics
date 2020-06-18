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
			PreparedStatement sql = con.prepareStatement("select id_produto, nm_produto, vl_produto from produto");
			ResultSet resultado = sql.executeQuery();
			while(resultado.next()) {
				Produto p = new Produto();
				p.setId(resultado.getInt("id_produto"));
				//p.setCategoria(resultado.getInt("id_categoria_fk"));
				p.setNome(resultado.getString("nm_produto"));
				p.setValor(resultado.getFloat("vl_produto"));
				ls.add(p);
			}
		} catch (Exception e) {
			System.out.println("Erro Listar Produtos");
		}
		return ls;
	}
	
	public Produto listarId(int id){
		Produto p = new Produto();

		try {
			Connection con = Conexao.getConectar();
			PreparedStatement sql = con.prepareStatement("select * from produto where id_produto = ?");
			sql.setInt(1, id);
			ResultSet resultado = sql.executeQuery();
			while(resultado.next()) {
				p.setId(resultado.getInt("id_produto"));
				//p.setCategoria(resultado.getInt("id_categoria_fk"));
				p.setNome(resultado.getString("nm_produto"));
				p.setValor(resultado.getFloat("vl_produto"));
			}
		} catch (Exception e) {
			System.out.println("Erro Listar ID");
		}
		return p;
	}
}
