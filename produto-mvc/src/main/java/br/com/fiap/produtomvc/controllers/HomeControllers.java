package br.com.fiap.produtomvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllers {

	@RequestMapping("/")
	public String index(Model model) {
		
		model.addAttribute("msg", "Bem-vindo(a) à UNIP!");
		return "/produto/index";
		
	}
	
}
