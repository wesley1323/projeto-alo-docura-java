package com.model;

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
}
