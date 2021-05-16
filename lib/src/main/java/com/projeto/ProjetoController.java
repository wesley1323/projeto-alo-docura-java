package com.projeto;

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


@Controller
@ComponentScan("com.model")
public class ProjetoController {
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/cardapio")
	public String cardapio() {
		return "cardapio";
	}
	
	@GetMapping("/delivery")
	public String formCliente(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "delivery";
	}
	
	@PostMapping("/pedido")
	public String postCliente(@ModelAttribute Cliente cli, Model model) {
		ClienteService cs = context.getBean(ClienteService.class);
		cs.inserirCliente(cli);
		return "pedido";
	}
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
}
