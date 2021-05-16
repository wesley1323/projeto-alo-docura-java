package com.model;

public class Cliente {
	private int id;
	private String nome, cpf, telefone,endereco, bairro, cidade, estado, pagamento;
	
	public Cliente() {
		
	}
	
	public Cliente(int id, String nome, String cpf, String telefone, String endereco, String bairro, String cidade, String estado) {
		this.id=id;
		this.nome=nome;
		this.cpf=cpf;
		this.setTelefone(telefone);
		this.endereco=endereco;
		this.bairro=bairro;
		this.cidade=cidade;
		this.estado=estado;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}
	

}
