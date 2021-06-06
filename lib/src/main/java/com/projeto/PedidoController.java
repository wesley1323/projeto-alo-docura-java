package com.projeto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Pedido;
import com.model.PedidoService;
import com.model.Produto;

@Controller
@ComponentScan("com.model")
public class PedidoController {
	@Autowired
	private ApplicationContext context;
	
	@PostMapping("/confpedido")
	public String postPedido(@ModelAttribute Pedido ped, @ModelAttribute Produto pro, Model model) {
		PedidoService pds = context.getBean(PedidoService.class);		
		pds.inserirPedido(ped);
		pds.adicionarProduto(ped);
		return "confpedido";
	}
	
	@PostMapping("/delpedido/{idPedido}")
	public String deletePedido(@PathVariable("idPedido") int id,Model model) {
		PedidoService pddao = context.getBean(PedidoService.class);
		pddao.deletePedido(id);
		return "redirect:/admin";
	}
}
