package br.com.harzer.nfe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.harzer.nfe.dao.ClienteDaoImpl;
import br.com.harzer.nfe.dao.IClienteDao;
import br.com.harzer.nfe.model.Cliente;

@Service("clienteService")
@Transactional
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteDao dao;

	@Override
	public Cliente findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void saveCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		dao.saveCliente(cliente);
	}

	@Override
	public void updateCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		Cliente entity = dao.findById(cliente.getIdCliente());
		if (entity != null) {
			entity.setNomeRazaoSocial(cliente.getNomeRazaoSocial());
			entity.setCnpj(cliente.getCnpj());
			entity.setCpf(cliente.getCpf());
			entity.setInscricaoEstadual(cliente.getInscricaoEstadual());
			entity.setInscricaoSuframa(cliente.getInscricaoSuframa());
			entity.setIsentoIcms(cliente.isIsentoIcms());
			entity.setTipoDocumento(cliente.getTipoDocumento());
		}
	}

	@Override
	public void deleteClienteByCnpj(String cnpj) {
		// TODO Auto-generated method stub
		dao.deleteClienteByCnpj(cnpj);
	}

	@Override
	public void deleteClienteByCpf(String cpf) {
		// TODO Auto-generated method stub
		dao.deleteClienteByCpf(cpf);
	}

	@Override
	public List<Cliente> findAllClientes() {
		// TODO Auto-generated method stub
		return dao.findAllClientes();
	}

	@Override
	public Cliente findClienteByCnpj(String cnpj) {
		// TODO Auto-generated method stub
		return dao.findClienteByCnpj(cnpj);
	}

	@Override
	public Cliente findClienteByCpf(String cpf) {
		// TODO Auto-generated method stub
		return dao.findClienteByCpf(cpf);
	}

	@Override
	public boolean isClienteCpfUnique(Integer id, String cpf) {
		// TODO Auto-generated method stub
		Cliente cliente = findClienteByCpf(cpf);
		return (cliente == null || ((id != null) && (cliente.getIdCliente() == id)));
	}

	@Override
	public boolean isClienteCnpjUnique(Integer id, String cnpj) {
		// TODO Auto-generated method stub
		Cliente cliente = findClienteByCnpj(cnpj);
		return (cliente == null || ((id != null) && (cliente.getIdCliente() == id)));
	}

}
