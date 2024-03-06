package br.com.fiap.produtomvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.produtomvc.models.Produto;
import br.com.fiap.produtomvc.repositories.ProdutoReporitory;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoReporitory repository;
	
	@GetMapping("/novo")
	public String adicionarProduto(Model model) {
		
		model.addAttribute("produto", new Produto());
		return "produto/novo-produto";
		
	}
	
//	@PostMapping
//	public String insertProduto() {
//		
//		
//		return "redirect:/Produtos";
//	}
	
//	@PostMapping("/salvar")
//	public String insertProduto(Produto produto) {
//		repository.save(produto);
////		System.out.println(produto.toString());
//		
//		return "redirect:/produtos/novo";
//	}
	
	@GetMapping("/listar")
	public String listarProdutos(Model model) {
		model.addAttribute("produtos", repository.findAll());
		return "/produto/listar-produtos";
	}
	
	@PostMapping("/salvar")
	public String insertProduto(@Valid Produto produto,
								BindingResult result,
								RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return "/produto/novo-produto";
		}
		
		repository.save(produto);
		attributes.addFlashAttribute("mensagem", "Produto salvo com sucesso");
		
		return "redirect:/produtos/novo";
	}
	
}
