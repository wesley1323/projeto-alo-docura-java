package com.projeto;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.model.ClienteService;
import com.model.PedidoService;
import com.model.ProdutoService;


@Controller
@ComponentScan("com.model")
public class ProjetoController {
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/")
	public String home(Model model) {
		ProdutoService pdao = context.getBean(ProdutoService.class);
		List<Map<String,Object>> produtos = pdao.getProdutos();
		model.addAttribute("produto",produtos);
		return "index";
	}
	
	@GetMapping("/cardapio")
	public String cardapio(Model model) {
		ProdutoService pdao = context.getBean(ProdutoService.class);
		List<Map<String,Object>> produtos = pdao.getProdutos();
		model.addAttribute("produto",produtos);
		return "cardapio";
	}
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		ClienteService cdao = context.getBean(ClienteService.class);
		List<Map<String,Object>> clientes = cdao.getClientes();
		model.addAttribute("cliente",clientes);
		
		ProdutoService pdao = context.getBean(ProdutoService.class);
		List<Map<String,Object>> produtos = pdao.getProdutos();
		model.addAttribute("produto",produtos);
		
		PedidoService pddao = context.getBean(PedidoService.class);
		List<Map<String,Object>> pedidos = pddao.getPedidos();
		model.addAttribute("pedido",pedidos);
		return "admin";
	}
}
