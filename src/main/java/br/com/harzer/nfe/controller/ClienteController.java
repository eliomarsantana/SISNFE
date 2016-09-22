package br.com.harzer.nfe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
		model = new ModelAndView("cliente/allclientes");
		List<Cliente> clientes = service.findAllClientes();
		model.addObject(clientes);
		return model;
	}

}
