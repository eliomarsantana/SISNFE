package br.com.harzer.nfe.dao;

import java.util.List;

import br.com.harzer.nfe.model.Cliente;

public interface IClienteDao {
	Cliente findById(Integer id);

	void saveCliente(Cliente cliente);

	void deleteClienteByCnpj(String cnpj);

	void deleteClienteByCpf(String Cpf);

	List<Cliente> findAllClientes();

	Cliente findClienteByCnpj(String cnpj);

	Cliente findClienteByCpf(String cpf);
}
