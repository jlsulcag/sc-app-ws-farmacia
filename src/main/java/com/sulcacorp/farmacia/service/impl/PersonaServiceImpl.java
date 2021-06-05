package com.sulcacorp.farmacia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sulcacorp.farmacia.dao.IPersonaDAO;
import com.sulcacorp.farmacia.model.Persona;
import com.sulcacorp.farmacia.service.IPersonaService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	private IPersonaDAO dao;

	@Override
	public Persona save(Persona entity) throws CustomServiceException {
		entity.setTipoPersona(1);
		entity.setEstadoCivil(1);
		return dao.saveAndFlush(entity);
	}

	@Override
	public Persona update(Persona entity) throws CustomServiceException {
		entity.setTipoPersona(1);
		entity.setEstadoCivil(1);
		return dao.saveAndFlush(entity);
	}

	@Override
	public Persona findById(Long id) throws CustomServiceException {
		Optional<Persona> op = dao.findById(id);
		return op.isPresent() ? op.get() : null;
	}

	@Override
	public List<Persona> findAllAct() throws CustomServiceException {
		return dao.findAllAct();
	}

	@Override
	public void delete(Long id) throws CustomServiceException {
		dao.deleteById(id);
	}

	@Override
	public Persona updateStatus(Persona entity) throws CustomServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Persona> findByFullname(String ref) throws CustomServiceException {
		return dao.findByFullname(ref);
	}

	@Override
	public Persona findByDocNumber(String ref) throws CustomServiceException {
		return dao.findByDocNumber(ref);
	}

	@Override
	public Persona findByTypeAndDocNumber(long type, String ref) throws CustomServiceException {
		return dao.findByTypeAndDocNumber(type, ref);
	}

}
