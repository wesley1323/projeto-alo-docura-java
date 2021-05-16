package com.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirCliente(Cliente cliente) {
		String sql = "INSERT INTO cliente(nome,cpf,telefone,endereco,bairro,cidade,estado,pagamento)" +
	                 " VALUES (?,?,?,?,?,?,?,?)";
		Object[] obj = new Object[8];
		obj[0] = cliente.getNome();
		obj[1] = cliente.getCpf();
		obj[2] = cliente.getTelefone();
		obj[3] = cliente.getEndereco();
		obj[4] = cliente.getBairro();
		obj[5] = cliente.getCidade();
		obj[6] = cliente.getEstado();
		obj[7] = cliente.getPagamento();
		
		jdbc.update(sql, obj);
	}
	
	
}
