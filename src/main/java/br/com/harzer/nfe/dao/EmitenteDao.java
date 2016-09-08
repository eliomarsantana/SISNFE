package br.com.harzer.nfe.dao;

import java.util.List;

import br.com.harzer.nfe.model.Emitente;

public interface EmitenteDao {

	Emitente findById(Integer id);

	void saveEmitente(Emitente emitente);

	void deleteEmitenteByCnpj(String cnpj);

	List<Emitente> findAllEmitentes();

	Emitente findEmitenteByCnpj(String cnpj);

}
