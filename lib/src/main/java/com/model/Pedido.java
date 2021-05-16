package com.model;

public class Pedido {
	private int idPedido;
	private String data, hora, pagamento;
	private Cliente idCliente;
	
	public Pedido() {
		
	}
	
	public Pedido(int idPedido, String data, String hora, String pagamento, Cliente idCliente) {
		this.idPedido=idPedido;
		this.data=data;
		this.hora=hora;
		this.pagamento=pagamento;
		this.idCliente=idCliente;
	}
	
	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	public String getPagamento() {
		return pagamento;
	}
	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	
	public Cliente getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}
	
}
