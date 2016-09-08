package br.com.harzer.nfe.dao;

import java.util.List;

import br.com.harzer.nfe.model.Emitente;
import br.com.harzer.nfe.dao.AbstractDao;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("emitenteDao")
public class EmitenteDaoImpl extends AbstractDao<Integer, Emitente> implements EmitenteDao {

	@Override
	public Emitente findById(Integer id) {
		// TODO Auto-generated method stub
		return getByKey(id);
	}

	@Override
	public void saveEmitente(Emitente emitente) {
		// TODO Auto-generated method stub
		persist(emitente);

	}

	@Override
	public void deleteEmitenteByCnpj(String cnpj) {
		// TODO Auto-generated method stub
		Query query = getSession().createSQLQuery("delete from Emitente where cnpj = :cnpj");
		query.setString("cnpj", cnpj);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Emitente> findAllEmitentes() {
		Criteria criteria = createEntityCriteria();
		return (List<Emitente>) criteria.list();
	}

	@Override
	public Emitente findEmitenteByCnpj(String cnpj) {
		// TODO Auto-generated method stub
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("cnpj", cnpj));
		return (Emitente) criteria.uniqueResult();
	}

}
