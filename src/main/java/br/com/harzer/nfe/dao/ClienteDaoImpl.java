package br.com.harzer.nfe.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.harzer.nfe.model.Cliente;
import br.com.harzer.nfe.dao.AbstractDao;

@Repository("clienteDao")
public class ClienteDaoImpl extends AbstractDao<Integer, Cliente> implements IClienteDao {

	@Override
	public Cliente findById(Integer id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void saveCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		persist(cliente);
	}

	@Override
	public void deleteClienteByCnpj(String cnpj) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from cliente where cnpj = :cnpj");
		query.setString("cnpj", cnpj);
		query.executeUpdate();

	}

	@Override
	public void deleteClienteByCpf(String Cpf) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from cliente where Cpf = :Cpf");
		query.setString("Cpf", Cpf);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Cliente> findAllClientes() {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
		return (List<Cliente>) criteria.list();

	}

	@Override
	public Cliente findClienteByCnpj(String cnpj) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("cnpj", cnpj));
		return (Cliente) criteria.uniqueResult();
	}

	@Override
	public Cliente findClienteByCpf(String cpf) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("cpf", cpf));
		return (Cliente) criteria.uniqueResult();
	}

}
