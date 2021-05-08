package com.projeto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjetoController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/cardapio")
	public String cardapio() {
		return "cardapio";
	}
	
	@GetMapping("/delivery")
	public String delivery() {
		return "delivery";
	}
	
	@GetMapping("/sobre")
	public String sobre() {
		return "sobre";
	}
}
