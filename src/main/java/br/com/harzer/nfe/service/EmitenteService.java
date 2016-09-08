package br.com.harzer.nfe.service;

import java.util.List;

import br.com.harzer.nfe.model.Emitente;

public interface EmitenteService {

	Emitente findById(int id);

	void saveEmitente(Emitente emitente);

	void updateEmitente(Emitente emitente);

	void deleteEmitenteByCnpj(String cnpj);

	List<Emitente> findAllEmitentes();

	Emitente findEmitenteByCnpj(String cnpj);

	boolean isEmitenteCnpjUnique(Integer id, String cnpj);

}
