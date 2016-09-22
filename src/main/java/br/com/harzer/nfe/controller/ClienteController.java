package br.com.harzer.nfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.harzer.nfe.model.Cliente;
import br.com.harzer.nfe.service.IClienteService;

@Controller
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	IClienteService service;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/list" }, method = RequestMethod.GET)
	public ModelAndView listClientes(ModelAndView model) {
		List<Cliente> clientes = service.findAllClientes();
		ModelAndView modelAndView = new ModelAndView("cliente/allclientes");
		model.addObject("clientes", clientes);
		return modelAndView;
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newCliente(ModelMap model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("edit", false);
		return "cliente/registrationcliente";
	}

	@RequestMapping(value = { "/delete-{cnpj}-cliente" }, method = RequestMethod.GET)
	public String deleteCliente(@PathVariable String cnpj) {
		service.deleteClienteByCnpj(cnpj);
		return "redirect:/list";
	}

}
