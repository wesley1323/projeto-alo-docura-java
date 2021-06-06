package com.model;

import java.util.List;
import java.util.Map;

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
		String sql = "INSERT INTO cliente(nome,cpf,telefone,endereco,bairro,cidade,estado)" +
	                 " VALUES (?,?,?,?,?,?,?)";
		Object[] obj = new Object[7];
		obj[0] = cliente.getNome();
		obj[1] = cliente.getCpf();
		obj[2] = cliente.getTelefone();
		obj[3] = cliente.getEndereco();
		obj[4] = cliente.getBairro();
		obj[5] = cliente.getCidade();
		obj[6] = cliente.getEstado();
		
		jdbc.update(sql, obj);
	}
	
	public Map<String, Object> getCliente(String cpf) {
    	String sql = "SELECT * FROM cliente WHERE cpf = ?";
    	Object[] obj = new Object[1];
		obj[0] = cpf;
    	return jdbc.queryForMap(sql,obj);
    }
	
	public Map<String, Object> getClienteId(int id) {
    	String sql = "SELECT * FROM cliente WHERE idCliente = ?";
    	Object[] obj = new Object[1];
		obj[0] = id;
    	return jdbc.queryForMap(sql,obj);
    }
	
	public List<Map<String, Object>> getClientes() {
    	String sql = "SELECT * FROM cliente";
    	List<Map<String, Object>> clientes = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return clientes;
    }
	
	public void updateCliente(int idCliente,Cliente cli) {
    	String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, endereco = ?, bairro = ?, cidade = ?, estado = ?  WHERE idCliente = ?";
    	 jdbc.update(sql, new Object[]{
         		cli.getNome(),cli.getCpf(),cli.getTelefone(),cli.getEndereco(),cli.getBairro(),cli.getCidade(),cli.getEstado(), idCliente
         });
	 }
	
	public void deleteCliente(int idCliente) {
		String sqlP = "DELETE FROM pedido WHERE idCliente = ?";
		jdbc.update(sqlP, new Object[] {idCliente});
		
		String sqlC = "DELETE FROM cliente WHERE idCliente = ?";
		jdbc.update(sqlC, new Object[] {idCliente});
	 }
}
