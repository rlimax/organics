package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import modelo.Cliente;

public class ClienteDao {

	public void incluir(Cliente cliente) {
		try {
				Connection conexao = Conexao.getConectar();
				PreparedStatement sql = conexao.prepareStatement("insert into cliente(nm_cliente, end_cliente, telefone) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
				sql.setString(1, cliente.getNome());
				sql.setString(2, cliente.getEndereco());
				sql.setString(3, cliente.getTelefone());

				sql.executeUpdate();
				
				ResultSet resultado = sql.getGeneratedKeys();
				resultado.next();
				cliente.setId(resultado.getInt(1));
				sql.close();
				conexao.close();
				
			} catch (Exception e) {
				System.out.println("Erro ao incluir cliente.");
		}
	}
	
}
