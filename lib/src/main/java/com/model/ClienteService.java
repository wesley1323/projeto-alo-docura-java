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
	
	public List<Map<String, Object>> getClientes() {
		return cdao.getClientes();
	}
}
