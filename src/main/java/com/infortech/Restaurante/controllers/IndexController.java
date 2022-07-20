package com.infortech.Restaurante.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.infortech.Restaurante.classes.Cliente;
import com.infortech.Restaurante.classes.FormaPagamento;
import com.infortech.Restaurante.classes.Prato;
import com.infortech.Restaurante.repositorios.ClienteRepository;
import com.infortech.Restaurante.repositorios.FormaPagamentoRepository;
import com.infortech.Restaurante.repositorios.PratoRepository;

@Controller
public class IndexController {
	ClienteRepository cr = new ClienteRepository();
	PratoRepository pr = new PratoRepository();
	FormaPagamentoRepository fpr = new FormaPagamentoRepository();
	
	@RequestMapping("/")
	public String index(Model m) {
		
		return "index";
	}
	
	@RequestMapping("/cadastrar/cadastrar")
	public String cadastro(Model m){
		
		return "/cadastrar/cadastrar";		
	}
	

	@RequestMapping("/cadastro")
	public String cadastroB(Model m, Cliente c) {
		
		cr.create(c);
		m.addAttribute("msg", "Cliente cadastrado!");
		return "/cadastrar/cadastrar";
	}
	
	
	@RequestMapping("/login")
	public String login(Model m) {
		
		return "login";
	}
	
	@RequestMapping("/validaLogin")
	public String validaLogin(Cliente c, Model m){
		String cpfPassado = c.getCpf();
		String senhaPassada = c.getSenha();
		List<Cliente> list = cr.readAll(); 
		
		for(Cliente cliente : list) {
			if(cpfPassado.equals(cliente.getCpf()) && senhaPassada.equals(cliente.getSenha())) {
				List<Prato> listaPratos = pr.readAll();
				m.addAttribute("lp", listaPratos);
				return "paginaInicial";
			}
		}		
		
		m.addAttribute("error", "Login ou senha inválidos!");
		return "login";
	}
	
	@RequestMapping("/validaLoginAdmin")
	public String validaLoginAdmin(Cliente c, Model m){
		if(c.getNome().equals("admin") && c.getSenha().equals("admin")) {
			return "paginaInicialAdmin";
		} else {
			return "loginAdmin";
		}
	}
	
	
	@RequestMapping("/paginaInicial")
	public String paginaInicial(Model m) {		
		return "paginaInicial";
	}
	
	@RequestMapping("/paginaInicialAdmin")
	public String paginaInicialAdmin() {		
		return "paginaInicialAdmin";
	}
	
	@RequestMapping("/visualizaClientes")
	public String visualizaClientes(Model m) {
		List<Cliente> listCliente = cr.readAll();
		
		m.addAttribute("listaDeClientes", listCliente);
		return "visualizaClientes";
	}
	
	@RequestMapping("/cadastrarPratos")
	public String cadastrarPratos(Model m) {
		return "cadastrarPratos";
	}
	
	@RequestMapping("/realizaCadastroPrato")
	public String realizaCadastroPrato(Prato p, Model m) {
		pr.create(p);
		return "paginaInicialAdmin";
	}
	
	@RequestMapping("/cadastrarFormaPagamento")
	public String cadastrarFormaPagamento(Model m) {
		return "cadastrarFormaPagamento";
	}
	
	@RequestMapping("/realizaCadastroFormaPagamento")
	public String realizaCadastroFormaPagamento(FormaPagamento f, Model m) {
		fpr.create(f);		
		return "cadastrarFormaPagamento";
	}
	
	@RequestMapping("/loginAdmin")
	public String loginAdmin(Model m) {
		return "loginAdmin";
	}
}
