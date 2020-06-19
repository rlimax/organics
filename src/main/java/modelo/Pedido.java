package modelo;

import java.time.LocalDate;

public class Pedido {
	private int id;
	private LocalDate dataPedido;
	private LocalDate dataEntrega;
	private float totalPedido;
	private Cliente cliente;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}
	public LocalDate getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(LocalDate dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public float getTotalPedido() {
		return totalPedido;
	}
	public void setTotalPedido(float totalPedido) {
		this.totalPedido = totalPedido;
	}
}
