package com.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProdutoDAO {
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirProduto(Produto produto) {
		String sql = "INSERT INTO produto (imgProduto,nomeProduto,descProduto,valor) VALUES (?,?,?,?)";
		Object obj [] = new Object[4];
		obj[0] = produto.getImgProduto();
		obj[1] = produto.getNomeProduto();
		obj[2] = produto.getDescProduto();
		obj[3] = produto.getValor();
		
		jdbc.update(sql,obj);
	}
}
