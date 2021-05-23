package com.model;

public class Produto {
	
	private int idProduto;
	private String imgProduto, nomeProduto, descProduto;
	private double valor;
	
	public Produto() {}
	
	public Produto(String imgProduto, String nomeProduto, String descProduto, double valor) {
		this.imgProduto=imgProduto;
		this.nomeProduto=nomeProduto;
		this.descProduto=descProduto;
		this.valor=valor;
	}
	
	public Produto(int idProduto, String imgProduto, String nomeProduto, String descProduto, double valor) {
		this.idProduto=idProduto;
		this.imgProduto=imgProduto;
		this.nomeProduto=nomeProduto;
		this.descProduto=descProduto;
		this.valor=valor;
	}
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	
	public String getImgProduto() {
		return imgProduto;
	}
	public void setImgProduto(String imgProduto) {
		this.imgProduto = imgProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public String getDescProduto() {
		return descProduto;
	}
	public void setDescProduto(String descProduto) {
		this.descProduto = descProduto;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
}