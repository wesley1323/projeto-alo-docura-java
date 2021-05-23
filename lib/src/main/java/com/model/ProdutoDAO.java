package com.model;

import java.util.List;
import java.util.Map;

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
	
	public Map<String, Object> getProduto(int idProduto) {
    	String sql = "SELECT * FROM produto WHERE idProduto = ?";
    	return jdbc.queryForMap(sql,new Object[] {idProduto});
    }
	
	public List<Map<String, Object>> getProdutos() {
    	String sql = "SELECT * FROM produto";
    	List<Map<String, Object>> produtos = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return produtos;
    }
	
	 public void updateProduto(int idProduto,Produto prod) {
    	String sql = "UPDATE produto SET imgProduto = ?, nomeProduto = ?, descProduto = ?, valor = ? WHERE idProduto = ?";
    	 jdbc.update(sql, new Object[]{
         		prod.getImgProduto(),prod.getNomeProduto(), prod.getDescProduto(), prod.getValor(), idProduto
         });
	 }
	 
	 public void deleteProduto(int idProduto) {
		/*String sqlPP = "DELETE FROM produtoPedido WHERE idProduto = ?";
		jdbc.update(sqlPP, new Object[] {idProduto});*/
		 
		String sqlP = "DELETE FROM produto WHERE idProduto = ?" ;
		jdbc.update(sqlP, new Object[] {idProduto});
	 }
}
