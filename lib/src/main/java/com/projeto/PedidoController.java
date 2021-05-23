package com.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Pedido;
import com.model.PedidoService;

@Controller
@ComponentScan("com.model")
public class PedidoController {
	@Autowired
	private ApplicationContext context;
	
	@PostMapping("/confpedido")
	public String postPedido(@ModelAttribute Pedido ped, Model model) {
		PedidoService pds = context.getBean(PedidoService.class);		
		pds.inserirPedido(ped);
		return "confpedido";
	}
}
