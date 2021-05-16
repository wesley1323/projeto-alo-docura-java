package com.projeto;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Cliente;
import com.model.ClienteService;
import com.model.Pedido;
import com.model.PedidoService;
import com.model.Produto;
import com.model.ProdutoService;


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
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
	
	@GetMapping("/delivery")
	public String formCliente(Model model) {
		model.addAttribute("cliente",new Cliente());
		return "delivery";
	}
	
	@PostMapping("/confpedido")
	public String postCliente(@ModelAttribute Cliente cli, Model model) {
		ClienteService cs = context.getBean(ClienteService.class);
		cs.inserirCliente(cli);
		
		model.addAttribute("pedido",new Pedido());
		return "confpedido";
		
	}
	@GetMapping("/pedido")
	public String postPedido(@ModelAttribute Pedido ped, @RequestParam(name="idCliente", required=true) int idCliente,Model model) {
		PedidoService pds = context.getBean(PedidoService.class);
		//model.addAttribute("idCliente",idCliente);
		//
		//Date d = new Date();
		//model.addAttribute("data",d.getDate());
		//model.addAttribute("hora",d.getTime());
		pds.inserirPedido(ped);
		return "pedido";
	}
	
	@GetMapping("/produto")
	public String formProduto(Model model) {
		model.addAttribute("produto",new Produto());
		return "produto";
	}
	
	@PostMapping("/sucesso")
	public String postProduto(@ModelAttribute Produto pro, Model model) {
		ProdutoService ps = context.getBean(ProdutoService.class);
		ps.inserirProduto(pro);
		return "sucesso";
	}
}
