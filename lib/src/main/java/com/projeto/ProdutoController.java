package com.projeto;

import java.math.BigDecimal;
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

import com.model.Produto;
import com.model.ProdutoService;

@Controller
@ComponentScan("com.model")
public class ProdutoController {
	@Autowired
	private ApplicationContext context;
	
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
	
	@GetMapping("/editproduto/{idProduto}")
    public String atualizaProduto(@PathVariable("idProduto") int idProduto, Model model){
		ProdutoService pdao = context.getBean(ProdutoService.class);
		Map<String,Object> antigo = pdao.getProduto(idProduto);
		
		BigDecimal bd = (BigDecimal)antigo.get("valor");
		Produto prod = new Produto((String)antigo.get("imgProduto"),(String)antigo.get("nomeProduto"),(String)antigo.get("descProduto"),bd.doubleValue());
		model.addAttribute("antigo",prod);
		model.addAttribute("idProduto",idProduto);
		return "editproduto";
    }
	
	@PostMapping("/editproduto/{idProduto}")
	public String update(@PathVariable("idProduto") int idProduto,@ModelAttribute Produto prod, Model model) {
		ProdutoService pdao = context.getBean(ProdutoService.class);
		pdao.updateProduto(idProduto, prod);
		return "redirect:/admin";
	}
	
	@PostMapping("/delproduto/{idProduto}")
	public String delete(@PathVariable("idProduto") int id,Model model) {
		ProdutoService pdao = context.getBean(ProdutoService.class);
		pdao.deleteProduto(id);
		return "redirect:/admin";
	}
}
