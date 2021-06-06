package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PedidoDAO {
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirPedido(Pedido pedido) {
		String sql = "INSERT INTO pedido(idCliente,data,hora,pagamento) VALUES (?,CURRENT_DATE,CURRENT_TIME,?)";
		Object obj [] = new Object[2];
		obj[0] = pedido.getIdCliente();
		obj[1] = pedido.getPagamento();
		
		jdbc.update(sql,obj);
	}
	
	public void adicionarProduto(Pedido pedido) {
		String sql = "INSERT INTO pedidoProduto (idPedido, idProduto, quantidade) VALUES (?,?,?)";
		Object obj [] = new Object[3];
		obj[0] = pedido.getIdCliente();
		obj[1] = pedido.getIdProduto();
		obj[2] = pedido.getQuantidade();
		
		jdbc.update(sql,obj);
	}
	
	public List<Map<String, Object>> getPedidos() {
    	String sql = "SELECT * FROM pedido";
    	List<Map<String, Object>> pedidos = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return pedidos;
    }
	
	 public void deletePedido(int idPedido) {
		String sqlPP = "DELETE FROM pedidoproduto WHERE idPedido = ?" ;
		jdbc.update(sqlPP, new Object[] {idPedido});
		
		String sqlP = "DELETE FROM pedido WHERE idPedido = ?" ;
		jdbc.update(sqlP, new Object[] {idPedido});
	 }
}
