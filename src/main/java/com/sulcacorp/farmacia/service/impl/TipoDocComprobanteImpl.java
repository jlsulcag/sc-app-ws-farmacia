package com.sulcacorp.farmacia.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sulcacorp.farmacia.dao.ITipoDocComprobanteDAO;
import com.sulcacorp.farmacia.model.TipoDocComprobante;
import com.sulcacorp.farmacia.service.ITipoDocComprobanteService;
import com.sulcacorp.farmacia.service.exception.CustomServiceException;

@Service
public class TipoDocComprobanteImpl implements ITipoDocComprobanteService{
	
	@Autowired
	private ITipoDocComprobanteDAO dao;

	@Override
	public TipoDocComprobante save(TipoDocComprobante entity) throws CustomServiceException {
		return dao.saveAndFlush(entity);
	}

	@Override
	public TipoDocComprobante update(TipoDocComprobante entity) throws CustomServiceException {
		return dao.saveAndFlush(entity);
	}

	@Override
	public TipoDocComprobante findById(Long id) throws CustomServiceException {
		Optional<TipoDocComprobante> op = dao.findById(id);
		return op.isPresent()?op.get(): null;
	}

	@Override
	public List<TipoDocComprobante> findAllAct() throws CustomServiceException {
		return dao.findAllAct();
	}

	@Override
	public void delete(Long id) throws CustomServiceException {
		dao.deleteById(id);		
	}

	@Override
	public TipoDocComprobante updateStatus(TipoDocComprobante entity) throws CustomServiceException {
		// TODO Auto-generated method stub
		return null;
	}


}
