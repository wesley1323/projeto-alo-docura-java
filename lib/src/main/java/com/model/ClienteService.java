package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
	
	@Autowired
	ClienteDAO cdao;
	
	public void inserirCliente(Cliente c) {
		cdao.inserirCliente(c);
	}
	
	public Map<String, Object> getCliente(String cpf) {
		return cdao.getCliente(cpf);
	}
	
	public Map<String, Object> getClienteId(int id) {
		return cdao.getClienteId(id);
	}
	
	public List<Map<String, Object>> getClientes() {
		return cdao.getClientes();
	}
	
	public void updateCliente(int idCliente,Cliente cli) {
		cdao.updateCliente(idCliente, cli);
	}
	
	public void deleteCliente(int idCliente) {
		cdao.deleteCliente(idCliente);
	}
}
