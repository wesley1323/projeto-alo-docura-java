package com.model;

public class Pedido {
	private int idPedido;
	private int idCliente;
	private String data;
	private String hora;
	private String pagamento;
	
	public Pedido() {}
	
	public Pedido(int idCliente) {
		this.idCliente=idCliente;
	}
	
	public Pedido(int idPedido, int idCliente, String data, String hora, String pagamento) {
		this.idPedido=idPedido;
		this.idCliente=idCliente;
		this.data=data;
		this.hora=hora;
		this.pagamento=pagamento;
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
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
}
