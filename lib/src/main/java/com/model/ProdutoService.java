package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	@Autowired
	ProdutoDAO pdao;
	
	public void inserirProduto(Produto p) {
		pdao.inserirProduto(p);
	}
	
	public Map<String, Object> getProduto(int idProduto) {
		return pdao.getProduto(idProduto);
	}
	
	public List<Map<String, Object>> getProdutos() {
		return pdao.getProdutos();
	}
	
	public void updateProduto(int idProduto, Produto prod) {
		  pdao.updateProduto(idProduto, prod);
	}
	
	public void deleteProduto(int idProduto) {
		pdao.deleteProduto(idProduto);
	}
}
