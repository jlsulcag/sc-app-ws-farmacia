package com.sulcacorp.farmacia.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sulcacorp.farmacia.dao.IComprobanteDAO;
import com.sulcacorp.farmacia.model.Comprobante;
import com.sulcacorp.farmacia.service.IComprobanteService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

@Service
public class ComprobanteServiceImpl implements IComprobanteService{

	@Autowired
	private IComprobanteDAO dao;

	@Override
	public Comprobante save(Comprobante entity) throws CustomServiceException {
		return dao.saveAndFlush(entity);
	}

	@Override
	public Comprobante update(Comprobante entity) throws CustomServiceException {
		return dao.saveAndFlush(entity);
	}

	@Override
	public Comprobante findById(Long id) throws CustomServiceException {
		Optional<Comprobante> op = dao.findById(id);
		return op.isPresent()?op.get():null;
	}

	@Override
	public List<Comprobante> findAllAct() throws CustomServiceException {
		return dao.findAll();
	}

	@Override
	public void delete(Long id) throws CustomServiceException {
		dao.deleteById(id);
	}

	@Override
	public Comprobante registrarTransac(Comprobante entity) {
		entity.getItems().forEach(item -> item.setComprobante(entity));
		return dao.saveAndFlush(entity);
	}

	@Override
	public Comprobante updateStatus(Comprobante entity) throws CustomServiceException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
