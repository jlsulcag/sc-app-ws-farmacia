package com.sulcacorp.farmacia.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sulcacorp.farmacia.dao.IEmisorDAO;
import com.sulcacorp.farmacia.model.Emisor;
import com.sulcacorp.farmacia.service.IEmisorService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

@Service
public class EmisorServiceImpl implements IEmisorService{
	
	@Autowired
	private IEmisorDAO dao;

	@Override
	public Emisor save(Emisor entity) throws CustomServiceException {
		return dao.saveAndFlush(entity);
	}

	@Override
	public Emisor update(Emisor entity) throws CustomServiceException {
		return dao.saveAndFlush(entity);
	}

	@Override
	public Emisor findById(Long id) throws CustomServiceException {
		Optional<Emisor> op = dao.findById(id);
		return op.isPresent()?op.get(): null;
	}

	@Override
	public List<Emisor> findAllAct() throws CustomServiceException {
		return dao.findAll();
	}

	@Override
	public void delete(Long id) throws CustomServiceException {
		dao.deleteById(id);		
	}

	@Override
	public Emisor updateStatus(Emisor entity) throws CustomServiceException {
		// TODO Auto-generated method stub
		return null;
	}


}
