package com.sulcacorp.farmacia.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sulcacorp.farmacia.dao.IComprobanteDetalleDAO;
import com.sulcacorp.farmacia.model.ComprobanteDetalle;
import com.sulcacorp.farmacia.service.IComprobanteDetalleService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

@Service
public class ComprobanteDetalleServiceImpl implements IComprobanteDetalleService{

	@Autowired
	private IComprobanteDetalleDAO dao;

	@Override
	public ComprobanteDetalle save(ComprobanteDetalle entity) throws CustomServiceException {
		return dao.saveAndFlush(entity);
	}

	@Override
	public ComprobanteDetalle update(ComprobanteDetalle entity) throws CustomServiceException {
		return dao.saveAndFlush(entity);
	}

	@Override
	public ComprobanteDetalle findById(Long id) throws CustomServiceException {
		Optional<ComprobanteDetalle> op = dao.findById(id);
		return op.isPresent()?op.get():null;
	}

	@Override
	public List<ComprobanteDetalle> findAllAct() throws CustomServiceException {
		return dao.findAll();
	}

	@Override
	public void delete(Long id) throws CustomServiceException {
		dao.deleteById(id);
	}

	@Override
	public ComprobanteDetalle updateStatus(ComprobanteDetalle entity) throws CustomServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	


	
}
