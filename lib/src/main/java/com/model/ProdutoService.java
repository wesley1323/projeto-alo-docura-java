package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
	@Autowired
	ProdutoDAO pdao;
	
	public void inserirProduto(Produto p) {
		pdao.inserirProduto(p);
	}
}
