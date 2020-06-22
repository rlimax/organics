package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.ListaProduto;

public class ListaProdutoDao {

	public void incluir(ListaProduto lsProduto) {
		try {
				Connection conexao = Conexao.getConectar();
				PreparedStatement sql = conexao.prepareStatement("insert into lista_produto(id_produto, id_pedido, qtd_produto, vl_subtotal) values (?,?,?,?)");

				sql.setInt(1, lsProduto.getIdProduto());
				sql.setInt(2, lsProduto.getIdPedido());
				sql.setInt(3, lsProduto.getQuantidade());
				sql.setFloat(4, lsProduto.getTotal());
				
				sql.executeUpdate();
				
				ResultSet resultado = sql.getGeneratedKeys();
				resultado.next();
//				pedido.setId(resultado.getInt(1));
				sql.close();
				conexao.close();
			} catch (Exception e) {
				System.out.println("Erro ao incluir cliente.");
		}
	}

	
}
