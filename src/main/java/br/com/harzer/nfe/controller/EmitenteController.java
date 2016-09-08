package br.com.harzer.nfe.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.harzer.nfe.model.Emitente;
import br.com.harzer.nfe.service.EmitenteService;

@Controller
@RequestMapping("/")
public class EmitenteController {

	@Autowired
	EmitenteService service;

	@Autowired
	MessageSource messageSource;

	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listEmitentes(ModelMap model) {

		List<Emitente> emitentes = service.findAllEmitentes();
		model.addAttribute("emitentes", emitentes);
		return "allemitentes";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmitente(ModelMap model) {
		Emitente emitente = new Emitente();
		model.addAttribute("emitente", emitente);
		model.addAttribute("edit", false);
		return "registrationemitente";
	}

	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmitente(@Valid Emitente emitente, BindingResult result, ModelMap model) {

		if (result.hasErrors()) {
			return "registrationemitente";
		}

		if (!service.isEmitenteCnpjUnique(emitente.getIdEmitente(), emitente.getCnpj())) {
			FieldError cnpjError = new FieldError("emitente", "cnpj", messageSource.getMessage("non.unique.cnpj",
					new String[] { emitente.getCnpj() }, Locale.getDefault()));
			result.addError(cnpjError);
			return "registrationemitente";
		}

		service.saveEmitente(emitente);

		model.addAttribute("success", "Emitente " + emitente.getNomeFantasia() + " cadastrado com sucesso");
		return "success";
	}

	@RequestMapping(value = { "/edit-{cnpj}-emitente" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String cnpj, ModelMap model) {
		Emitente emitente = service.findEmitenteByCnpj(cnpj);
		model.addAttribute("emitente", emitente);
		model.addAttribute("edit", true);
		return "registrationemitente";
	}

	@RequestMapping(value = { "/edit-{cnpj}-emitente" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Emitente emitente, BindingResult result, ModelMap model,
			@PathVariable String cnpj) {

		if (result.hasErrors()) {
			return "registrationemitente";
		}

		if (!service.isEmitenteCnpjUnique(emitente.getIdEmitente(), emitente.getCnpj())) {
			FieldError cnpjError = new FieldError("emitente", "cnpj", messageSource.getMessage("non.unique.cnpj",
					new String[] { emitente.getCnpj() }, Locale.getDefault()));
			result.addError(cnpjError);
			return "registrationemitente";
		}

		service.updateEmitente(emitente);

		model.addAttribute("success", "Emitente " + emitente.getNomeFantasia() + " atualizado com sucesso");
		return "success";
	}

	@RequestMapping(value = { "/delete-{cnpj}-emitente" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String cnpj) {
		service.deleteEmitenteByCnpj(cnpj);
		return "redirect:/list";
	}

}
