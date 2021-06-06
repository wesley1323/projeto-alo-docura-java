package com.projeto;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Cliente;
import com.model.ClienteService;
import com.model.Pedido;
import com.model.ProdutoService;

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
		model.addAttribute("cli",c);
		model.addAttribute("pedido",new Pedido(c.getIdCliente()));
		
		ProdutoService pdao = context.getBean(ProdutoService.class);
		List<Map<String,Object>> produtos = pdao.getProdutos();
		model.addAttribute("produto",produtos);
		return "pedido";
	}
	
	@GetMapping("/editcliente/{idCliente}")
    public String atualizaCliente(@PathVariable("idCliente") int idCliente, Model model){
		ClienteService cdao = context.getBean(ClienteService.class);
		Map<String,Object> antigo = cdao.getClienteId(idCliente);
		
		Cliente cli = new Cliente((String)antigo.get("nome"),(String)antigo.get("cpf"),(String)antigo.get("telefone"),(String)antigo.get("endereco"),(String)antigo.get("bairro"),(String)antigo.get("cidade"),(String)antigo.get("estado"));
		model.addAttribute("antigo",cli);
		model.addAttribute("idCliente",idCliente);
		return "editcliente";
    }
	
	@PostMapping("/editcliente/{idCliente}")
	public String update(@PathVariable("idCliente") int idCliente,@ModelAttribute Cliente cli, Model model) {
		ClienteService cdao = context.getBean(ClienteService.class);
		cdao.updateCliente(idCliente, cli);
		return "redirect:/admin";
	}
	
	@PostMapping("/delcliente/{idCliente}")
	public String deleteCliente(@PathVariable("idCliente") int id,Model model) {
		ClienteService cdao = context.getBean(ClienteService.class);
		cdao.deleteCliente(id);
		return "redirect:/admin";
	}
}
