package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelo.Cliente;
import modelo.Pedido;

public class PedidoDao {

	public void incluir(Pedido pedido) {
		try {
				Connection conexao = Conexao.getConectar();
				PreparedStatement sql = conexao.prepareStatement("insert into pedido(dt_pedido, id_cliente_fk) values (?,?)",Statement.RETURN_GENERATED_KEYS);
				sql.setString(1, pedido.getDataPedido().toString());
				sql.setInt(2, pedido.getCliente().getId());
				sql.executeUpdate();
				
				ResultSet resultado = sql.getGeneratedKeys();
				resultado.next();
				pedido.setId(resultado.getInt(1));
				
			} catch (Exception e) {
				System.out.println("Erro ao incluir cliente.");
		}
	}

	
}
