package br.com.harzer.nfe.service;

import java.util.List;

import br.com.harzer.nfe.model.Cliente;

public interface IClienteService {
	Cliente findById(int id);

	void saveCliente(Cliente cliente);

	void updateCliente(Cliente cliente);

	void deleteClienteByCnpj(String cnpj);

	void deleteClienteByCpf(String cpf);

	List<Cliente> findAllClientes();

	Cliente findClienteByCnpj(String cnpj);

	Cliente findClienteByCpf(String cpf);

	boolean isClienteCpfUnique(Integer id, String Cpf);

	boolean isClienteCnpjUnique(Integer id, String cnpj);
}
