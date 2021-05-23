package com.projeto;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Cliente;
import com.model.ClienteService;
import com.model.Pedido;

@Controller
@ComponentScan("com.model")
public class ClienteController {
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/delivery")
	public String formCliente(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "delivery";
	}
	
	@PostMapping("/pedido")
	public String postCliente(@ModelAttribute Cliente cli, Model model) {
		ClienteService cs = context.getBean(ClienteService.class);
		cs.inserirCliente(cli);
		Map<String,Object> cliente = cs.getCliente(cli.getCpf());
		Cliente c = new Cliente((Integer)cliente.get("idCliente"));
		model.addAttribute("cliente",cli);
		model.addAttribute("pedido",new Pedido(c.getIdCliente()));
		
		return "pedido";
	}
}
