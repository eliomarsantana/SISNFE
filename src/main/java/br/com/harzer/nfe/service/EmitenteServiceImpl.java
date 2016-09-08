package br.com.harzer.nfe.service;

import java.util.List;

import br.com.harzer.nfe.dao.EmitenteDao;
import br.com.harzer.nfe.model.Emitente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("emitenteService")
@Transactional
public class EmitenteServiceImpl implements EmitenteService {

	@Autowired
	private EmitenteDao dao;

	@Override
	public Emitente findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public void saveEmitente(Emitente emitente) {
		// TODO Auto-generated method stub
		dao.saveEmitente(emitente);
	}

	@Override
	public void updateEmitente(Emitente emitente) {
		// TODO Auto-generated method stub
		Emitente entity = dao.findById(emitente.getIdEmitente());
		if (entity != null) {
			entity.setNomeFantasia(emitente.getNomeFantasia());
			entity.setNomeRazaoSocial(emitente.getNomeRazaoSocial());
			entity.setCnpj(emitente.getCnpj());
			entity.setInscricaoEstadual(emitente.getInscricaoEstadual());
			entity.setInscricaoEstadual(emitente.getInscricaoMunicipal());
			entity.setCnaeFiscal(emitente.getCnaeFiscal());
			entity.setRegimeTributario(emitente.getRegimeTributario());
		}

	}

	@Override
	public void deleteEmitenteByCnpj(String cnpj) {
		// TODO Auto-generated method stub
		dao.deleteEmitenteByCnpj(cnpj);
	}

	@Override
	public List<Emitente> findAllEmitentes() {
		return dao.findAllEmitentes();
	}

	@Override
	public Emitente findEmitenteByCnpj(String cnpj) {
		// TODO Auto-generated method stub
		return dao.findEmitenteByCnpj(cnpj);
	}

	@Override
	public boolean isEmitenteCnpjUnique(Integer id, String cnpj) {
		// TODO Auto-generated method stub
		Emitente emitente = findEmitenteByCnpj(cnpj);
		return (emitente == null || ((id != null) && (emitente.getIdEmitente() == id)));

	}
}
