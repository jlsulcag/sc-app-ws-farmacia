package com.sulcacorp.farmacia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sulcacorp.farmacia.dao.IEstadoCivilDAO;
import com.sulcacorp.farmacia.model.EstadoCivil;
import com.sulcacorp.farmacia.service.IEstadoCivilService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

@Service
public class EstadoCivilServiceImpl implements IEstadoCivilService{

	@Autowired
	private IEstadoCivilDAO dao;
	
	@Override
	public EstadoCivil save(EstadoCivil entity) throws CustomServiceException {
		entity.setDescripcion(entity.getDescripcion().toUpperCase());
		return dao.saveAndFlush(entity);
	}

	@Override
	public EstadoCivil update(EstadoCivil entity) throws CustomServiceException {
		entity.setDescripcion(entity.getDescripcion().toUpperCase());
		return dao.saveAndFlush(entity);
	}

	@Override
	public EstadoCivil findById(Long id) throws CustomServiceException {
		Optional<EstadoCivil> op = dao.findById(id);
		return op.isPresent()?op.get():null;
	}

	@Override
	public List<EstadoCivil> findAllAct() throws CustomServiceException {
		return dao.findAllAct();
	}

	@Override
	public void delete(Long id) throws CustomServiceException {
		dao.deleteById(id);	
	}

	@Override
	public EstadoCivil updateStatus(EstadoCivil entity) throws CustomServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
