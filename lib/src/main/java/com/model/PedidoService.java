package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
	@Autowired
	PedidoDAO pddao;
	
	public void inserirPedido(Pedido pd) {
		pddao.inserirPedido(pd);
	}
}
