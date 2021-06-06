package com.model;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	@Autowired
	PedidoDAO pddao;
	
	public void inserirPedido(Pedido pd){
		pddao.inserirPedido(pd);
	}
	
	public void adicionarProduto(Pedido pd) {
		pddao.adicionarProduto(pd);
	}
	
	public List<Map<String, Object>> getPedidos() {
    	return pddao.getPedidos();
    }
	
	public void deletePedido(int idPedido) {
		pddao.deletePedido(idPedido);
	 }
}
